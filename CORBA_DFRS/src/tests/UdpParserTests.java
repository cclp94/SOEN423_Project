package tests;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import org.omg.CORBA.ORB;

import json.JSONReader;
import udp.UdpHelper;
import packet.BookFlightOperation;
import packet.EditFlightRecordOperation;
import packet.ExecuteOperationLogOperation;
import packet.GetBookedFlightCountOperation;
import packet.Operation;
import packet.Packet;

public class UdpParserTests {
	public static int BUFFER_SIZE = 50000;

	public static void main(String[] args) {		
		// Initialize ORB
		ORB orb = ORB.init(args, null);
		
		// Initialize ports configuration
		JSONReader jsonReader = new JSONReader();
		
		// Choose parser to test
		String username = "Jeremy";
		
		int udpPort = jsonReader.getPortForKeys(username, "");
		
		// Initialize UDP Parser			
		//UdpParser udpParser = new UdpParser(orb, udpPort);
		//new Thread(udpParser).start();
		
		testBookFlightOperation(udpPort);
		testGetBookedFlightCount(udpPort);
		testEditFlightRecordOperation(udpPort);
		testExecuteOperationLogOperation(udpPort);
	}

	private static void testBookFlightOperation(int port) {
		// Build the action for the packet
		BookFlightOperation bookFlightOperation = new BookFlightOperation.BuilderImpl("John").lastName("Doe")
				.address("Address").phoneNumber("PhoneNumber").destination("MTL|NDL").date("06/05/2016")
				.flightClass("FIRST").build();

		// Create a packet with the operation
		Packet packet = new Packet(Operation.BOOK_FLIGHT, bookFlightOperation);

		// Process the packet
		Packet result = processOperationPacket(packet, port);
		System.out.println(result);
	}

	private static void testGetBookedFlightCount(int port) {
		GetBookedFlightCountOperation getBookedFlightCountOperation = new GetBookedFlightCountOperation(
				"MTL1111|FIRST");

		Packet packet = new Packet(Operation.BOOKED_FLIGHTCOUNT, getBookedFlightCountOperation);

		Packet result = processOperationPacket(packet, port);
		System.out.println(result);
	}

	private static void testEditFlightRecordOperation(int port) {
		EditFlightRecordOperation editFlightRecordOperation = new EditFlightRecordOperation.BuilderImpl("MTL1111|0")
				.fieldName("EDIT|DESTINATION").newValue("NDL").build();
		
		Packet packet = new Packet(Operation.EDIT_FLIGHT, editFlightRecordOperation);

		Packet result = processOperationPacket(packet, port);
		System.out.println(result);
	}
	
	private static void testExecuteOperationLogOperation(int port) {
		ArrayList<Packet> operationLog = new ArrayList<Packet>();
		ExecuteOperationLogOperation executeOperationLogOperation = new ExecuteOperationLogOperation(operationLog);
		
		Packet packet = new Packet(Operation.EXECUTE_OPERATION_LOG, executeOperationLogOperation);

		Packet result = processOperationPacket(packet, port);
		System.out.println(result);
	}
	
	private static Packet processOperationPacket(Packet packet, int port) {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket();
			byte[] message = UdpHelper.getByteArray(packet);
			InetAddress host = InetAddress.getByName("localhost");
			int serverPort = port;
			DatagramPacket requestPacket = new DatagramPacket(message, message.length, host, serverPort);
			socket.send(requestPacket);
			byte[] buffer = new byte[BUFFER_SIZE];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			socket.receive(reply);
			Packet result = (Packet) UdpHelper.getObjectFromByteArray(reply.getData());
			return result;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
		return null;
	}
}

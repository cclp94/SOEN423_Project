package flight_reservation_system;


/**
* FlightReservationApp/FlightReservationHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from FlightReservationApp.idl
* Wednesday, November 30, 2016 11:30:31 o'clock PM EST
*/

abstract public class FlightReservationHelper
{
  private static String  _id = "IDL:FlightReservationApp/FlightReservation:1.0";

  public static void insert (org.omg.CORBA.Any a, flight_reservation_system.FlightReservation that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static flight_reservation_system.FlightReservation extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (flight_reservation_system.FlightReservationHelper.id (), "FlightReservation");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static flight_reservation_system.FlightReservation read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_FlightReservationStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, flight_reservation_system.FlightReservation value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static flight_reservation_system.FlightReservation narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof flight_reservation_system.FlightReservation)
      return (flight_reservation_system.FlightReservation)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      flight_reservation_system._FlightReservationStub stub = new flight_reservation_system._FlightReservationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static flight_reservation_system.FlightReservation unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof flight_reservation_system.FlightReservation)
      return (flight_reservation_system.FlightReservation)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      flight_reservation_system._FlightReservationStub stub = new flight_reservation_system._FlightReservationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}

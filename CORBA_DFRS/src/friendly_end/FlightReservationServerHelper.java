package friendly_end;


/**
* fe/FlightReservationServerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Jerem/Source/Repos/SOEN423_Project/CORBA_DFRS/src/FlightReservationServer.idl
* Tuesday, November 15, 2016 10:00:42 PM EST
*/

abstract public class FlightReservationServerHelper
{
  private static String  _id = "IDL:fe/FlightReservationServer:1.0";

  public static void insert (org.omg.CORBA.Any a, friendly_end.FlightReservationServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static friendly_end.FlightReservationServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (friendly_end.FlightReservationServerHelper.id (), "FlightReservationServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static friendly_end.FlightReservationServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_FlightReservationServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, friendly_end.FlightReservationServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static friendly_end.FlightReservationServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof friendly_end.FlightReservationServer)
      return (friendly_end.FlightReservationServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      friendly_end._FlightReservationServerStub stub = new friendly_end._FlightReservationServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static friendly_end.FlightReservationServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof friendly_end.FlightReservationServer)
      return (friendly_end.FlightReservationServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      friendly_end._FlightReservationServerStub stub = new friendly_end._FlightReservationServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}

package mark_replica.flight_reservation_system;

/**
* FlightReservationApp/FlightReservationHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from FlightReservationApp.idl
* Wednesday, November 30, 2016 11:30:31 o'clock PM EST
*/

public final class FlightReservationHolder implements org.omg.CORBA.portable.Streamable
{
  public mark_replica.flight_reservation_system.FlightReservation value = null;

  public FlightReservationHolder ()
  {
  }

  public FlightReservationHolder (mark_replica.flight_reservation_system.FlightReservation initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = mark_replica.flight_reservation_system.FlightReservationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
	  mark_replica.flight_reservation_system.FlightReservationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return mark_replica.flight_reservation_system.FlightReservationHelper.type ();
  }

}

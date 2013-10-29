
public class Seat {
	
	int seatNumber;
	boolean isReserved;
	
	public Seat(boolean isReserved, int seatNumber)
	{
		this.isReserved = isReserved;
		this.seatNumber = seatNumber;
	}
	
	
	public void setSeatNumber(int seatNumber)
	{
		this.seatNumber = seatNumber;
	}
	
	public int getSeatNumber()
	{
		return this.seatNumber;
	}
	
	public boolean getReservationStatus()
	{
		return isReserved;
	}
	
	public void reserve()
	{
		isReserved = true;
	}
	
	public void unreserve()
	{
		isReserved = false;
	}	

}

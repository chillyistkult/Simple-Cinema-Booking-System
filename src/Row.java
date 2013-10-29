import java.util.*;

public class Row {
	
	private ArrayList<Seat> seats;
	private int rowNumber; 
	private int rowClass;
	private int seatCount;

	public Row (int rowClass, int seatCount, int rowNumber)
	{
		this.rowNumber = rowNumber;
		this.rowClass = rowClass;
		this.seatCount = seatCount;
		seats = new ArrayList<Seat>();
		createSeats(this.seatCount);
	}
	
	public void setRowClass(int rowClass)
	{
		this.rowClass = rowClass;
	}
	
	public int getRowClass()
	{
		return this.rowClass;
	}
	
	public int getRowNumber()
	{
		return rowNumber;
	}
	
	public void createSeats(int seatCount)
	{
		for (int i = 1; i <= seatCount; i++)
		{
			seats.add(new Seat(false, i));
		}
	}
	
	public ArrayList<Seat> getSeats()
	{
		return seats;
	}
}

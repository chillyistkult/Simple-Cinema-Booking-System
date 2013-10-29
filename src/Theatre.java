import java.util.*;

public class Theatre {

	private int theatreNumber;
	private String description;
	private int rowCount;
	private ArrayList<Row> rows;
	
	public Theatre (int theatreNumber, String description)
	{
		this.description = description;
		this.theatreNumber = theatreNumber;
		rows = new ArrayList<Row>();
	}
	
	public void createRows(int rowClass, int seatCount, int rowCount)
	{
		for (int i = 1; i <= rowCount; i++)
		{
			rows.add(new Row(rowClass, seatCount, i));
		}
		this.rowCount += rowCount;
	}
	
	public ArrayList<Row> getRows()
	{
		return rows;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void printSeatPlan()
	{
		System.out.println();
        int maxSeatsInRow = 0;
        for (Row row : getRows())
        {
        	if (row.getSeats().size() > maxSeatsInRow)
        	{
        		maxSeatsInRow = row.getSeats().size();
        	}	     
        }
        System.out.print("   |");
        for (int i=1; i <= maxSeatsInRow; i++)
        {
        	System.out.print(" " + i);
        }
        System.out.print("\n");
        System.out.print("----");
        for (int i=1; i <= maxSeatsInRow; i++)
        {
        	if (i>9) {
        		System.out.print("---");
        	}
        	else {
        		System.out.print("--");
        	}
        }
        System.out.print("\n");
        for (Row row : getRows())
        {
        	if (row.getRowNumber()>9) {
        		System.out.print(row.getRowNumber() + " | ");
        	}
        	else {
        		System.out.print(row.getRowNumber() + "  | ");
        	}
        	for (Seat seat : row.getSeats())
        	{
        		
        		if (seat.getReservationStatus()) {
        			System.out.print("X ");
        		}
        		else {
        			System.out.print(seat.getSeatNumber() + " ");
        		}
        	}
            System.out.print("\n");
        }
        System.out.print("\n");
	}
}

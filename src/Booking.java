
public class Booking {

	int cost;
	Customer costumer;
	Show show;
	int rowNumber;
	int seatNumber;
	
	
	public Booking(Customer costumer, Show show)
	{
		this.costumer = costumer;
		this.show = show;
	}
	
	public int getCost()
	{
		if(show.getTheatre().getRows().get(rowNumber).getRowClass() == 1) {
			return cost += 8;
		}
		else {
			return cost += 5;
		}
	}
	
	public void setRowNumber(int rowNumber)
	{
		this.rowNumber = rowNumber;
	}
	
	public void setSeatNumber(int seatNumber)
	{
		this.seatNumber = seatNumber;
	}
	
	public boolean reserveSeat(int selectedRow, int selectedSeat)
	{
		if (show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).getReservationStatus())
    	{  		
    		return false;
    	}
    	else {
    		show.getTheatre().getRows().get(selectedRow).getSeats().get(selectedSeat).reserve();
    		setRowNumber(selectedRow);
    		setSeatNumber(selectedSeat);
    		return true;
    	}
	}
	
	public boolean unreserveSeat()
	{
    		show.getTheatre().getRows().get(rowNumber).getSeats().get(seatNumber).unreserve();
    		return true;
	}
	
	public Customer getCostumer()
	{
		return costumer;
	}
}

import java.util.*;
	 
public class Cinema
{	
	        public static void main (String[] args)
	        {
	                int option = 0;
	                ArrayList<Show >shows = new ArrayList<Show>();
	                ArrayList<Theatre> theatres = new ArrayList<Theatre>();
	                ArrayList<Booking> bookings = new ArrayList<Booking>();
	                ArrayList<Customer> customers = new ArrayList<Customer>();
	                Scanner select = new Scanner(System.in);
	                Scanner choice = new Scanner(System.in);
	                
		        	//Test Objects
	        	    Theatre testTheatre = new Theatre(1, "Main Theatre");
	        	    testTheatre.createRows(1, 10, 7);
                	theatres.add(testTheatre);
                	shows.add(new Show("Der SpongeBob Schwammkopf - Film", "21.10.2011", theatres.get(0)));
	            do
	            {  
	                System.out.println("------------------------------------");
	                System.out.println(":Cinema Booking System by BS and KU:");
	                System.out.println("------------------------------------\n");
	                System.out.println("Please Enter 1 to Add Theatre");
	                System.out.println("Please Enter 2 to Add Show");
	                System.out.println("Please Enter 3 to Display Shows");
	                System.out.println("Please Enter 4 to Make Booking");
	                System.out.println("Please Enter 5 to Cancel Booking");
	                System.out.println("Please Enter 6 to Exit\n");
	         
	                System.out.print("Enter Option: ");
	                    option = select.nextInt();
	                    
	                    if(option==1)
	                    {
	                    	System.out.println("ADD THEATRE Selected");
	                        System.out.println("-------------------------\n");
	                    	System.out.print("Enter a name for the theatre: \n");
	                    	String theatreName = choice.nextLine();
	                    	System.out.print("Enter a number for the theatre: \n");
	                    	int theatreNumber = choice.nextInt();
	                    	System.out.println("Enter the number of rows:");
	                    	int rowCount = choice.nextInt();
	                    	Theatre theatre = new Theatre(theatreNumber, theatreName);
	                    	theatre.createRows(1, 10, rowCount);
	                    	theatre.createRows(1, 5, 5);
	                    	theatres.add(theatre);
	                    }
	                     
	                    if(option==2)
	                    {	                        
	                    	System.out.println("ADD SHOW Selected");
	                        System.out.println("-------------------------\n");
	                    	System.out.println("Enter the date of the Show [DD/MM/YYYY]:");
	                        String showDate = choice.nextLine();
	                        System.out.print("Enter name of Show: \n");
	                        String showName = choice.nextLine();	
	                        System.out.println("Select a theatre by typing the number:");
	                        for (int i=0; i < theatres.size(); i++) 
	                        {	                        		                        
	                        	System.out.println(i+1 + " " + theatres.get(i).getDescription());
	                        }
	                        int theatreNumber = choice.nextInt();
	                        shows.add(new Show(showName, showDate, theatres.get(theatreNumber-1)));
	                    }
	                    
	                    
	                    if(option==3)
	                    {
	                        System.out.println("DISPLAY SHOWS Selected");
	                        System.out.println("-------------------------\n");
	                        for (int i = 0; i < shows.size(); i++)
	                        {
	                        	int showNumber = i+1;
	                        	System.out.println("Show Number: " + showNumber);;
	                            System.out.println("Show Name: " + shows.get(i).getShowName());
	                            System.out.println("Show Date: " + shows.get(i).getShowDate());
	                            //System.out.println("Seat Status:" + shows.get(i).getFreeSeatsCount());
	                            System.out.println("\n");
	                        }
	                        System.out.println("End of Show List.\n");
	                    }
	                    
	                    
	                    if(option==4)
	                    {
	                        System.out.println("MAKE BOOKING Selected");
	                        System.out.println("-------------------------\n");
	                        Random rnd = new Random();
	                        int costumerId = rnd.nextInt(999);
	                        Customer customer = new Customer(costumerId);
	                        customers.add(customer);
	                        for (int i = 0; i< shows.size(); i++)
	                        {	                    
	                        	int showNumber = i+1;
	                        	System.out.println("Show Number: " + showNumber);;
	                            System.out.println("Show Name:   " + shows.get(i).getShowName());
	                            System.out.println("Show Date:   " + shows.get(i).getShowDate());
	                            System.out.print("\n");
	                        }
	                        System.out.println("-------------------------");
	                        System.out.print("Enter the show number: ");
	                        int showNumber = choice.nextInt();
	                        int repeat = 0;
	                        System.out.println();
	                        do {
	                        	shows.get(showNumber-1).getTheatre().printSeatPlan();
	                        	System.out.print("Enter the row: ");
	                        	int selectedRow = choice.nextInt();
	                        	System.out.print("Enter the seat: ");
	                        	int selectedSeat = choice.nextInt();
	                        	System.out.println();
	                        	Booking booking = new Booking(customer, shows.get(showNumber-1));
	                        	if (booking.reserveSeat(selectedRow-1, selectedSeat-1)) {
	                        		bookings.add(booking);
	                        		System.out.println("The seat is now reserved for you.");
	                        	}
	                        	else {
	                        		System.out.println("Sorry the seat is already reserved.");
	                        	}
	                        	System.out.println();
	                        	System.out.print("Enter 1 to reserve another seat or 2 to check out: ");
	                        	repeat = choice.nextInt();
	                        } while (repeat == 1);
	                        System.out.println();
	                        System.out.println("Your Bill");
	                        System.out.println("-------------------------");
                        	int totalCost = 0;
	                        for (Booking booking : bookings)
	                        {
	                        	if (booking.getCostumer().getId() == customer.getId())
	                        	{
	                        		totalCost += booking.getCost();
	                        	}
	                        }
	                        System.out.println("Costumer ID: " + customer.getId());
	                        System.out.println("Total costs: " + totalCost + " Euro");
	                        System.out.println();
	                    }
	                    
	                    if(option==5)
	                    {
	                        System.out.println("CANCEL BOOKING Selected");
	                        System.out.println("-------------------------\n");
	                        System.out.print("Enter the costumer id: ");
	                        int customerId = choice.nextInt();
	                        for (Customer customer : customers) {
	                        	if (customer.getId() == customerId)
	                        	{
	                        		for(Booking booking : bookings)
	                        		{
	                        			if (booking.getCostumer().getId() == customer.getId())
	                        			{
	                        				if (booking.unreserveSeat())
	                        				{
	                        					
	                        				}
	                        			}
	                        		}
	                        		System.out.println("Your reservation has been canceled!");
	                        	}
	                        }
	                        System.out.println();
	                    }
	                    
	                    if(option==6)
	                    {
	                    	System.exit(0);
	                    }
	                                                                	                                	                                	                               
	              }while(true);	       
	        }	        
}

public class Customer {

	int id;
	String name;
	String surname;
	String street;
	int streetNumber;
	int plz;
	String city;
	
	public Customer(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public void setStreetNumber(int streetNumber)
	{
		this.streetNumber = streetNumber;
	}
	
	public void setPLZ(int plz)
	{
		this.plz = plz;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void printCostumer()
	{
		System.out.print(surname + " " + name);
		System.out.println(street + " " + streetNumber);
		System.out.println(plz + " " + city);
	}
}

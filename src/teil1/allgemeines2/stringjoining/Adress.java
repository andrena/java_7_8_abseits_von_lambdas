package teil1.allgemeines2.stringjoining;

public class Adress {

	private String city;
	private String street;

	public Adress(String street, String city) {
		this.setStreet(street);
		this.setCity(city);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}

public class Bike extends Vehicle{
	public Bike(String brand, int tankCapacity, int consumption){
		super("A", brand, tankCapacity, consumption);
	}

	public String sound(){
		return "Aaar Aaar";
	}
}

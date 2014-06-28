public class Car extends Vehicle{
	public Car(String brand, int tankCapacity, int consumption){
		super("B", brand, tankCapacity, consumption);
	}

	public String sound(){
		return "Wrrr Wrrr";
	}
}

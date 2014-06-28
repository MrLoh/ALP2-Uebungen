abstract class Vehicle{
	// ATTRIBUTES
	String vehicleClass; // as specified in driver license
	String brand = "no name";
	int tankCapacity; // in l
	int tankFilling; // in l
	int consumption; // in km/l

	// CONSTRUCTOR
	public Vehicle(String vehicleClass, String brand, int tankCapacity, int consumption) {
		this.vehicleClass = vehicleClass;
		this.brand = brand;
		this.tankCapacity = tankCapacity;
		this.tankFilling = 0;
		this.consumption = consumption;
	}

	// METHODS
	public String toString(){
		String type = "";
		if( vehicleClass.equals("A") ){
			type = "Bike";
		} else if( vehicleClass.equals("B") ) {
			type = "Car";
		}
		return String.format("%s from %s\n  Tank: %s/%s\n", type, brand, tankFilling, tankCapacity);
	}
	abstract String sound();

}

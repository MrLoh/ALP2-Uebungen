public class TestVehicle{
	public static void drive(Driver driver, int km, int speed){
		try {
			System.out.println("Drove " + km + "km in: " + driver.drive(km, speed));
		}
		catch( NotEnoughFuelException e ) {
			if( e.maximalDistance > 0 ){
				System.out.println("Tried to drive " + (km-e.maximalDistance) + "km further than possible with current tank filling. Drove as far as possible instead.");
				drive(driver, e.maximalDistance, speed);
			} else {
				System.out.println("Could not drive any further with current tank filling.");
			}
		}
	}
	public static void tank(Driver driver, int liter){
		try
		{
			driver.tank(liter);
		}
		catch( NotEnoughCapacityException e )
		{
			System.out.println("Tried to tank " + e.capacityOverflow + "l more than the tank could hold. Tanked full instead");
			driver.tankUp();
		}
	}

	public static void main(String[] args) {
		// CREATE SOME OBJECTS
		Car audi = new Car("Audi", 70, 17);
		Car fiat = new Car("Fiat", 45, 35);
		Bike bike = new Bike("Yamaha", 30, 30);
		Driver audiDriver = new Driver<Car>(audi);
		Driver fiatDriver = new Driver<Car>(fiat);
		Driver biker = new Driver<Bike>(bike);
		System.out.println(audiDriver);
		System.out.println(fiatDriver);
		System.out.println(biker);

		// DRIVE AROUND
		audiDriver.tankUp();
		fiatDriver.tankUp();
		biker.tankUp();
		drive(audiDriver, 2000, 150);
		drive(fiatDriver, 2000, 100);
		drive(biker, 2000, 200);
		System.out.println();
		System.out.println(audiDriver);
		System.out.println(fiatDriver);
		System.out.println(biker);

		// System.out.println();
		drive(audiDriver, 10, 50);
		System.out.println("Empty tank? " + audiDriver.isEmpty());
		System.out.println(audiDriver);
		tank(audiDriver,100);
		System.out.println("Full tank? " + audiDriver.isFull());
		System.out.println(audiDriver);

		// MAKE SOUNDS
		System.out.println();
		System.out.println(biker.vehicle.sound());
		System.out.println(audiDriver.vehicle.sound());
		System.out.println(fiatDriver.vehicle.sound());
	}

}

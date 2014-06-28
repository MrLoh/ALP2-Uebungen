import java.sql.Time;

public class Driver<V extends Vehicle>{
	// ATTRIBUTES
	V vehicle;
	int position = 0; // in km

	// CONSTRUCTOR
	public Driver(V vehicle){
		this.vehicle = vehicle;
	}

	// METHODS
	public Time drive(int km, int speed) throws NotEnoughFuelException {
		if( this.vehicle.consumption*this.vehicle.tankFilling >= km ){
			this.position += km;
			this.vehicle.tankFilling -= (int)((double)km/(double)this.vehicle.consumption);
			Time time = new Time( (long)((double)km/(double)speed*3600-3600)*1000 );
			return time;
		} else {
			int maximalDistance = this.vehicle.consumption*this.vehicle.tankFilling;
			throw new NotEnoughFuelException("Tried to drive further than possible.", maximalDistance);
		}
	}

	public void tank(int liter) throws NotEnoughCapacityException {
		if( this.vehicle.tankFilling + liter <= this.vehicle.tankCapacity ){
			this.vehicle.tankFilling += liter;
		} else {
			int capacityOverflow = this.vehicle.tankFilling + liter - this.vehicle.tankCapacity;
			throw new NotEnoughCapacityException("Tried to tank more than possible.", capacityOverflow);
		}
	}
	public int tankUp(){
		int tanking = this.vehicle.tankCapacity - this.vehicle.tankFilling;
		this.vehicle.tankFilling += tanking;
		return tanking;
	}

	public boolean isEmpty(){
		return this.vehicle.tankFilling == 0;
	}
	public boolean isFull(){
		return this.vehicle.tankFilling == this.vehicle.tankCapacity;
	}

	public String toString(){
		return String.format("| Driver at %s km on:\n  %s", position, vehicle);
	}

}

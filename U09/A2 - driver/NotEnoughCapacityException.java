public class NotEnoughCapacityException extends Exception {
	// ATTRIBUTES
	int capacityOverflow;

	// CONSTRUCTORS
	public NotEnoughCapacityException(){
		super();
	}
	public NotEnoughCapacityException(String reason){
		super(reason);
	}
	public NotEnoughCapacityException(String reason, int capacityOverflow){
		super(reason);
		this.capacityOverflow = capacityOverflow;
	}
}

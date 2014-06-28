public class NotEnoughFuelException extends Exception {
	// ATTRIBUTES
	public int maximalDistance;

	// CONSTRUCTORS
	public NotEnoughFuelException(){
		super();
	}
	public NotEnoughFuelException(String reason){
		super(reason);
	}
	public NotEnoughFuelException(String reason, int maximalDistance){
		super(reason);
		this.maximalDistance = maximalDistance;
	}
}

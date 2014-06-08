import java.util.Random;

public class Position {

	// attributes
	int holeNeighbours = 0;
	boolean hole = false;
	boolean open = false;

	// constructor
	private static final Random RAND = new Random();
	public Position(double p) {
		if( RAND.nextDouble() <= p ) {
			this.hole = true;
		}
	}

}

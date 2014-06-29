import java.awt.Color;
import java.awt.Font;

public class Position {
	// ATTRIBUTES
	Color color;
	int walkerSteps;
	final int posSize;

	public final static Color bgColor = Color.WHITE; // background color
	public final static Color deadColor = Color.BLACK; // when a walker can't move
	public static Font font = new Font("Verdana", Font.PLAIN, 10);

	// CONSTRUCTORS
	public Position(Color color, int wSteps, int posSize) {
		this.color = color;
		this.walkerSteps = wSteps;
		this.posSize = posSize;
	}
	public Position(int pSize){
		this(Color.WHITE, 0, pSize);
	}
	public Position(){
		this(Color.WHITE, 0, 20);
	}

	// METHODS
	public void reset(){
		this.color = bgColor;
		this.walkerSteps = 0;
	}
	public void markWith(Walker walker){
		this.color = walker.color;
		this.walkerSteps = walker.steps;
	}

}

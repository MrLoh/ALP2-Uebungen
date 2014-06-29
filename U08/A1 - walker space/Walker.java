import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Walker {
	// ATTRIBUTES
	public int x, y; // position in the walk space matrix
	public Color color; // color of the walker
	public boolean alive = true; // the walker still can move
	public int steps = 0; // number of steps walked
	Color deadColor = Color.BLACK;
	Random rand = new Random();
	// list of the current free directions a walker can visit
	ArrayList<Integer> currentFreeDirs = new ArrayList<Integer>();

	// CONSTRUCTOR
	public Walker(int x, int y){
	// produce a new crazy walker with (x,y) position and a random color
		this.x = x;
		this.y = y;
		int max = 240, offset = 255;
		int r = offset-rand.nextInt(max);
		int g = offset-rand.nextInt(max);
		int b = offset-rand.nextInt(max);
		this.color = new Color(r,g,b);
	}

	// METHODS
	public void setDead(){
		this.color = deadColor;
		this.alive = false;
	}
}

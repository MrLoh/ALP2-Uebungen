import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Wrapper extends AbstractShape {
	// ATTRIBUTES
	double velocity = 4;
	boolean catched = false;
	Shape slave;
	int dir = rand.nextInt(8);
	final int RADIUS = 35;

	// dir: 0: right, 1: left, 2: up, 3: down, 4: upright, 5:upleft, 6: downright, 7:downleft

	// CONSTRUCTOR
	public Wrapper() {
		int x = rand.nextInt(15)*20-150;
		int y = rand.nextInt(15)*20-150;
		this.center = new Point(x,y);
		this.radius = 35;
		this.color = Color.RED;
	}
	public Wrapper(double x, double y) {
		this.center = new Point(x, y);
		this.color = Color.RED;
		this.radius = 35;
	}

	// DRAW METHODS
	public void draw(Graphics g){
		outlineCircle(g, center.x, center.y, radius);
	}

	// PLAY METHOD
	public void play(){
		steps++;
		if( catched ){
			moveTo(this.slave.getCenter().x, this.slave.getCenter().y);
			if( this.world.getClosestShape(this) != slave ){
				catched = false;
			}
		} else {
			if( steps > 30 && directionOccupied(dir) && !(this.world.getClosestShape(this) instanceof Wrapper) ){
				catched = true;
				slave = this.world.getClosestShape(this);
			} else {
				while( !directionInFrame(dir, 1.2) ){
					dir = rand.nextInt(8);
				}
				move(dir, velocity);
			}
		}
	}

}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Wrapper extends AbstractShape implements Shape, Animation {
	// ATTRIBUTES
	double velocity = 4;
	boolean catched = false;
	Shape slave;
	int dir = rand.nextInt(8);
	// dir: 0: right, 1: left, 2: up, 3: down, 4: upright, 5:upleft, 6: downright, 7:downleft

	// CONSTRUCTOR
	public Wrapper() {
		int x = rand.nextInt(15)*20-150;
		int y = rand.nextInt(15)*20-150;
		this.center = new Point(x,y);
		this.radius = 35;
		this.color = Color.RED;
	}

	// DRAW METHODS
	public void setShapesWorld(ShapesWorld theWorld){ this.world = theWorld; }
	public void draw(Graphics g){
		outlineCircle(g, center.x, center.y, radius);
	}

	// PLAY METHOD
	public void play(){
		if( catched ){
			moveTo(this.slave.getCenter().x, this.slave.getCenter().y);
			if( this.world.getClosestShape(this) != slave ){
				catched = false;
			}
		} else {
			if( directionOccupied(dir) && !(this.world.getClosestShape(this) instanceof Wrapper) ){
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

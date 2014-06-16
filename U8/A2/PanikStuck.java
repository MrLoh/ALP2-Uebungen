import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class PanikStuck extends AbstractShape implements Shape, Animation {
	// ATTRIBUTES
	double velocity = 6;
	int steps = 0;
	int shape = rand.nextInt(4)+6;
	int dir = rand.nextInt(8);
	// dir: 0: right, 1: left, 2: up, 3: down, 4: upright, 5:upleft, 6: downright, 7:downleft

	// CONSTRUCTOR
	public PanikStuck(int x, int y, Color color, int shape, double radius){
		this.radius = radius;
		this.velocity = radius;
		this.center = new Point(x,y);
		this.color = color;
		this.shape = shape;
	}
	public PanikStuck() {
		this.radius = rand.nextInt(4)+4;
		this.velocity = radius;
		this.center = new Point();
	}

	// DRAW METHODS
	public void setShapesWorld(ShapesWorld theWorld){ this.world = theWorld; }
	public void draw(Graphics g){
		g.setColor(color);
		fillNtagon(g, center.x, center.y, radius, shape);
	}

	// PLAY METHOD
	public void play(){
		steps++;
		if( steps <= 10 ){
			this.move(dir, 10/velocity);
			velocity *= 0.9;
		} else if( center.y >= world.getMin_Y() ){
			move(3, velocity);
			velocity *= 1.1;
		}
	}

}

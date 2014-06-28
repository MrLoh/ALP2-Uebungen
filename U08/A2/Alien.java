import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Alien extends AbstractShape {
	// ATTRIBUTES
	double velocity = 2;
	boolean clicked = false;
	int dir = rand.nextInt(8);
	int gender = rand.nextInt(2);
	int steps = 400;
	final int RADIUS = 20;
	// gener 0: female, 1: male

	// CONSTRUCTOR
	public Alien(double x, double y) {
		this.radius = RADIUS;
		this.color = Color.GREEN;
		this.center = new Point(x,y);
	}
	public Alien() {
		this.radius = RADIUS;
		this.color = Color.GREEN;
		int x = rand.nextInt(15)*20-150;
		int y = rand.nextInt(15)*20-150;
		this.center = new Point(x,y);
	}

	// DRAW METHODS
	public void draw(Graphics g){
		g.setColor(color);
		if( gender == 1 ){
			fillNtagon(g, center.x, center.y-1.1*radius, radius/3, 3);    //antenna
		} else {
			fillNtagon(g, center.x, center.y-1.1*radius, radius/2.5, 0);  //antenna
		}
		outlineCircle(g, center.x, center.y-radius/2, radius);            //helmet
		fillCircle(g, center.x, center.y-radius/4, radius);               //head
		fillAlienBody(g, center.x, center.y, radius);                     //body
		outlineNtagon(g, center.x, center.y+radius, radius/3, 5);         //hooverpad
	}
	public static void fillAlienBody(Graphics g, double x, double y, double r){
		int[] x_coords = { (int) (x-r*0.7), (int) (x+r*0.7), (int) (x+r*0.2), (int) (x+r*0.4), (int) (x-r*0.4), (int) (x-r*0.2) };
		int[] y_coords = { (int) (y),       (int) (y),       (int) (y+r/2),   (int) (y+r),     (int) (y+r),     (int) (y+r/2)   };
		Polygon p = new Polygon(x_coords, y_coords, 6);
		g.fillPolygon(p);
	}
	public void destroy(){
		this.world.removeShape(this);
		for( int i=0; i<radius; i++ ){
			this.world.addShape(new PanikStuck(center.x, center.y, getColor(), 0, rand.nextInt(8)+radius/4 ));
		}
	}

	// PLAY METHOD
	public void play(){
		steps++;
		if( this.enslaved() ){
			Shape master = this.world.getClosestShape(this);
			if( !(master instanceof TimeWrapper) ){
				move(dir, velocity);
			}
		} else {
			if ( steps%(2*RADIUS) == 0 ){ //make him move smoother
				dir = rand.nextInt(8);
				while( !directionInFrame(dir, 6.0) ){
					dir = rand.nextInt(8);
				}
			}
			move(dir, velocity);
			if( this.gender == 0 && steps > 500 && directionOccupied(dir) ){
				Shape neighbour = this.world.getClosestShape(this);
				if( neighbour instanceof Alien ){
					Alien mate = (Alien) neighbour;
					if( mate.gender == 1){
						steps = 0;
						this.world.addShape(new BabyAlien(center.x, center.y));
					}
				}
			}
		}
	}

	// INTERACTIONS
	public void userClicked(double atX, double atY){
		if( this.contains(atX, atY) ){
			this.destroy();
		}
	}
	public boolean contains(double x, double y) {
		if( x<(center.x-radius) || x>center.x+radius || y<(center.y-radius) || y>(center.y+radius) ){
			return false;
		} else {
			return true;
		}
	}

}

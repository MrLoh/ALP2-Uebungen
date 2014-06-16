import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Alien extends AbstractShape implements Shape, Animation {
	// ATTRIBUTES
	double velocity = 2;
	boolean clicked = false;
	int steps = 0;
	int dir = rand.nextInt(8);

	// CONSTRUCTOR
	public Alien() {
		this.radius = 20;
		this.color = Color.GREEN;
		int x = rand.nextInt(300)-150;
		int y = rand.nextInt(300)-150;
		this.center = new Point(x,y);
	}

	// DRAW METHODS
	public void draw(Graphics g){
		g.setColor(color);
		fillNtagon(g, center.x, center.y-1.1*radius, radius/3, 3);  //antenna
		outlineCircle(g, center.x, center.y-radius/2, radius);      //helmet
		fillCircle(g, center.x, center.y-radius/4, radius);         //head
		fillAlienBody(g, center.x, center.y, radius);               //body
		outlineNtagon(g, center.x, center.y+radius, radius/3, 5);   //hooverpad
	}
	public static void fillAlienBody(Graphics g, double x, double y, double r){
		int[] x_coords = { (int) (x-r*0.7), (int) (x+r*0.7), (int) (x+r*0.2), (int) (x+r*0.4), (int) (x-r*0.4), (int) (x-r*0.2) };
		int[] y_coords = { (int) (y),       (int) (y),       (int) (y+r/2),   (int) (y+r),     (int) (y+r),     (int) (y+r/2)   };
		Polygon p = new Polygon(x_coords, y_coords, 6);
		g.fillPolygon(p);
	}

	// PLAY METHOD
	public void play(){
		steps++;
		System.out.println(directionAvailable(dir));
		if( velocity*steps%radius == 0 ){ //make him move a little smoother
			dir = rand.nextInt(8);
			while( !directionAvailable(dir) ){
				dir = rand.nextInt(8);
			}
		}
		move(dir, velocity);
	}

	// INTERACTIONS
	public void userClicked(double atX, double atY){
		if( radius <= 40 ){
			this.radius += radius/2;
		} else {
			this.radius = 0;
			for( int i=0; i<20; i++ ){
				this.world.addShape(new PanikStuck((int)center.x, (int)center.y, getColor(), 0, rand.nextInt(10)+5 ));
			}
		}
	}

}

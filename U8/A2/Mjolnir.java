import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Mjolnir extends AbstractShape implements Shape, Animation {
	// ATTRIBUTES
	double radius = 20;
	final double VELOCITY = 20;
	Color color = Color.WHITE;

	// CONSTRUCTOR
	public Mjolnir() {
		int x = 200;
		int y = rand.nextInt(15)*20-150;
		this.center = new Point(x,y);
	}

	// DRAW METHODS
	public void draw(Graphics g){
		g.setColor(color);
		fillMjolnirHead(g, center.x, center.y, radius);
		fillMjolnirGrip(g, center.x, center.y, radius);
	}
	public static void fillMjolnirHead(Graphics g, double x, double y, double r){
		int[] x_coords = { (int) (x),   (int) (x),   (int) (x+0.3*r), (int) (x+1.2*r), (int) (x+1.5*r), (int) (x+1.5*r), (int) (x+1.2*r), (int) (x+0.3*r)  };
		int[] y_coords = { (int) (y-r), (int) (y+r), (int) (y+1.3*r), (int) (y+1.3*r), (int) (y+r),     (int) (y-r),     (int) (y-1.3*r), (int) (y-1.3*r)  };
		Polygon p = new Polygon(x_coords, y_coords, 8);
		g.fillPolygon(p);
	}
	public static void fillMjolnirGrip(Graphics g, double x, double y, double r){
		int[] x_coords = { (int) (x+1.5*r), (int) (x+1.5*r), (int) (x+4.5*r), (int) (x+4.5*r) };
		int[] y_coords = { (int) (y-0.2*r), (int) (y+0.2*r), (int) (y+0.2*r), (int) (y-0.2*r) };
		Polygon p = new Polygon(x_coords, y_coords, 4);
		g.fillPolygon(p);
	}
	public void destroy(){
		this.world.removeShape(this);
		for( int i=0; i<100; i++ ){
			this.world.addShape(new PanikStuck(center.x, center.y, Color.WHITE, 4, rand.nextInt(10)+3 ));
		}
	}

	// PLAY METHOD
	public void play(){
		if( velocity > VELOCITY/2 ){
			move(1, velocity);
			if( steps < 15 ){
				Shape neighbour = this.world.getClosestShape(this);
				if( neighbour != null && (neighbour.contains(center.x, center.y) || neighbour.contains(center.x, center.y-radius) || neighbour.contains(center.x, center.y+radius)) ){
					neighbour.destroy();
					velocity -= VELOCITY/8;
					steps++;
				}
			}
		} else {
			move(7, velocity*4);
			velocity += 3;
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Alien implements Shape, Animation {
	// ATTRIBUTES
	double radius;
	Point center;
	Color color = Color.lightGray;
	ShapesWorld world;
	double velocity = 1;
	boolean clicked = false;

	// CONSTRUCTOR
	public Alien() {
		this.radius = 20;
		this.color = Color.GREEN;
		this.center = new Point();
	}

	// GET METHODS
	public Point getCenter() { return center; }
	public double getRadius() { return radius; }
	public Color getColor(){ return color; }

	// METHODS
	public void setShapesWorld(ShapesWorld theWorld){ this.world = theWorld; }
	public void draw(Graphics g){
		g.setColor(color);
		// fillAlien(g, center.x, center.y, radius);
		fillNtagon(g, center.x, center.y, radius, 40);
	}
	public static void fillAlien(Graphics g, double x, double y, double r){
		int[] x_coords = { (int) (x), (int) (x+r), (int) (x+r*3/4), (int) (x+r), (int) (x),   (int) (x+r/4) };
		int[] y_coords = { (int) (y), (int) (y),   (int) (y+r/2),   (int) (y+r), (int) (y+r), (int) (y+r/2) };
		Polygon p = new Polygon(x_coords, y_coords, 6);
		g.fillPolygon(p);
	}
	public static void fillNtagon(Graphics g, double x, double y, double r, int n){
		int[] x_coords = new int[n];
		int[] y_coords = new int[n];
		double deg = 360/n;
		for( int i=0; i<n; i++ ) {
			y_coords[i] = (int) (y+r*Math.sin(Math.toRadians(i*deg)));
			x_coords[i] = (int) (x+r*Math.cos(Math.toRadians(i*deg)));
			System.out.println(String.format("(%s,%s)",x_coords[i],y_coords[i]));
		}
		Polygon p = new Polygon(x_coords, y_coords, n);
		g.fillPolygon(p);
	}
	public boolean contains(double x, double y) {
		if( x<(center.x-radius) || x>center.x+radius || y<(center.y-radius) || y>(center.y+radius) ){
			return false;
		} else {
			return true;
		}
	}
	public void moveTo(double x, double y){
		center.x = (int) x;
		center.y = (int) y;
	}

	// PLAY METHOD
	public void play(){
		// if( (center.x-radius) <= world.getMax_X() ){
		// 	center.x += velocity;
		// } else {
		// 	center.x = world.getMin_X()+radius;
		// }
	}

	// INTERACTIONS
	public void userClicked(double atX, double atY){
		this.radius += 2;
		this.world.addShape(new Around());
	}
	public void userTyped(char key){
		System.out.println("key");
	}

}

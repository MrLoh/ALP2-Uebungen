import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Around implements Shape, Animation {
	// ATTRIBUTES
	double radius;
	Point center;
	Color color = Color.lightGray;
	ShapesWorld world;
	double velocity = 1;

	// CONSTRUCTOR
	public Around() {
		this.radius = 15;
		this.color = Color.CYAN;
		this.center = new Point();
	}

	// METHODS
	public Color getColor(){
		return color;
	}
	public void moveTo(double x, double y){
		center.x = (int) x;
		center.y = (int) y;
	}
	public void setShapesWorld(ShapesWorld theWorld){
		this.world = theWorld;
	}
	public void draw(Graphics g){
		g.setColor(color);
		fillTriangle(g, center.x-radius, center.y-radius, radius*2, radius*2);
	}
	public void fillTriangle(Graphics g, double x, double y, double w, double h){
		int[] x_coords = { (int) (x+w/2), (int) (x), (int) (x+w) };
		int[] y_coords = { (int) (y), (int) (y+h), (int) (y+h) };
		Polygon p = new Polygon(x_coords, y_coords, 3);
		g.fillPolygon(p);
	}
	public Point getCenter() {
		return center;
	}
	public void userClicked(double atX, double atY){
		this.radius += 2;
		this.world.addShape(new Around());
	}
	public void userTyped(char key){
		System.out.println("key");
	}

	public boolean contains(double x, double y) {
		if( x<(center.x-radius) || x>center.x+radius || y<(center.y-radius) || y>(center.y+radius) ){
			return false;
		} else {
			return true;
		}
	}
	public double getRadius() {
		return radius;
	}

	// PLAY METHOD
	public void play(){
		if( (center.x-radius) <= world.getMax_X() ){
			center.x = center.x + velocity;
		} else {
			center.x = world.getMin_X()+radius;
		}
	}

}

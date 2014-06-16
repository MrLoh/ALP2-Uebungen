import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Alien implements Shape, Animation {
	// ATTRIBUTES
	double radius;
	Point center;
	Color color = Color.lightGray;
	ShapesWorld world;
	double velocity = 10;
	boolean clicked = false;
	Random rand = new Random();

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
		fillAlien(g, center.x, center.y, radius);
		fillCircle(g, center.x, center.y-radius/2, radius);
	}
	public static void fillAlien(Graphics g, double x, double y, double r){
		int[] x_coords = { (int) (x-r/2), (int) (x+r/2), (int) (x+r/4), (int) (x+r/2), (int) (x-r/2),   (int) (x-r/4) };
		int[] y_coords = { (int) (y), (int) (y),   (int) (y+r/2),   (int) (y+r), (int) (y+r), (int) (y+r/2) };
		Polygon p = new Polygon(x_coords, y_coords, 6);
		g.fillPolygon(p);
	}
	public static void fillCircle(Graphics g, double x, double y, double r){
		g.fillOval((int) (x-r/2),(int) (y-r/2),(int) r,(int) r);
	}
	public static void fillNtagon(Graphics g, double x, double y, double r, int n){
		Polygon p = getNtagon(g, x, y, r, n);
		g.fillPolygon(p);
	}
	public static Polygon getNtagon(Graphics g, double x, double y, double r, int n){
		int[] x_coords = new int[n];
		int[] y_coords = new int[n];
		double deg = 360/n;
		for( int i=0; i<n; i++ ) {
			y_coords[i] = (int) (y+r*Math.sin(Math.toRadians(i*deg)));
			x_coords[i] = (int) (x+r*Math.cos(Math.toRadians(i*deg)));
			System.out.println(String.format("(%s,%s)",x_coords[i],y_coords[i]));
		}
		return new Polygon(x_coords, y_coords, n);
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
		String dir = randomDirection();
		String[] avDir = availableDirections();
		while( !inStringArray(avDir, dir) ){
			dir = randomDirection();
		}
		switch(dir) {
			case "U": center.y += velocity; break;
			case "D": center.y -= velocity; break;
			case "R": center.x += velocity; break;
			case "L": center.x -= velocity; break;
		}
	}
	public static boolean inStringArray(String[] stack, String key){
		boolean tester = false;
		for( int i=0; i<stack.length; i++){
			if( stack[i].equals(key) ){ tester = true; }
		}
		return tester;
	}
	public String randomDirection(){
		int i = rand.nextInt(4);
		String dir = "";
		switch(i) {
			case 0: dir = "R"; break;
			case 1: dir = "L"; break;
			case 2: dir = "U"; break;
			case 3: dir = "D"; break;
		}
		return dir;
	}
	public String[] availableDirections(){
		String[] directions = new String[4];
		if( (center.x+radius) <= world.getMax_X() ){
			directions[0] = "R";
		}
		if( (center.x-radius) >= world.getMin_X() ){
			directions[1] = "L";
		}
		if( (center.y+1.5*radius) <= world.getMax_Y() ){
			directions[2] = "U";
		}
		if( (center.y-1.5*radius) >= world.getMin_Y() ){
			directions[3] = "D";
		}
		return directions;
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

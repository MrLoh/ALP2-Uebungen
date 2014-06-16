import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

abstract class AbstractShape implements Shape, Animation {
	// ATTRIBUTES
	double radius;
	Point center = new Point();
	Color color = Color.lightGray;
	ShapesWorld world;
	double velocity;
	Random rand = new Random();

	public void setShapesWorld(ShapesWorld theWorld){
		this.world = theWorld;
	}

	// GET METHODS
	public Point getCenter() { return center; }
	public double getRadius() { return radius; }
	public Color getColor(){ return color; }

	// FILL METHODS
	public static void fillCircle(Graphics g, double x, double y, double r){
		g.fillOval((int) (x-r/2),(int) (y-r/2),(int) r,(int) r);
	}
	public static void outlineCircle(Graphics g, double x, double y, double r){
		g.drawOval((int) (x-r/2),(int) (y-r/2),(int) r,(int) r);
	}
	public static void fillNtagon(Graphics g, double x, double y, double r, int n){
		if( n == 0 ){
			fillCircle(g, x, y, r);
		} else {
			Polygon p = getNtagon(g, x, y, r, n);
			g.fillPolygon(p);
		}
	}
	public static void outlineNtagon(Graphics g, double x, double y, double r, int n){
		Polygon p = getNtagon(g, x, y, r, n);
		g.drawPolygon(p);
	}
	public static Polygon getNtagon(Graphics g, double x, double y, double r, int n){
		int[] x_coords = new int[n];
		int[] y_coords = new int[n];
		double deg = 360/n;
		for( int i=0; i<n; i++ ) {
			y_coords[i] = (int) (y+r*Math.sin(Math.toRadians(i*deg-90)));
			x_coords[i] = (int) (x+r*Math.cos(Math.toRadians(i*deg-90)));
		}
		return new Polygon(x_coords, y_coords, n);
	}

	// METHODS
	public boolean contains(double x, double y) {
		if( x<(center.x-radius) || x>center.x+radius || y<(center.y-radius) || y>(center.y+radius) ){
			return false;
		} else {
			return true;
		}
	}

	// MOVE METHODS
	public void moveTo(double x, double y){
		center.x = (int) x;
		center.y = (int) y;
	}
	public void move(int dir, double velocity){
		double velocityDiag = Math.sqrt(velocity/2);
		switch(dir) {
			// dir: 0: right, 1: left, 2: up, 3: down, 4: upright, 5:upleft, 6: downright, 7:downleft
			case 0: center.x += velocity; break;
			case 1: center.x -= velocity; break;
			case 2: center.y -= velocity; break;
			case 3: center.y += velocity; break;
			case 4: center.y -= velocityDiag;
                    center.x += velocityDiag; break;
			case 5: center.y += velocityDiag;
                    center.x += velocityDiag; break;
			case 6: center.y -= velocityDiag;
                    center.x -= velocityDiag; break;
			case 7: center.y += velocityDiag;
                    center.x -= velocityDiag; break;
		}
	}
	public boolean directionInFrame(int dir, double factor){
		int xMax = world.getMax_X();
		int xMin = world.getMin_X();
		int yMax = world.getMax_Y();
		int yMin = world.getMin_Y();
		boolean available = false;
		switch(dir){
			case 0: available = (center.x+factor*radius <= xMax); break;
			case 1: available = (center.x-factor*radius >= xMin); break;
			case 2: available = (center.y-factor*radius >= yMin); break;
			case 3: available = (center.y+factor*radius <= yMax); break;
			case 4: available = (center.x+factor*radius <= xMax) &&
                                (center.y-factor*radius >= yMin); break;
			case 5: available = (center.x+factor*radius <= xMax) &&
                                (center.y+factor*radius <= yMax); break;
			case 6: available = (center.x-factor*radius >= xMin) &&
                                (center.y-factor*radius >= yMin); break;
			case 7: available = (center.x-factor*radius >= xMin) &&
                                (center.y+factor*radius <= yMax); break;
		}
		return available;
	}
	public boolean directionOccupied(int dir){
		Shape neighbour = this.world.getClosestShape(this);
		boolean occupied = false;
		if( neighbour != null ){
			switch(dir){
				case 0: occupied = neighbour.contains(center.x+radius, center.y); break;
				case 1: occupied = neighbour.contains(center.x-radius, center.y); break;
				case 2: occupied = neighbour.contains(center.x, center.y-radius); break;
				case 3: occupied = neighbour.contains(center.x, center.y+radius); break;
				case 4: occupied = neighbour.contains(center.x+radius, center.y) ||
	                               neighbour.contains(center.x, center.y-radius); break;
				case 5: occupied = neighbour.contains(center.x+radius, center.y) ||
	                               neighbour.contains(center.x, center.y+radius); break;
				case 6: occupied = neighbour.contains(center.x-radius, center.y) ||
	                               neighbour.contains(center.x, center.y-radius); break;
				case 7: occupied = neighbour.contains(center.x-radius, center.y) ||
	                               neighbour.contains(center.x, center.y+radius); break;
			}
		}
		return occupied;
	}

	// INTERACTIONS
	public void userClicked(double atX, double atY){
		System.out.println("click");
	}
	public void userTyped(char key){
		System.out.println("key");
	}

}

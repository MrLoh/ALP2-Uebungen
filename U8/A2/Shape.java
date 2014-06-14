import java.awt.Color;
import java.awt.Graphics;

public interface Shape {
	// METHODS
	public void draw(Graphics g);
	// the draw method gets a graphical context g so that the shape-objects can paint themselves using the methods of g.

	public boolean contains(double x, double y);
	// checks if a (x, y) point is inside the Shape object.

	public double getRadius();
	// returns the radius of the circle that surrounds the shape object

	public Color getColor();
	// returns the color of the shape object.

	public Point getCenter();
	// returns the center of the Shape-object using floating-point numbers for the x- and y-coordinates (double).

	public void setShapesWorld( ShapesWorld theWorld );
	// this method is always called after a Shape-object has been created. If you want to have access to the ShapeWorld-object to get information about the other Shape-objects, you need to store this reference as an instance variable of your Shape-class.

	public void userClicked( double at_X, double at_Y );
	// this method is called when the user clicks the mouse on a Shape-object. The at_X and at_Y parameters correspond to the (x, y)-coordinates of the mouse click.

	public void userTyped(char key);
	// this method is called when the user presses the mouse to select a Shape-object and then presses a key. In key we get the pressed key.

	public void moveTo(double x, double y);
	// the Shape-object moves to the (x,y)-coordinates.

}

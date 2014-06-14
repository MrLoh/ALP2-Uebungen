import java.awt.Color;

public interface ShapesWorld{
// This interface contains the methods that a Shape object can perform through its ShapesWorld-reference.

	public int getMin_X();
	// returns the smallest visible x-coordinate of the ShapesWorld-object

	public int getMin_Y();
	// returns the smallest visible y-coordinate of the ShapesWorld-object

	public int getMax_X();
	// returns the biggest visible x-coordinate of the ShapesWorld-object

	public int getMax_Y();
	// returns the biggest visible y-coordinate of the ShapesWorld-object

	public Color getBackgroundColor();
	// returns the background color of the ShapesWorld-object

	public Shape getClosestShape( Shape myShape );
	// returns the reference of the closest object to myShape. If only the myShape object exists in the ShapesWorld-object it returns the null constant.

	public void addShape( Shape aNewShape );
	// a new shape object is added to the ShapesWorld-object

	public void removeShape( Shape toBeRemoved );
	// removes a shape from the ShapesWorld-object

}

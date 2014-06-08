public class Rectangle
{
	// attributes
	int x;
	int y;
	int width;
	int height;
	// constructors
	public Rectangle()
	{
		x = 0;
		y = 0;
		width = 10;
		height = 10;
	}
	// methods
	public int perimeter()
	{
		return 2*(width+height);
	}
	public int area()
	{
		return width*height;
	}
	// main method
	public static void main(String[] args)
	{
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		int u = r1.area();
		int f = r2.perimeter();
		// print somthing out
		System.out.println(u);
		System.out.println(f);
	}
}

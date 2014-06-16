import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Panik extends AbstractShape implements Shape, Animation {
	// ATTRIBUTES
	double velocity = 1;
	int steps = 0;
	int collisions = 0;
	int shaking = 0;
	int dir = rand.nextInt(8);
	// dir: 0: right, 1: left, 2: up, 3: down, 4: upright, 5:upleft, 6: downright, 7:downleft

	// CONSTRUCTOR
	public Panik() {
		int x = rand.nextInt(15)*20-150;
		int y = rand.nextInt(15)*20-150;
		this.center = new Point(x,y);
		this.radius = 12;
	}

	// DRAW METHODS
	public void setShapesWorld(ShapesWorld theWorld){ this.world = theWorld; }
	public void draw(Graphics g){
		fillNtagon(g, center.x, center.y, radius, 7);
	}

	// PLAY METHOD
	public void play(){
		steps++;
		while( !directionInFrame(dir, 1.2) ){
			System.out.println("cornered");
			dir = rand.nextInt(8);
		}
		if( directionOccupied(dir) ){
			System.out.println("occupied");
			collisions++;
			steps = 0;
			dir = rand.nextInt(8);
		}
		if( shaking > 0 || collisions > 20 && steps < 50 ){
			if( shaking<50 ){
				if( shaking%2 ==0 ){
					move(0, 2*velocity);
				} else {
					move(1, 2*velocity);
				}
				shaking++;
			} else {
				this.world.removeShape(this);
				for( int i=0; i<20; i++ ){
					this.world.addShape(new PanikStuck((int)center.x, (int)center.y, getColor(), rand.nextInt(4)+5, rand.nextInt(5)+3 ));
				}
			}
		} else {
			move(dir, velocity);
			if( steps > 50 ){
				collisions = 0;
			}
		}
	}

}

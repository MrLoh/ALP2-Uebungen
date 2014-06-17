import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Panik extends AbstractShape implements Shape, Animation {
	// ATTRIBUTES
	double velocity = 1;
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
	public void destroy(){
		this.world.removeShape(this);
		for( int i=0; i<20; i++ ){
			this.world.addShape(new PanikStuck(center.x, center.y, getColor(), rand.nextInt(4)+5, rand.nextInt(5)+3 ));
		}
	}

	// PLAY METHOD
	public void play(){
		steps++;
		while( !directionInFrame(dir, 1.2) ){
			dir = rand.nextInt(8);
		}
		if( directionOccupied(dir) ){
			collisions++;
			steps = 0;
			dir = rand.nextInt(8);
		}
		if( shaking > 0 || collisions > 20 && steps < 50 ){
			this.panic();
		} else {
			move(dir, velocity);
			if( steps > 50 ){
				collisions = 0;
			}
		}
	}
	public void panic(){
		if( shaking<50 ){
			if( shaking%2 ==0 ){
				move(0, 2*velocity);
			} else {
				move(1, 2*velocity);
			}
			shaking++;
		} else {
			this.destroy();
		}
	}

}

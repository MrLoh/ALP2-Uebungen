import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class MiniWrapper extends Wrapper implements Shape, Animation {

	// CONSTRUCTOR
	public MiniWrapper(double x, double y) {
		this.center = new Point(x,y);
		this.radius = 8.75;
		this.color = Color.RED;
		this.velocity = 1;
	}

	// PLAY METHOD
	public void play(){
		steps++;
		if( radius < RADIUS ){
			while( !directionInFrame(dir, 1.2) ){
				dir = rand.nextInt(8);
			}
			move(dir, velocity);
			radius *= 1.01;
			velocity *= 1.01;
		} else {
			this.world.addShape(new Wrapper(center.x, center.y));
			this.world.removeShape(this);
		}
	}

}

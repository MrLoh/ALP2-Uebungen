import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class TimeWrapper extends Wrapper {

	// CONSTRUCTOR
	public TimeWrapper() {
		int x = rand.nextInt(15)*20-150;
		int y = rand.nextInt(15)*20-150;
		this.center = new Point(x,y);
		this.radius = 35;
		this.color = Color.PINK;
	}

	// PLAY METHOD
	public void play(){
		steps++;
		if( catched ){
			if( steps > 100 ){
				for( int i=0; i<3; i++){
					this.world.addShape(new MiniWrapper(center.x, center.y));
				}
				this.world.removeShape(this);
			} else {
				if( this.world.getClosestShape(this) != slave ){
					this.world.removeShape(this);
				}
			}
		} else {
			if( directionOccupied(dir) && !(this.world.getClosestShape(this) instanceof Wrapper) ){
				catched = true;
				slave = this.world.getClosestShape(this);
				moveTo(this.slave.getCenter().x, this.slave.getCenter().y);
				steps = 0;
			} else {
				while( !directionInFrame(dir, 1.2) ){
					dir = rand.nextInt(8);
				}
				move(dir, velocity);
			}
		}
	}

}

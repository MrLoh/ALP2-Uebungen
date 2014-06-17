import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class BabyAlien extends Alien implements Shape, Animation {
	// CONSTRUCTOR
	public BabyAlien(double x, double y) {
		this.velocity = 0.5;
		this.radius = 5;
		this.color = Color.CYAN;
		this.center = new Point(x,y);
	}
	public BabyAlien() {
		this.velocity = 0.5;
		this.radius = 5;
		this.color = Color.CYAN;
		this.center = new Point();
	}

	// DRAW METHODS
	public void draw(Graphics g){
		g.setColor(color);
		// outlineCircle(g, center.x, center.y-radius/2, radius);      //helmet
		fillCircle(g, center.x, center.y-radius/4, radius);         //head
		fillAlienBody(g, center.x, center.y, radius);               //body
		// outlineNtagon(g, center.x, center.y+radius, radius/3, 5);   //hooverpad
	}
	public void mature(){
		this.world.removeShape(this);
		this.world.addShape(new Alien(center.x, center.y));
		for( int i=0; i<4; i++ ){
			this.world.addShape(new PanikStuck(center.x, center.y, Color.GREEN, 0, 8 ));
			this.world.addShape(new PanikStuck(center.x, center.y, Color.CYAN, 0, 8 ));
		}
	}

	// PLAY METHOD
	public void play(){
		steps++;
		if( radius < RADIUS*.75 ){
			radius *= 1.005;
			velocity *= 1.005;
			if( this.enslaved() ){
				Shape master = this.world.getClosestShape(this);
				if( !(master instanceof TimeWrapper) ){
					move(dir, velocity);
				}
			} else {
				if ( steps%(2*RADIUS) == 0 ){ //make him move smoother
					dir = rand.nextInt(8);
					while( !directionInFrame(dir, 6.0) ){
						dir = rand.nextInt(8);
					}
				}
				move(dir, velocity);
			}
		} else {
			this.mature();
		}
	}

}

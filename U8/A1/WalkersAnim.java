public class WalkersAnim {
	// ATTRIBUTES
	WalkerSpace ws;
	WalkerPanel wp;

	// VARIABLES
	public static int stopTime = 100; // time in milliseconds

	// CONSTRUCTOR
	public WalkersAnim( WalkerPanel wp ) {
		this.wp = wp;
		this.ws = wp.ws;
	}

	// METHODS
	public void play(int milliseconds) {
	// this play-method stops each loop for some milliseconds and tries to move all walkers
		stopTime = milliseconds;
		while ( true ) {
			if (ws.someWalkerCanMove()){
				try {
					Thread.sleep(stopTime); // stop the Program for some milliseconds
				} catch ( InterruptedException ie ) {}
				ws.moveWalkers();
				wp.repaint();
			}
			else {
				break;
			}
		}
	}

}

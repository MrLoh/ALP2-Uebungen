	public class Main {
	// MAIN
	public static void main( String args[] ) {
		int n = 40;
		IWalkerSpace ws = new IWalkerSpace(n);
		// produce a walk field and initialize n walkers
		WalkerPanel wp = new WalkerPanel(ws);
		// produce a JPanel object to visualize the walkers
		new WalkerWindow(wp, 200, 200);
		// produce a window object for the screen an put the JPanel object inside
		WalkersAnim anim = new WalkersAnim(wp);
		// produce an object to control the animation
		anim.play(50);
		// visualize all steps of the walkers each 100 milliseconds
		System.out.println(ws.getMeanWalkingDistance());
		// print mean walking distance of the walkers
	}

}

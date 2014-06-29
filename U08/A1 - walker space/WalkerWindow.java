import javax.swing.JFrame;

public class WalkerWindow  extends JFrame{
	// CONSTRUCTORS
	public WalkerWindow(WalkerPanel wp, int x, int y){
		int size = wp.pSize*(wp.ws.size+1);
		this.setSize(size+wp.pSize,size+2*wp.pSize);
		this.add( wp );
		this.setLocation(x,y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

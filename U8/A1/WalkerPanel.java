import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class WalkerPanel extends JPanel {
	// ATTRIBUTES
	WalkerSpace ws;    // walk space modeled with a matrix
	public int pSize;  // size of one position of the walkers field
	public Font font;

	// CONSTRUCTOR
	public WalkerPanel(WalkerSpace ws){
		this.ws = ws;
		this.pSize = ws.pSize;
		this.font = Position.font;
	}

	// METHODS
	public void paintComponent( Graphics g){
		g.setFont(font);
		String str;
		super.paintComponent(g);
		for( int i=ws.xMin; i<=ws.xMax; i++ ){
			for( int j=ws.yMin; j<=ws.yMax; j++ ){
				if ( ws.space[i][j] != null ){
					g.setColor(ws.space[i][j].color);
					g.fillRect(i*pSize, j*pSize, pSize, pSize);
					g.setColor(Color.WHITE);
					str = String.valueOf(ws.space[i][j].walkerSteps);
					g.drawString(str, i*pSize+3, j*pSize+pSize-4);
				} else {
					g.setColor(Position.bgColor);
					g.fillRect(i*pSize, j*pSize, pSize, pSize);
				}
				g.setColor(Color.BLUE);
				g.drawRect(i*pSize, j*pSize, pSize, pSize);
				g.setColor(Position.bgColor);
			}
		}
	}

}

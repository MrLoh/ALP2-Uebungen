public class PlayField {

	// attributes
	private Position[][] field;
	private int n;
	private int m;

	// constructor
	private void calculateNeighbours(int i, int j){
		for( int k=i-1 ; k<=i+1 ; k++ ) {
			for( int l=j-1 ; l<=j+1 ; l++ ) {
				if( this.field[k][l].hole ) {
					this.field[i][j].holeNeighbours ++;
				}
			}
		}
	}
	public PlayField(int n, int m, double p) {
		this.n = n;
		this.m = m;
		// create clear field
		this.field = new Position[n+2][m+2];
		// initialize field
		for( int i=0 ; i<=n+1 ; i++ ) {
			for( int j=0 ; j<=m+1 ; j++ ) {
				// makes sure that border has no holes
				if( i==0 || j==0 || i==n+1 || j==m+1 ) {
					this.field[i][j] = new Position(0);
				} else {
					this.field[i][j] = new Position(p);
				}
			}
		}
		// generate solution
		for( int i=1 ; i<=n ; i++ ) {
			for( int j=1 ; j<=m ; j++ ) {
				this.calculateNeighbours(i,j);
			}
		}
	}
	public PlayField() {
		this(15, 20, 0.1);
	}

	// default methods
	public String toString() {
		String out = "";
		for( int i=1 ; i<=n ; i++ ) {
			for( int j=1 ; j<=m ; j++ ) {
				if( this.field[i][j].open ) {
					if( this.field[i][j].hole ) {
						out += "\u2588 ";
					} else if( this.field[i][j].holeNeighbours == 0 ) {
						out += ". ";
					} else {
						out += this.field[i][j].holeNeighbours + " ";
					}
				} else {
					out += "x ";
				}
			}
			out += "\n";
		}
		return out;
	}

	// methods
	public void expose() {
		for( int i=1 ; i<=n ; i++ ) {
			for( int j=1 ; j<=m ; j++ ) {
				this.field[i][j].open = true;
			}
		}
	}
}

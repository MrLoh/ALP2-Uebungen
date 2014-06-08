public class PlayField {
	// attributes
	Position[][] field;
	int n;
	int m;

	// constructor
	public PlayField(int n, int m, double p) {
		this.n = n;
		this.m = m;
		// create clear field
		field = new Position[n+2][m+2];
		// initialize field
		for( int i=0 ; i<=n+1 ; i++ ) {
			for( int j=0 ; j<=m+1 ; j++ ) {
				// makes sure that border has no holes
				if( !inField(i,j) ) {
					field[i][j] = new Position(0);
				} else {
					field[i][j] = new Position(p);
				}
			}
		}
		// generate solution
		for( int i=1 ; i<=n ; i++ ) {
			for( int j=1 ; j<=m ; j++ ) {
				calculateNeighbours(i,j);
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
				if( field[i][j].open ) {
					if( field[i][j].hole ) {
						out += "\u274D ";
					} else if( field[i][j].holeNeighbours == 0 ) {
						out += ". ";
					} else {
						out += field[i][j].holeNeighbours + " ";
					}
				} else {
					out += "\u25FB ";
				}
			}
			out += "\n";
		}
		return out;
	}

	// private methods
	private void calculateNeighbours(int i, int j){
		for( int k=i-1 ; k<=i+1 ; k++ ) {
			for( int l=j-1 ; l<=j+1 ; l++ ) {
				if( field[k][l].hole ) {
					field[i][j].holeNeighbours ++;
				}
			}
		}
	}
	private boolean inField(int i, int j) {
		return i>=1 && i<=n && j>=1 && j<=m;
	}

	// public methods
	public void expose() {
		for( int i=1 ; i<=n ; i++ ) {
			for( int j=1 ; j<=m ; j++ ) {
				field[i][j].open = true;
			}
		}
	}
	public boolean updateField(int i, int j) {
		boolean playing;
		if( field[i][j].hole ) {
			expose();
			return false;
		} else if( field[i][j].holeNeighbours > 0 ) {
			field[i][j].open = true;
			return true;
		} else {
			field[i][j].open = true;
			for( int k=i-1 ; k<=i+1 ; k++ ) {
				for( int l=j-1 ; l<=j+1 ; l++ ) {
					if( inField(k,l) && !(k==i && l==j) && !field[k][l].open ) {
						updateField(k,l);
					}
				}
			}
			return true;
		}
	}
	public boolean solved() {
		boolean solution = true;
		int i = 1;
		while( solution && i<=n ) {
			int j = 1;
			while( solution && j<=m ) {
				solution = solution && (field[i][j].open || (!field[i][j].open && field[i][j].hole) );
				i++;
			}
			j++;
		}
		return solution;
	}
}

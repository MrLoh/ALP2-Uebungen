import java.util.Random;

public class Player {
	// attributes
	int score = 0;
	int rounds = 0;
	boolean playing = true;
	boolean won = false;
	PlayField playField = new PlayField();

	// constructors

	// default methods
	public String toString() {
		return String.format("%s  score: %s", playField, score);
	}

	// private methods
	private void updateScore() {
		score = 0;
		for( int i=1 ; i<=playField.n ; i++ ) {
			for( int j=1 ; j<=playField.m ; j++ ) {
				if( playField.field[i][j].open ) {
					score += playField.field[i][j].holeNeighbours;
				}
			}
		}
	}

	// public methods
	public void pick(int i, int j) {
		rounds++;
		playing = playField.updateField(i, j);
		if( playing ){
			updateScore();
			if( playField.solved() ) {
				playing = false;
				won = true;
			}
		}
	}
	private static final Random RAND = new Random();
	public String randomPick() {
		int i = 0;
		int j = 0;
		while( !playField.field[i][j].open ) {
			i = RAND.nextInt(playField.n)+1;
			j = RAND.nextInt(playField.m)+1;
			pick(i, j);
		}
		return String.format("  round: %s, picked: (%s,%s)\n", rounds, i, j);
	}
}

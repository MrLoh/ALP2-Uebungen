public class HolePlay {
	// attributes
	Player[] player;
	int size;

	// constructor
	public HolePlay(int n) {
		this.player = new Player[n];
		this.size = n;
		for( int i=0 ; i<size ; i++ ) {
			player[i] = new Player();
		}
	}

	// default methods
	public String toString() {
		String out = String.format("Game with %s Players:\n", size);
		for( int i=0 ; i<size ; i++ ) {
			out += String.format("%s score: %s\n", player[i].name, player[i].score);
		}
		return out;
	}

	// methods
	public void simulatePlay() {
		for( int i=0 ; i<size ; i++ ) {
			System.out.println(player[i].name + "\n");
			player[i].play();
		}
		Player winner = maxPlayerByScore();
		System.out.println(winner.name + " won with a score of " + winner.score + ".\n\n");
	}
	public Player maxPlayerByScore() {
		Player max = player[0];
		for( int i=1 ; i<size ; i++ ) {
			max = max.score>player[i].score ? max : player[i];
		}
		return max;
	}

	// main
	public static void main(String[] args) {
		HolePlay thisPlay = new HolePlay(5);
		thisPlay.simulatePlay();
		// System.out.println(thisPlay);
	}
}

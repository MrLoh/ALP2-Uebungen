import java.awt.Color;
import java.util.Random;

public class WalkerSpace {
	// ATTRIBUTES
	public enum Direction {NORTH, EAST, WEST, SOUTH};

	Position[][] space;
	public Walker[] walkers;
	public int size;
	public int pSize; // size of one Position
	public int xMax, yMax, xMin, yMin;
	public int margin = 2;

	Color bgColor = Position.bgColor;
	Color deadColor = Position.deadColor;

	Random rand = new Random();

	// CONSTRUCTORS
	public WalkerSpace(int size, int pSize, int numOfWalkers){
		this.size = size;
		this.xMax = size;
		this.yMax = size;
		this.xMin = 1;
		this.yMin = 1;
		this.pSize = pSize; // size of a Position
		space = new Position[size+margin][size+margin];
		initSpace();
		initWalkers(numOfWalkers);
	}
	public WalkerSpace(int numOfWalkers){
		this(40,20,numOfWalkers);
	}
	public WalkerSpace(){
		this(0);
	}

	// METHODS
	public void initSpace(){
		for(int i=0; i<space.length; i++){
			for(int j=0; j<space.length; j++){
				space[i][j] = new Position(pSize);
			}
		}
	}
	public void initWalkers(int n){
	// put n walkers on different random places
		this.walkers = new Walker[n];
		int x, y;
		for (int i=0; i<n; i++){
			int maxAttemps = 10; // try max. 10 times to find a free place
			while(maxAttemps>0){
				x = rand.nextInt(size-1)+1;
				y = rand.nextInt(size-1)+1;
				if (!marked(x,y)){
					Walker walker = new Walker(x, y);
					walkers[i] = walker;
					space[x][y].markWith(walker);
					break;
				}
				maxAttemps--;
			}
		}
	}
	public boolean marked(int x, int y){
		return space[x][y].color != bgColor;
	}
	public boolean someWalkerCanMove(){
	// return true if at least one walker still can move
		boolean someWalkerIsAlive = false;
		for (Walker walker : walkers){
			calculateFreeDirections(walker);
			someWalkerIsAlive = someWalkerIsAlive || walker.alive;
		}
		return someWalkerIsAlive;
	}
	public void calculateFreeDirections(Walker walker){
	// calculate the list of free directions a walker can take
		walker.currentFreeDirs.clear();
		if (walker.alive){
			if (isEastFree(walker)) walker.currentFreeDirs.add(Direction.EAST.ordinal());
			if (isWestFree(walker)) walker.currentFreeDirs.add(Direction.WEST.ordinal());
			if (isNorthFree(walker)) walker.currentFreeDirs.add(Direction.NORTH.ordinal());
			if (isSouthFree(walker)) walker.currentFreeDirs.add(Direction.SOUTH.ordinal());
		}
		if (walker.currentFreeDirs.isEmpty()){
			walker.setDead();
			space[walker.x][walker.y].markWith(walker);
		}
	}
	public void moveWalkers(){
	// try to move all walkers one step
		for ( Walker walker : walkers){
			if (walker.alive){
				int d = rand.nextInt(walker.currentFreeDirs.size());
				Direction dir = Direction.values()[walker.currentFreeDirs.get(d)];
				switch (dir){
					case NORTH: moveNorth(walker); break;
					case WEST:  moveWest(walker); break;
					case SOUTH: moveSouth(walker); break;
					case EAST:  moveEast(walker); break;
				}
			}
		}
	}
	public void markPositionWith(Walker walker){
	// paint the position of the walker and increment the number of steps
		++walker.steps;
		space[walker.x][walker.y].markWith(walker);
	}
	public void moveEast(Walker walker){
	// if the left position is free a walker go to the left
		if (isEastFree(walker)){
			--walker.x;
			markPositionWith(walker);
		}
	}
	public void moveWest(Walker walker){
	// a walker make a step to the right
		if (isWestFree(walker)){
			++walker.x;
			markPositionWith(walker);
		}
	}
	public void moveNorth(Walker walker){
	// a walker make a step to the north
		if (isNorthFree(walker)){
			--walker.y;
			markPositionWith(walker);
		}
	}
	public void moveSouth(Walker walker){
	// a walker make a step to the south
		if (isSouthFree(walker)){
			++walker.y;
			markPositionWith(walker);
		}
	}
	public boolean isEastFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return (x>xMin && space[x-1][y].color == bgColor);
	}
	public boolean isWestFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return x<xMax && space[x+1][y].color == bgColor;
	}
	public boolean isNorthFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return y>yMin && space[x][y-1].color == bgColor;
	}
	public boolean isSouthFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return y<yMax && space[x][y+1].color == bgColor;
	}
	public void cleanSpace(){
	// reset all positions of the matrix with the background color and the steps equal 0
		for(Position[] line: space) {
			for(Position pos: line){
				pos.reset();
			}
		}
	}

}

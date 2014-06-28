public class IWalkerSpace extends WalkerSpace {
	// ATTRIBUTES
	public enum Direction {NORTH, EAST, WEST, SOUTH, NORTHWEST, NORTHEAST, SOUTHWEST, SOUTHEAST};

	// CONSTRUCTOR
	public IWalkerSpace(int n) {
		super(n);
	}

	// METHODS
	public void calculateFreeDirections(Walker walker){
	// calculate the list of free directions a walker can take
		walker.currentFreeDirs.clear();
		if (walker.alive){
			if (isEastFree(walker)) walker.currentFreeDirs.add(Direction.EAST.ordinal());
			if (isWestFree(walker)) walker.currentFreeDirs.add(Direction.WEST.ordinal());
			if (isNorthFree(walker)) walker.currentFreeDirs.add(Direction.NORTH.ordinal());
			if (isSouthFree(walker)) walker.currentFreeDirs.add(Direction.SOUTH.ordinal());
			if (isNorthWestFree(walker)) walker.currentFreeDirs.add(Direction.NORTHWEST.ordinal());
			if (isSouthWestFree(walker)) walker.currentFreeDirs.add(Direction.SOUTHWEST.ordinal());
			if (isNorthEastFree(walker)) walker.currentFreeDirs.add(Direction.NORTHEAST.ordinal());
			if (isSouthEastFree(walker)) walker.currentFreeDirs.add(Direction.SOUTHEAST.ordinal());
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
					case NORTHWEST: moveNorthWest(walker); break;
					case SOUTHWEST: moveSouthWest(walker); break;
					case NORTHEAST: moveNorthEast(walker); break;
					case SOUTHEAST: moveSouthEast(walker); break;
				}
			}
		}
	}
	public void moveNorthEast(Walker walker){
	// if the left position is free a walker go to the left
		if (isNorthEastFree(walker)){
			--walker.x;
			--walker.y;
			markPositionWith(walker);
		}
	}
	public void moveNorthWest(Walker walker){
	// a walker make a step to the right
		if (isNorthWestFree(walker)){
			++walker.x;
			--walker.y;
			markPositionWith(walker);
		}
	}
	public void moveSouthEast(Walker walker){
	// if the left position is free a walker go to the left
		if (isSouthEastFree(walker)){
			--walker.x;
			++walker.y;
			markPositionWith(walker);
		}
	}
	public void moveSouthWest(Walker walker){
	// a walker make a step to the right
		if (isSouthWestFree(walker)){
			++walker.x;
			++walker.y;
			markPositionWith(walker);
		}
	}
	public boolean isNorthEastFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return (x>xMin && y>yMin && space[x-1][y-1].color == bgColor);
	}
	public boolean isNorthWestFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return (x<xMax && y>yMin && space[x+1][y-1].color == bgColor);
	}
	public boolean isSouthEastFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return (x>xMin && y<yMax && space[x-1][y+1].color == bgColor);
	}
	public boolean isSouthWestFree(Walker walker){
		int x = walker.x;
		int y = walker.y;
		return (x<xMax && y<yMax && space[x+1][y+1].color == bgColor);
	}
	public float getMeanWalkingDistance() {
		float meanWalkingDistance = 0;
		int numOfWalkers = 0;
		for (Walker walker : walkers){
			meanWalkingDistance += walker.steps;
			numOfWalkers ++;
		}
		return meanWalkingDistance/numOfWalkers;
	}
}

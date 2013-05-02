package model;

public class World {
	private BlockMap blockMap;
	private int worldWidth;
	private int worldHeight;
	//Kommer ha spikes, Items och CandyMonster TODO
	
	public World(final int worldWidth, final int worldHeight) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight; //maybe we will change later to a percentual amount TODO
	}

	public int getWorldWidthPx() {
		return worldWidth;
	}

	public int getWorldHeightPx() {
		return worldHeight;
	}
}
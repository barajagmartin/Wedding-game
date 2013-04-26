package model;

public class World {
	private Character character;
	private BlockMap blockMap;
	private int worldWidth;
	private int worldHeight;
	//Kommer ha spikes, Items och CandyMonster TODO
	
	public World(final Character character, final int worldWidth, final int worldHeight) {
		this.character = character;
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight; //maybe we will change later to a percentual amount TODO
	}
	
	public Character getCharacter() {
		return character;
	}

	public int getWorldWidthPx() {
		return worldWidth;
	}

	public int getWorldHeightPx() {
		return worldHeight;
	}
}
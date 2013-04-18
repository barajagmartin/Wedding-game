package model;



public class World {
	private Character character;
	private BlockMap blockMap;
	private int worldWidth;
	private int worldHeight;
	//Kommer ha spikes, Items och CandyMonster TODO
	
	public World(Character character, int worldWidth, int worldHeight) {
		this.character = character;
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
	}
	
	public Character getCharacter() {
		return character;
	}
}
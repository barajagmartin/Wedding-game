package model;

import java.util.List;

public class World {
	private int worldWidth;
	private int worldHeight;
	private Character character;
	private List<MoveableBox> moveableBoxes;
	private List<CandyMonster> candyMonsters;
	private List<Item> items;
	private List<Spikes> spikes;
	
	public World(final int worldWidth, final int worldHeight, final Character character,
			final List<MoveableBox> moveableBoxes2, final List<CandyMonster> candyMonsters2,
			final List<Item> items2, final List<Spikes> spikes2) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.character = character;
		this.moveableBoxes = moveableBoxes2;
		this.candyMonsters = candyMonsters2;
		this.items = items2;
		this.spikes = spikes2;
	}

	public List<MoveableBox> getMoveableBoxes() {
		return moveableBoxes;
	}

	public List<CandyMonster> getCandyMonsters() {
		return candyMonsters;
	}

	public List<Item> getItems() {
		return items;
	}

	public List<Spikes> getSpikes() {
		return spikes;
	}

	public int getWorldWidthPx() {
		return worldWidth;
	}

	public int getWorldHeightPx() {
		return worldHeight;
	}

	public Character getCharacter() {
		return character;
	}
}
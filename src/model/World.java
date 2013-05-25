package model;

import java.util.ArrayList;

public class World {
	private BlockMap blockMap;
	private int worldWidth;
	private int worldHeight;
	private Character character;
	private ArrayList<MoveableBox> moveableBoxes;
	private ArrayList<CandyMonster> candyMonsters;
	private ArrayList<Item> items;
	private ArrayList<Spikes> spikes;
	
	public World(final int worldWidth, final int worldHeight, final Character character,
			final ArrayList<MoveableBox> moveableBoxes, final ArrayList<CandyMonster> candyMonsters,
			final ArrayList<Item> items, final ArrayList<Spikes> spikes) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.character = character;
		this.moveableBoxes = moveableBoxes;
		this.candyMonsters = candyMonsters;
		this.items = items;
		this.spikes = spikes;
	}

	public ArrayList<MoveableBox> getMoveableBoxes() {
		return moveableBoxes;
	}

	public ArrayList<CandyMonster> getCandyMonsters() {
		return candyMonsters;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public ArrayList<Spikes> getSpikes() {
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
package model;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;


public class InGame {
	private Player player;
	private World world;
	//the total time of the level
	private float levelTime;
	private int level;
	//the changeable time
	private float time;
	private boolean isNewGame;
	private boolean gameOver;
	private File folder;
	private boolean isPaused;
	private int itemsDelivered;

		
	public InGame(Player player) {
		this.player = player;
		this.isNewGame = true;
		this.gameOver = false;
		this.folder = new File(".");
		this.level = 1;
		isPaused = false;
		itemsDelivered = 0;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public Player getPlayer() {
		return player;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public float getLevelTime() {
		return levelTime;
	}

	public void setLevelTime(float levelTime) {
		this.levelTime = levelTime;
	}
	

	public int getLevel() {
		return this.level;
	}
	
	public void levelUp() {
		this.level++;
	}
	
	public int randomizeVersion(int nbrOfVersions) {
		return new Random().nextInt(nbrOfVersions) + 1;
	}
	
	public boolean isNewGame() {
		return isNewGame;
	}

	public void setNewGame(final boolean isNewGame) {
		this.isNewGame = isNewGame;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void reset() {
		this.gameOver = false;
		this.isPaused = false;
		this.itemsDelivered = 0;
	}
	
	/**
	 * Find files that are on the form levelx.y.tmx.
	 * 
	 * x is the level
	 * y is the level version
	 * @return the filenameFilter
	 */
	public FilenameFilter findFiles(final int level) {
		FilenameFilter filenameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.matches("level" + String.valueOf(level) + ".\\d.tmx");
			}
		};
		return filenameFilter;
	}
	
	public int getNbrOfFiles(int level) {
		return folder.listFiles(findFiles(level)).length;
		
	}

	public void resetLevel() {
		this.level = 1;
	}
	
	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	
	public int getItemsDelivered() {
		return itemsDelivered;
	}

	/**
	 * checks if the game is done by checking the lives on the character 
	 * and the items left in the world.
	 * 
	 */
	public boolean checkIfGameIsOver(int totalAmountOfItems) {
		if (totalAmountOfItems == itemsDelivered) {
			if (getNbrOfFiles(level + 1) == 0) {
				player.setScore(time < 1 ? 1 : (int)time, this.itemsDelivered, player.getLife());
			} else {
				player.setScore(time < 1 ? 1 : (int)time, this.itemsDelivered);
			}
			return true;
		} else if (player.getLife() == 0 || time <= 0) {
			setGameOver(true);
			return true;
		}
		return false;
	}

	public void increaseItemsDelivered() {
		itemsDelivered++;
	}
}
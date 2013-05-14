package model;

import java.util.Random;


public class InGame {
	private Player player;
	//the total time of the level
	private float levelTime;
	//the changable time
	private float time;
	private static boolean isNewGame = true;
		
	public InGame(Player player) {
		this.player = player;
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

	public float getLevelTime() {
		return levelTime;
	}

	public void setLevelTime(float levelTime) {
		this.levelTime = levelTime;
	}
	
	public int randomizeVersion(int nbrOfVersions) {
		return new Random().nextInt(nbrOfVersions) + 1;
	}
	
	public static boolean isNewGame() {
		return isNewGame;
	}

	public static void setNewGame(final boolean newGame) {
		isNewGame = newGame;
	}
}
package model;

import java.util.Random;


public class InGame {
	private Player player;
	//the total time of the level
	private float levelTime;
	//the changable time
	private float time;
	private boolean isNewGame;
	private boolean gameOver;
		
	public InGame(Player player) {
		this.player = player;
		this.isNewGame = true;
		this.gameOver = false;
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
	}
}
package model;


public class InGame {
	private Player player;
	private StatusBar statusBar;
	//the total time of the level
	private float levelTime;
	//the changable time
	private float time;
		
	public InGame() { 
		this.levelTime = 1*60; //set specific to level (in this case it is 2 min)
		this.time = this.levelTime;
		
		statusBar = new StatusBar();
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


	public StatusBar getStatusBar() {
		return statusBar;
	}

	public float getLevelTime() {
		return levelTime;
	}

}

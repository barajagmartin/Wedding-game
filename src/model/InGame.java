package model;


public class InGame {
	private Player player;
	private StatusBar statusBar;
		
	public InGame(Character character) { 
		player = new Player(character);
		statusBar = new StatusBar();
	}

	public Player getPlayer() {
		return player;
	}


	public StatusBar getStatusBar() {
		return statusBar;
	}
}

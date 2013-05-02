package model;


public class InGame {
	private World world;
	private Player player;
	private StatusBar statusBar;
		
	public InGame(Character character) {
		this.world = world; 
		player = new Player(character);
		statusBar = new StatusBar();
	}

	public Player getPlayer() {
		return player;
	}

	public World getWorld() {
		return world;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}
}

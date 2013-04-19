package model;


public class InGame {
	private World world;
	private Player player;
	private StatusBar statusBar;
		
	public InGame(model.World world) {
		this.world = world; 
		player = new Player(world.getCharacter());
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

	public int getID() {
		return Game.IN_GAME;
	}
}

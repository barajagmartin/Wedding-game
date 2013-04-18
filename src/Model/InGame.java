package model;


public class InGame {
	private final int STATE_ID;
	private Player player;
	private World world;
	private StatusBar statusBar;
		
	public InGame(final int STATE_ID) {
		this.STATE_ID = STATE_ID;
		player = new Player();
		//world = new World(player.getCharacter()); FIXME
		statusBar = new StatusBar();
	}

	public int getID() {
		return STATE_ID;
	}
}

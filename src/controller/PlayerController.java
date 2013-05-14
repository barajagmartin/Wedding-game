package controller;

import model.Player;

public class PlayerController {
	
	private Player player;
	private InGameController inGameController;

	public PlayerController(InGameController inGameController) {
		this.inGameController = inGameController;
		this.player = new Player();
	}
	
	public Player getPlayer() {
		return player;
	}
}

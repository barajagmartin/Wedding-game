package controller;

import model.Player;

public class PlayerController {
	
	private Player player;
	public PlayerController() {
		this.player = new Player();
	}
	
	public Player getPlayer() {
		return player;
	}
}

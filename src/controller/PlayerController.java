package controller;

import model.Player;

/**
 * This class represent you as a player, the one moving the character on the screen.
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class PlayerController {
	
	private final Player player;
	public PlayerController() {
		this.player = new Player();
	}
	
	public Player getPlayer() {
		return player;
	}
}

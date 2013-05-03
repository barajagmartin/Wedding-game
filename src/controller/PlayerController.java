package controller;

import model.Player;

public class PlayerController {
	
	private Player player;
	
	public PlayerController(model.Character character) {
		player = new Player(character);
	}
}

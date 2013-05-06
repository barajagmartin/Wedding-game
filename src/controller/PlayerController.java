package controller;

import model.Player;

public class PlayerController {
	
	private Player player;
	private CharacterController characterController;
	private InGameController inGameController;

	public PlayerController(CharacterController characterController,
			InGameController inGameController) {
		this.characterController = characterController;
		this.inGameController = inGameController;
		this.player = new Player(characterController.getCharacter());
	}
	
	public Player getPlayer() {
		return player;
	}


	public CharacterController getCharacterController() {
		return characterController;
	}
}

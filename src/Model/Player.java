package model;



public class Player {
	private Character character;

	public Player() {
		character = new Character(400, 100);
	}

	public Character getCharacter() {
		return character;
	}
}

package Model;


public class PlayerModel {
	private CharacterModel character;
	
	public PlayerModel() {
		character = new CharacterModel(10, 525);
	}

	public CharacterModel getCharacter() {
		return character;
	}
}

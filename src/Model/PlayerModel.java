package Model;


public class PlayerModel {
	private CharacterModel character;
	
	public PlayerModel() {
		character = new CharacterModel(400,300);
	}

	public CharacterModel getCharacter() {
		return character;
	}
}

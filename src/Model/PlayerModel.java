package Model;


public class PlayerModel {
	private CharacterModel character;
	
	public PlayerModel() {
		character = new CharacterModel();
	}


	public CharacterModel getCharacter() {
		return character;
	}
}

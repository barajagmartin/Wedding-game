package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCharacterModel {

	@Test
	public void test() {
		CharacterModel character = new CharacterModel(0, 0);
		int lifeFromStart = character.getLife();
		character.loseOneLife();
		assertTrue(lifeFromStart-1 == character.getLife());
	}

}

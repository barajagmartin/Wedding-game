package model;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Character;


public class CharacterTest {

	@Test
	public void test() {
		Character character = new Character(0, 0);
		int lifeFromStart = character.getLife();
		character.loseOneLife();
		assertTrue(lifeFromStart-1 == character.getLife());
	}
}

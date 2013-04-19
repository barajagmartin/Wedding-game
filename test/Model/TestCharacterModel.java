package Model;

import static org.junit.Assert.*;


import model.Character;

import org.junit.Test;
import org.newdawn.slick.Color;

public class TestCharacterModel {

	@Test
	public void test() {
		Character character = new Character(0, 0);
		int lifeFromStart = character.getLife();
		character.loseOneLife();
		assertTrue(lifeFromStart-1 == character.getLife());
	}
	
	@Test
	public void testColor() {
		Character character = new Character(0, 0);
		character.setColor(Color.blue);
		assertTrue(character.getColor()==Color.blue);
	}


}

package model;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Character;


public class CharacterTest {

	@Test
	public void testLoseOneLife() {
		Character character = new Character(0, 0);
		int lifeFromStart = character.getLife();
		character.loseOneLife();
		assertTrue(lifeFromStart-1 == character.getLife());
	}
	
	@Test
	public void testPickUpItem() {
		Item item = new Item(20, 30, 2);
		Character character = new Character(0, 0);
		character.pickUpItem(item);
		assertTrue(item.getX() == character.getX());
		assertTrue(item.getY() == character.getY());
		assertTrue(item.isPickedUp());
		assertTrue(character.getHeldItem() == item);
	}
	
	/** Is not expected to work if testPickUpItem doesn't work */
	@Test
	public void testDropDownItem() {
		Item item = new Item(20, 30, 2);
		Character character = new Character(0, 0);
		character.pickUpItem(item);
		character.dropDownItem(item);
		assertTrue(!item.isPickedUp());
		assertTrue(item.getX() == character.getX() + Character.RADIUS);
		assertTrue(item.getY() == character.getY()+ Character.RADIUS*2-item.HEIGHT);
		assertTrue(character.getHeldItem() == null);
	}
}

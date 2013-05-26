package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import model.Character;


public class CharacterTest {

	@Test
	public void testPickUpItem() {
		Item item = new Item(20, 30, 2);
		Character character = new Character(0, 0);
		character.pickUpItem(item);
		assertTrue(item.getPos().getX() == character.getX());
		assertTrue(item.getPos().getY() == character.getY());
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
		assertTrue(item.getPos().getY() == character.getY()+Character.RADIUS-Item.HEIGHT);
		assertTrue(!item.isPickedUp());
		assertTrue(character.getHeldItem() == null);
	}
	
	@Test
	public void testIsHoldingItem() {
		Character character = new Character(0, 0);
		ArrayList <Item> itemList = new ArrayList <Item>();
		itemList.add(new Item(10, 10, 0));
		itemList.add(new Item(20, 10, 1));
		itemList.add(new Item(30, 10, 2));
		assertTrue(!character.isHoldingItem(itemList));	
		itemList.get(1).setPickedUp(true);
		assertTrue(character.isHoldingItem(itemList));
		itemList.get(1).setPickedUp(false);
		assertTrue(!character.isHoldingItem(itemList));	
	}
	
	@Test
	public void testIsOnSpikes() {
		Character character = new Character(100, 100);
		assertTrue(!character.isOnSpikes());
		character.setOnSpikes(true);
		assertTrue(character.isOnSpikes());
	}
}

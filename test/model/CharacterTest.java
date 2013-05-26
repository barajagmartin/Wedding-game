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
		assertSame(item.getPos().getX(), character.getPos().getX());
		assertSame(item.getPos().getY(), character.getPos().getY());
		assertTrue(item.isPickedUp());
		assertSame(character.getHeldItem(), item);
	}
	
	/** Is not expected to work if testPickUpItem doesn't work */
	@Test
	public void testDropDownItem() {
		Item item = new Item(20, 30, 2);
		Character character = new Character(0, 0);
		character.pickUpItem(item);
		character.dropDownItem(item);
		assertSame(item.getPos().getY(), character.getPos().getY()+Character.RADIUS-Item.HEIGHT);
		assertFalse(item.isPickedUp());
		assertSame(character.getHeldItem(), null);
	}
	
	@Test
	public void testIsHoldingItem() {
		Character character = new Character(0, 0);
		ArrayList <Item> itemList = new ArrayList <Item>();
		itemList.add(new Item(10, 10, 0));
		itemList.add(new Item(20, 10, 1));
		itemList.add(new Item(30, 10, 2));
		assertFalse(character.isHoldingItem(itemList));	
		itemList.get(1).setPickedUp(true);
		assertTrue(character.isHoldingItem(itemList));
		itemList.get(1).setPickedUp(false);
		assertFalse(character.isHoldingItem(itemList));	
	}
	
	@Test
	public void testIsOnSpikes() {
		Character character = new Character(100, 100);
		assertFalse(character.isOnSpikes());
		character.setOnSpikes(true);
		assertTrue(character.isOnSpikes());
	}
}

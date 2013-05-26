package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testIsPickedUp() {
		Item item = new Item(0, 10, 1);
		assertFalse(item.isPickedUp());
		item.setPickedUp(true);
		assertTrue(item.isPickedUp());
	}
	
	@Test
	public void testIsDelivered() {
		Item item = new Item(0, 10, 1);
		assertFalse(item.isDelivered());
		item.setDelivered(true);
		assertTrue(item.isDelivered());
	}

}

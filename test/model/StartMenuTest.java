package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StartMenuTest {

	@Test
	public void testMarkButtonDown() {
		StartMenu startMenu = new StartMenu();
		for(int i = 0; i < 6; i++) {
			startMenu.markButtonDown();
		}
		assertSame(startMenu.getIsMarked(), 0);
		startMenu.markButtonDown();
		assertSame(startMenu.getIsMarked(), 1);
	}
	
	@Test
	public void testMarkButtonUp() {
		StartMenu startMenu = new StartMenu();
		startMenu.markButtonUp();
		assertSame(startMenu.getIsMarked(), 5);
		startMenu.markButtonUp();
		assertSame(startMenu.getIsMarked(), 4);
	}

}

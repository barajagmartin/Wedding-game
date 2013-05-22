package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PauseMenuTest {

	@Test
	public void testMarkButtonDown() {
		PauseMenu pauseMenu = new PauseMenu();
		for(int i = 0; i < 5; i++) {
			pauseMenu.markButtonDown();
		}
		assertTrue(pauseMenu.getIsMarked() == 0);
		pauseMenu.markButtonDown();
		assertTrue(pauseMenu.getIsMarked() == 1);
	}
	
	@Test
	public void testMarkButtonUp() {
		PauseMenu pauseMenu = new PauseMenu();
		pauseMenu.markButtonUp();
		assertTrue(pauseMenu.getIsMarked() == 4);
		pauseMenu.markButtonUp();
		assertTrue(pauseMenu.getIsMarked() == 3);
	}
	
	@Test
	public void testResetIsMarked() {
		PauseMenu pauseMenu = new PauseMenu();
		pauseMenu.markButtonUp();
		pauseMenu.resetIsMarked();
		assertTrue(pauseMenu.getIsMarked() == 0);
	}

}

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
		assertSame(pauseMenu.isMarked(), 0);
		pauseMenu.markButtonDown();
		assertSame(pauseMenu.isMarked(), 1);
	}
	
	@Test
	public void testMarkButtonUp() {
		PauseMenu pauseMenu = new PauseMenu();
		pauseMenu.markButtonUp();
		assertSame(pauseMenu.isMarked(), 4);
		pauseMenu.markButtonUp();
		assertSame(pauseMenu.isMarked(), 3);
	}
	
	@Test
	public void testResetIsMarked() {
		PauseMenu pauseMenu = new PauseMenu();
		pauseMenu.markButtonUp();
		pauseMenu.resetIsMarked();
		assertSame(pauseMenu.isMarked(), 0);
	}

}

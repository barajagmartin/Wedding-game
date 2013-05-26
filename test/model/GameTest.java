package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testIsSoundOn() {
		Game game = new Game(new InGame(new Player()));
		assertTrue(game.isSoundOn());
		game.setSoundOn(false);
		assertFalse(game.isSoundOn());
	}
	
	@Test
	public void testMusicOn() {
		Game game = new Game(new InGame(new Player()));
		assertTrue(game.isMusicOn());
		game.setMusicOn(false);
		assertFalse(game.isMusicOn());
	}

}

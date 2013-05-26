package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class InGameTest {

	@Test
	public void testLevelUp() {
		InGame inGame = new InGame(new Player());
		assertSame(inGame.getLevel(), 1);
		inGame.levelUp();
		assertSame(inGame.getLevel(), 2);
		inGame.levelUp();
		assertSame(inGame.getLevel(), 3);
	}
	
	@Test
	public void testIsNewGame() {
		InGame inGame = new InGame(new Player());
		assertTrue(inGame.isNewGame());
		inGame.setNewGame(false);
		assertFalse(inGame.isNewGame());
	}
	
	@Test
	public void testIsGameOver() {
		InGame inGame = new InGame(new Player());
		assertFalse(inGame.isGameOver());
		inGame.setGameOver(true);
		assertTrue(inGame.isGameOver());
	}
	
	@Test
	public void testReset() {
		InGame inGame = new InGame(new Player());
		inGame.setGameOver(true);
		inGame.setPaused(true);
		inGame.increaseItemsDelivered();
		assertSame(inGame.isGameOver(), true);
		assertSame(inGame.isPaused(), true);
		assertSame(inGame.getItemsDelivered(), 1);
		inGame.reset();
		assertSame(inGame.isGameOver(), false);
		assertSame(inGame.isPaused(), false);
		assertSame(inGame.getItemsDelivered(), 0);
	}
	
	@Test
	public void testResetLevel() {
		InGame inGame = new InGame(new Player());
		inGame.levelUp();
		inGame.levelUp();
		assertSame(inGame.getLevel(), 3);
		inGame.resetLevel();
		assertSame(inGame.getLevel(), 1);
	}
	
	@Test
	public void testIsPaused() {
		InGame inGame = new InGame(new Player());
		assertFalse(inGame.isPaused());
		inGame.setPaused(true);
		assertTrue(inGame.isPaused());
	}
	
	@Test
	public void testIfGameIsOver() {
		InGame inGame = new InGame(new Player());
		inGame.setTime(10);
		inGame.increaseItemsDelivered();
		assertFalse(inGame.checkIfGameIsOver(2, 0));
		inGame.increaseItemsDelivered();
		assertTrue(inGame.checkIfGameIsOver(2, 0));
		inGame.getPlayer().loseOneLife();
		assertFalse(inGame.checkIfGameIsOver(3, 0));
		inGame.getPlayer().loseOneLife();
		inGame.setTime(0);
		assertTrue(inGame.checkIfGameIsOver(3, 0));
		inGame.setTime(10);
		inGame.getPlayer().loseOneLife();
		assertTrue(inGame.checkIfGameIsOver(3, 0));
	}
	
	@Test
	public void testIncreaseItemsDelivered() {
		InGame inGame = new InGame(new Player());
		inGame.increaseItemsDelivered();
		assertTrue(inGame.getItemsDelivered() == 1);
		inGame.increaseItemsDelivered();
		assertTrue(inGame.getItemsDelivered() == 2);
	}
	
	@Test
	public void testIsTimeRunningOut() {
		InGame inGame = new InGame(new Player());
		inGame.setLevelTime(10f);
		inGame.setTime(5f);
		assertFalse(inGame.isTimeRunningOut());
		inGame.setTime(1f);
		assertFalse(inGame.isTimeRunningOut());
		inGame.setTime(0.9f);
		assertTrue(inGame.isTimeRunningOut());
	}
}

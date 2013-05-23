package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class InGameTest {

	@Test
	public void testLevelUp() {
		InGame inGame = new InGame(new Player());
		assertTrue(inGame.getLevel() == 1);
		inGame.levelUp();
		assertTrue(inGame.getLevel() == 2);
		inGame.levelUp();
		assertTrue(inGame.getLevel() == 3);
	}
	
	@Test
	public void testReset() {
		InGame inGame = new InGame(new Player());
		inGame.setGameOver(true);
		inGame.setPaused(true);
		inGame.increaseItemsDelivered();
		assertTrue(inGame.isGameOver() == true && inGame.isPaused() == true && inGame.getItemsDelivered() == 1 );
		inGame.reset();
		assertTrue(inGame.isGameOver() == false && inGame.isPaused() == false && inGame.getItemsDelivered() == 0 );
	}
	
	@Test
	public void testResetLevel() {
		InGame inGame = new InGame(new Player());
		inGame.levelUp();
		inGame.levelUp();
		assertTrue(inGame.getLevel() == 3);
		inGame.resetLevel();
		assertTrue(inGame.getLevel() == 1);
	}
	
	@Test
	public void testIfGameIsOver() {
		InGame inGame = new InGame(new Player());
		inGame.setTime(10);
		inGame.increaseItemsDelivered();
		assertTrue(!inGame.checkIfGameIsOver(2));
		inGame.increaseItemsDelivered();
		assertTrue(inGame.checkIfGameIsOver(2));
		inGame.getPlayer().loseOneLife();
		assertTrue(!inGame.checkIfGameIsOver(3));
		inGame.getPlayer().loseOneLife();
		inGame.setTime(0);
		assertTrue(inGame.checkIfGameIsOver(3));
		inGame.setTime(10);
		inGame.getPlayer().loseOneLife();
		assertTrue(inGame.checkIfGameIsOver(3));
		
	}

}

package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testLoseOneLife() {
		Player player = new Player();
		int lifeFromStart = player.getLife();
		player.loseOneLife();
		assertSame(lifeFromStart-1, player.getLife());
	}
	
	@Test
	public void testSetScore() {
		Player player1 = new Player();
		player1.setScore(10, 2);
		assertSame(player1.getScore(), 20);
		player1.setScore(5, 1);
		assertSame(player1.getScore(), 25);
		
		Player player2 = new Player();
		player2.setScore(10, 2, 3);
		assertSame(player2.getScore(), 320);
		player2.setScore(10, 1, 1);
		assertSame(player2.getScore(), 430);
	}
	
	@Test
	public void testReset() {
		Player player = new Player();
		player.setScore(10, 2);
		player.loseOneLife();
		player.reset();
		assertSame(player.getScore(), 0);
		assertSame(player.getLife(), 3);
	}
}

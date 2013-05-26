package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandyMonsterTest {

	@Test
	public void testIsHappy() {
		CandyMonster candyMonster = new CandyMonster(0, 0, 1);
		assertTrue(!candyMonster.isHappy);
		candyMonster.setIsHappy(true);
		assertTrue(candyMonster.isHappy);
	}

}

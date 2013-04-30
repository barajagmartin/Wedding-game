package model;

import org.newdawn.slick.Color;

public class CandyMonster {
	public final int CANDY_NUMBER;
	private int x;
	private int y;
	public static final int WIDTH = 25;
	public static final int HEIGHT = 30;
	
	public CandyMonster(int x, int y, int candyNumber) {
		this.x = x;
		this.y = y;
		this.CANDY_NUMBER = candyNumber;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}

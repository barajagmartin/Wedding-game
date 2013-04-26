package model;

import org.newdawn.slick.Color;

public class CandyMonster {
	public final int CANDY_NUMBER;
	private int x;
	private int y;
	public final int WIDTH;
	public final int HEIGHT;
	
	public CandyMonster(int x, int y, int candyNumber) {
		this.x = x;
		this.y = y;
		this.CANDY_NUMBER = candyNumber;
		this.WIDTH = 20;
		this.HEIGHT = 25;
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
	
	public int getCandyNumber() {
		return this.CANDY_NUMBER;
	}
	
}

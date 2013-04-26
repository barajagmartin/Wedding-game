package model;


public class Item {
	
	private int x;
	private int y;
	public final int WIDTH;
	public final int HEIGHT;
	public final int CANDY_NUMBER;
	
	public Item(int x, int y, int candyNumber) {
		this.x = x;
		this.y = y;
		this.CANDY_NUMBER = candyNumber;
		this.WIDTH = 10;
		this.HEIGHT = 15;
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

package model;


public class Item {
	
	private int x;
	private int y;
	public final int WIDTH = 30;
	public final int HEIGHT = 20;
	public final int CANDY_NUMBER;
	
	public Item(int x, int y, int candyNumber) {
		this.x = x;
		this.y = y;
		this.CANDY_NUMBER = candyNumber;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}		
}

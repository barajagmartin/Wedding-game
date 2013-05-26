package model;

public class CandyMonster {
	public final int CANDY_NUMBER;
	private Position pos;
	public static final int WIDTH = 25;
	public static final int HEIGHT = 30;
	public boolean isHappy;
	
	public CandyMonster(int x, int y, int candyNumber) {
		this(new Position(x, y), candyNumber);
	}
	public CandyMonster(final Position pos, final int candyNumber) {
		this.pos = pos;
		this.CANDY_NUMBER = candyNumber;
		this.isHappy = false;
	}
	
	
	public Position getPos() {
		return this.pos;
	}
	
	public boolean isHappy() {
		return isHappy;
	}
	public void setIsHappy(boolean isHappy) {
		this.isHappy = isHappy;
		
	}
}

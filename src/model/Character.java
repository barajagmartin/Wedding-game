package model;

public class Character {
	public static final int RADIUS = 25;
	private int x, y;
	private int life;
	
	public Character(final int x, final int y) {
		this.x = x;
		this.y = y;
		this.life = 3;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(final int x) {
		this.x = x;
	}
	
	public void setY(final int y) {
		this.y = y;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void loseOneLife() {
		this.life--;
	}	
}
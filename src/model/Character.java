package model;

public class Character {
	public final int RADIUS;
	private int x, y;
	private int life;
	
	public Character(final int x, final int y) {
		this.x = x;
		this.y = y;
		this.life = 3;
		this.RADIUS = 25;
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
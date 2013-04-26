package model;

public class Character {
	public final int WIDTH;
	public final int HEIGHT;
	private int x, y;
	private int life;
	
	public Character(final int x, final int y) {
		this.x = x;
		this.y = y;
		this.life = 3;
		this.WIDTH = 40;
		this.HEIGHT = 50;
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
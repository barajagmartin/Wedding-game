package model;

public class Character {
	public final float width;
	public final float height;
	private float x, y;
	private int life;
	
	public Character(final float x, final float y) {
		this.x = x;
		this.y = y;
		this.life = 3;
		this.width = 50;
		this.height = 60;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setX(final float x) {
		this.x = x;
	}
	
	public void setY(final float y) {
		this.y = y;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void loseOneLife() {
		this.life--;
	}	
}
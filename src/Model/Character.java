package model;

public class Character {
	private float x, y;
	private int life;
	
	public Character(float x, float y) {
		this.x = x;
		this.y = y;
		this.life = 3;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void loseOneLife() {
		this.life--;
	}		
}
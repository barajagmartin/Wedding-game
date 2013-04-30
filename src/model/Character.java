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
	
	public void pickUpItem(Item item){
		item.setX(this.x);
		item.setY(this.y);
		item.setPickedUp(true);
	}
	
	public void dropDownItem(Item item){
		item.setY(this.y-RADIUS);
		item.setPickedUp(false);
	}
}
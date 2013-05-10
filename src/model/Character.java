package model;

public class Character {
	public static final int RADIUS = 25;
	private Position pos;
	private int life;
	private Item heldItem;
	private float timeSinceHit; //in seconds

	public Character(final int x, final int y) {
		this(new Position(x,y));
	}
	
	public Character(final Position pos) {
		this.pos = pos;
		this.life = 3;
		this.heldItem = null;
		this.timeSinceHit = 0;
	}
	
	public int getX() {
		return this.pos.getX();
	}
	
	public int getY() {
		return this.pos.getY();
	}
	
	public void setX(final int x) {
		this.pos.setX(x);
	}
	
	public void setY(final int y) {
		this.pos.setY(y);
	}
	
	public float getTimeSinceHit() {
		return timeSinceHit;
	}

	public void setTimeSinceHit(float timeSinceHit) {
		this.timeSinceHit = timeSinceHit;
	}

	public int getLife() {
		return this.life;
	}
	
	public Item getHeldItem() {
		return heldItem;
	}
	
	public void loseOneLife() {
		this.life--;
	}	
	
	public void pickUpItem(Item item){
		item.setX(this.pos.getX());
		item.setY(this.pos.getY());
		item.setPickedUp(true);
		this.heldItem = item;
	}
	
	public void dropDownItem(Item item){
		item.setPickedUp(false);
		item.setX(this.pos.getX()+RADIUS);
		item.setY((this.pos.getY()+RADIUS*2-Item.HEIGHT));
		this.heldItem = null;
	}
}
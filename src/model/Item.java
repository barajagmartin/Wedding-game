package model;

public class Item {
	private Position pos;
	private boolean isPickedUp;
	public boolean isDelivered;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 15;
	public final int CANDY_NUMBER;
	
	public Item(final int x, final int y, final int candyNumber) {
		this(new Position(x,y), candyNumber);
	}
	public Item(final Position pos, final int candyNumber) {
		this.pos = pos;
		this.isPickedUp = false;
		this.isDelivered = false;
		this.CANDY_NUMBER = candyNumber;
	}

	public int getX() {
		return this.pos.getX();
	}

	public int getY() {
		return this.pos.getY();
	}

	public void setX(int x) {
		this.pos.setX(x);
	}
	
	public void setY(int y) {
		this.pos.setY(y);
	}

	public boolean isPickedUp() {
		return isPickedUp;
	}

	public void setPickedUp(boolean isPickedUp) {
		this.isPickedUp = isPickedUp;
	}
	
	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	
}

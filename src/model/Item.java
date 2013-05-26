package model;

/**
 * Model for the items (candy) that the player are suppose to bring to the CandyMonsters
 */
public class Item {
	private Position pos;
	private boolean isPickedUp;
	private boolean isDelivered;
	public static final int WIDTH = 15;
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

	public Position getPos() {
		return this.pos;
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
package model;

import java.util.List;

/**
 * Model of the figure on the screen that interacts with the environment.
 */
public class Character {
	public static final int RADIUS = 25;
	private Position pos;
	private Item heldItem;
	private float timeSinceHit; //in seconds
	private boolean isOnSpikes;

	public Character(final int x, final int y) {
		this(new Position(x,y));
	}
	
	public Character(final Position pos) {
		this.pos = pos;
		this.heldItem = null;
		this.timeSinceHit = 1;
	}

	public Position getPos() {
		return pos;
	}
	
	public float getTimeSinceHit() {
		return timeSinceHit;
	}

	public void setTimeSinceHit(float timeSinceHit) {
		this.timeSinceHit = timeSinceHit;
	}
	
	public Item getHeldItem() {
		return heldItem;
	}	
	
	public void pickUpItem(Item item){
		item.getPos().setX(this.pos.getX());
		item.getPos().setY(this.pos.getY());
		item.setPickedUp(true);
		this.heldItem = item;
	}
	
	public void dropDownItem(Item item){
		item.setPickedUp(false);
		item.getPos().setY(item.getPos().getY()+RADIUS-Item.HEIGHT);
		this.heldItem = null;
	}

	public boolean isOnSpikes() {
		return isOnSpikes;
	}

	public void setOnSpikes(boolean isOnSpikes) {
		this.isOnSpikes = isOnSpikes;
	}
	
	/**
	 * 
	 * @return true if the a character is holding an item.
	 */
	public boolean isHoldingItem(List<Item> itemList) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).isPickedUp()) {
				return true;
			}
		}
		return false;
	}
}
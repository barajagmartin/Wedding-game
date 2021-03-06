package controller;

import org.newdawn.slick.SlickException;

import view.ItemView;
import model.Item;
/**
 * This class represent the different candies in the world the candymonsters wants.
 * @author Josefin, Martin, Sara, Kino
 */
public class ItemController {
	
	private Item item;
	private ItemView itemView;
	
	public ItemController(InGameController iGController, int candyNumber, int index) throws SlickException {
		InGameController inGameController = iGController;
		this.item = new Item(inGameController.getBlockMapController().getItemMap().getBlockList().get(index).getPosX(), 
								inGameController.getBlockMapController().getItemMap().getBlockList().get(index).getPosY(), 
								candyNumber); //x, y, candyNumber
		this.itemView = new ItemView(this.item); 
	}
	
	public Item getItem(){
		return item;
	}
	
	public ItemView getItemView(){
		return itemView;
	}
	
	/**
	 * Update the item's position
	 */
	public void updateItemShape(){
		this.itemView.getShape().setX(this.item.getPos().getX());
		this.itemView.getShape().setY(this.item.getPos().getY());
	}

}

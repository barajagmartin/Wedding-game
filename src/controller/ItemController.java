package controller;

import org.newdawn.slick.SlickException;

import view.ItemView;
import model.Item;

public class ItemController {
	
	private InGameController inGameController;
	private Item item;
	private ItemView itemView;
	
	public ItemController(InGameController inGameController, int candyNumber, int index) throws SlickException {
		this.inGameController = inGameController;
		this.item = new Item(this.inGameController.getBlockMapController().getItemMap().getBlockList().get(index).getPosX(), 
								this.inGameController.getBlockMapController().getItemMap().getBlockList().get(index).getPosY(), 
								candyNumber); //x, y, candyNumber
		this.itemView = new ItemView(this.item); 
	}
	
	public Item getItem(){
		return item;
	}
	
	public ItemView getItemView(){
		return itemView;
	}
	
	public void updateItemShape(){
		this.itemView.getShape().setX(this.item.getPos().getX());
		this.itemView.getShape().setY(this.item.getPos().getY());
	}

}

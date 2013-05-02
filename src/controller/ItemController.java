package controller;

import view.ItemView;
import model.Item;

public class ItemController {
	
	private InGameController inGameController;
	private Item item;
	private ItemView itemView;
	
	public ItemController(InGameController inGameController, int candyNumber) {
		this.inGameController = inGameController;
		this.item = new Item(this.inGameController.getBlockMapController().getItemMap().getBlockList().get(candyNumber).getPosX(), 
								this.inGameController.getBlockMapController().getItemMap().getBlockList().get(candyNumber).getPosY(), 
								candyNumber); //x, y, candyNumber
		this.itemView = new ItemView(this.item, candyNumber); 
	}
	
	public Item getItem(){
		return item;
	}
	
	public ItemView getItemView(){
		return itemView;
	}
	
	public void uppdateItemShape(){
		this.itemView.getShape().setX(this.item.getX());
		this.itemView.getShape().setY(this.item.getY());
	}

}

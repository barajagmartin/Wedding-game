package controller;

import view.ItemView;
import model.Item;

public class ItemController {
	
	private InGameController inGameController;
	private Item item;
	private ItemView itemView;
	
	public ItemController(InGameController inGameController, int i) {
		this.item = new Item(0, 0, i);
		this.itemView = new ItemView(item, i); 
		
	}

}

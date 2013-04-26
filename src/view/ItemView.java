package view;

import model.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class ItemView {
	
	private Item item;
	private Shape slickShape;
	private Color color;
	
	public ItemView(Item item, int i) {
		this.item = item;
		this.slickShape = new Rectangle(item.getX(), item.getY(), item.WIDTH, item.HEIGHT);
		
		//switch that determines which colour to set
	}

}

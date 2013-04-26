package view;

import model.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class ItemView {
	
	private Item item;
	private Shape slickShape;
	private Color color;
	
	public ItemView(Item item, int candyNumber) {
		this.item = item;
		this.slickShape = new Rectangle(item.getX(), item.getY(), item.WIDTH, item.HEIGHT);
		
		/*Set a color of a candy monster depending on its ID*/
		switch(candyNumber){
			case 1: candyNumber = 1;
					color = Color.orange;
					break;
			case 2: candyNumber = 2;
					color = Color.magenta;
					break;
			case 3: candyNumber = 3;
					color = Color.yellow;
					break;
		}
	}
	
	public Color getColor(){
		return color;
	}
	
	public Item getItem(){
		return item;
	}
	
	public Shape getSlickShape(){
		return slickShape;
	}

}

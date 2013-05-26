package view;

import model.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class ItemView {
	
	private Item item;
	private Shape shape;
	private Image image;
	
	public ItemView(Item item) throws SlickException {
		this.item = item;
		this.shape = new Rectangle(item.getPos().getX(), item.getPos().getY(), Item.WIDTH, Item.HEIGHT);
		this.image = new Image("pics/item" + String.valueOf(item.CANDY_NUMBER) +".png");
	}
	
	public Item getItem(){
		return item;
	}
	
	public Shape getShape(){
		return shape;
	}

	public Image getImage() {
		return image;
	}
}
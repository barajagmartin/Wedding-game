package view;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import model.Item;

public class ItemView {
	final private Item item;
	final private Shape shape;
	final private Image image;
	
	public ItemView(final Item item) throws SlickException {
		this.item = item;
		this.shape = new Rectangle(item.getPos().getX(), item.getPos().getY(), Item.WIDTH, Item.HEIGHT);
		this.image = new Image("pics/item" + (item.CANDY_NUMBER) +".png");
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
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
	private Color color;
	private Image image;
	
	public ItemView(Item item, int candyNumber) throws SlickException {
		this.item = item;
		this.shape = new Rectangle(item.getX(), item.getY(), item.WIDTH, item.HEIGHT);
		this.image = new Image("pics/item" + String.valueOf(candyNumber) +".png");
		/*Set a color of a candy monster depending on its ID*/
		switch(candyNumber){
			case 0: color = Color.cyan;
					break;
			case 1: color = Color.magenta;
					break;
			case 2: color = Color.pink;
					break;
		}
	}
	
	public Color getColor(){
		return color;
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
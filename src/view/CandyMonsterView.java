package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import model.CandyMonster;
import model.Item;

public class CandyMonsterView {
	private CandyMonster candyMonster;
	private Shape shape;
	private Color color;
	
	public CandyMonsterView(CandyMonster candyMonster, int candyNumber) {
		this.candyMonster = candyMonster;
		this.shape = new Rectangle(candyMonster.getX(), candyMonster.getY(), candyMonster.WIDTH, candyMonster.HEIGHT);
		
		/*Set the color of a candy monster depending on its ID*/
		switch(candyNumber){
			case 0: color = Color.cyan;
					break;
			case 1: color = Color.magenta;
					break;
			case 2: color = Color.pink;
					break;
		}
	}
	
	public CandyMonster getCandyMonster() {
		return this.candyMonster;
	}
	
	public Shape getShape() {
		return this.shape;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}

	
}

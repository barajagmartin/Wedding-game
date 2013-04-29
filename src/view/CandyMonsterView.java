package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import model.CandyMonster;

public class CandyMonsterView {
	private CandyMonster candyMonster;
	private Shape slickShape;
	private Color color;
	
	public CandyMonsterView(CandyMonster candyMonster, int candyNumber) {
		this.candyMonster = candyMonster;
		this.slickShape = new Rectangle(candyMonster.getX(), candyMonster.getY(), candyMonster.WIDTH, candyMonster.HEIGHT);
		
		/*Set the color of a candy monster depending on its ID*/
		switch(candyNumber){
			case 0: color = Color.orange;
					break;
			case 1: color = Color.magenta;
					break;
			case 2: color = Color.yellow;
					break;
		}
	}
	
	public CandyMonster getCandyMonster() {
		return this.candyMonster;
	}
	
	public Shape slickShape() {
		return this.slickShape;
	}
	
	public Color getColor() {
		return this.color;
	}
	
}

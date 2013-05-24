package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import model.CandyMonster;
import model.Item;

public class CandyMonsterView {
	private CandyMonster candyMonster;
	private Shape shape;
	private Color color;
	private Image happyImage;
	private Image sadImage;
	
	public CandyMonsterView(CandyMonster candyMonster) throws SlickException {
		this.candyMonster = candyMonster;
		this.shape = new Rectangle(candyMonster.getX(), candyMonster.getY(), CandyMonster.WIDTH, CandyMonster.HEIGHT);
		happyImage = new Image("pics/happyCandyMonster" + String.valueOf(candyMonster.CANDY_NUMBER) + ".png");
		sadImage = new Image("pics/sadCandyMonster" + String.valueOf(candyMonster.CANDY_NUMBER) + ".png");

		/*Set the color of a candy monster depending on its ID*/
		switch(candyMonster.CANDY_NUMBER){
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

	public Image getImage() {
		if (candyMonster.isHappy()) {
			return happyImage;
		} else {
			return sadImage;	
		}
	}	
}

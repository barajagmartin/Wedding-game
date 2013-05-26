package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import model.CandyMonster;

public class CandyMonsterView {
	private CandyMonster candyMonster;
	private Shape shape;
	private Color color;
	private Image happyImage;
	private Image sadImage;
	
	public CandyMonsterView(CandyMonster candyMonster) throws SlickException {
		this.candyMonster = candyMonster;
		this.shape = new Rectangle(candyMonster.getPos().getX(), candyMonster.getPos().getY(), CandyMonster.WIDTH, CandyMonster.HEIGHT);
		happyImage = new Image("pics/happyCandyMonster" + String.valueOf(candyMonster.CANDY_NUMBER) + ".png");
		sadImage = new Image("pics/sadCandyMonster" + String.valueOf(candyMonster.CANDY_NUMBER) + ".png");
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
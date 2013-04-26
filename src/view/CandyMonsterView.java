package view;

import java.awt.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import model.CandyMonster;

public class CandyMonsterView {
	private CandyMonster candyMonster;
	private Shape slickShape;
	private Color color;
	
	public CandyMonsterView(CandyMonster candyMonster) {
		this.candyMonster = candyMonster;
		this.slickShape = new Rectangle(candyMonster.getX(), candyMonster.getY(), candyMonster.WIDTH, candyMonster.HEIGHT);
		
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
	
	public void setColor(Color color) {
		this.color = color;
	}
}

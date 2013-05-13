package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import utils.WorldBodyFactory;
import utils.WorldObjects;
import model.Character;

public class CharacterView {
	private Character character;
	private Shape slickShape;
	private Color color;
	private Body characterBody;
	private Image image;
	
	public CharacterView(Character character, WorldView worldView) throws SlickException {
		this.character = character;
		this.slickShape = new Circle(this.character.getX()-(Character.RADIUS/2f), 
				this.character.getY()-(Character.RADIUS/2f), Character.RADIUS);
		this.color = Color.blue;
		characterBody = WorldBodyFactory.createBody(WorldObjects.CHARACTER, worldView.getjBox2DWorld(), character.getPos());
		image = new Image("pics/GulNelson.png");
	}
	
	public Character getCharacter() {
		return this.character;
	}
	
	public Shape getSlickShape() {
		return this.slickShape;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Body getCharacterBody() {
		return characterBody;
	}
	
	public Image getImage() {
		return image;
	}
}
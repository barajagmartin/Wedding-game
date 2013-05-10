package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;

import utils.WorldBodyFactory;
import utils.WorldObjects;
import model.Character;

public class CharacterView {
	private Character character;
	private org.newdawn.slick.geom.Shape slickShape;
	private Color color;
	private Body characterBody;
	
	public CharacterView(Character character, WorldView worldView) {
		this.character = character;
		this.slickShape = new Circle(this.character.getX()-(Character.RADIUS/2f), 
				this.character.getY()-(Character.RADIUS/2f), Character.RADIUS);
		this.color = Color.blue;
		characterBody = WorldBodyFactory.createBody(WorldObjects.CHARACTER, worldView.getjBox2DWorld(), character.getPos());
	}
	
	public org.newdawn.slick.geom.Shape getSlickShape() {
		return this.slickShape;
	}
	
	public Body getCharacterBody() {
		return characterBody;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public Character getCharacter() {
		return this.character;
	}
}
package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Animation;
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
	private Animation nelson, walkingLeft, walkingRight, blink;
	
	public CharacterView(Character character) throws SlickException {
		this.character = character;
		this.slickShape = new Circle(this.character.getX()-(Character.RADIUS/2f), 
		this.character.getY()-(Character.RADIUS/2f), Character.RADIUS);
		this.color = Color.blue;
		
		Image image = new Image("pics/GulNelson.png");
		Image[] walkLeft = {image, image};
		Image[] walkRight = {image.getFlippedCopy(true, false), image.getFlippedCopy(true, false)};
		Image[] blinking = {new Image("pics/invisibleNelson.png"), new Image("pics/GulNelson.png")};
		int duration = 100;		
		walkingRight = new Animation(walkRight, duration);
		walkingLeft = new Animation(walkLeft, duration);
		blink = new Animation(blinking, duration);
		nelson = walkingRight;
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

	public void setCharacterBody(Body characterBody) {
		this.characterBody = characterBody;
	}

	public Animation getAnimation() {
		return nelson;
	}
	
	public void animateBlinking() {
		this.nelson = blink;
	}
	
	public void animateWalkingRight() {
		this.nelson = walkingRight;
	}
	
	public void animateWalkingLeft() {
		this.nelson = walkingLeft;
	}	
}
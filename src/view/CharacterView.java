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
	private Body characterBody;
	private Animation nelson, walkLeft, walkRight, blinkLeft, blinkRight;
	
	public CharacterView(Character character) throws SlickException {
		this.character = character;
		this.slickShape = new Circle(this.character.getX()-(Character.RADIUS/2f), 
		this.character.getY()-(Character.RADIUS/2f), Character.RADIUS);
		
		Image imageLeft = new Image("pics/GulNelson.png");
		Image imageRight = imageLeft.getFlippedCopy(true, false);
		Image[] walkingLeft = {imageLeft, imageLeft};
		Image[] walkingRight = {imageRight, imageRight};
		Image[] blinkingLeft = {new Image("pics/invisibleNelson.png"), imageLeft};
		Image[] blinkingRight = {new Image("pics/invisibleNelson.png"), imageRight};
		int duration = 100;		
		walkRight = new Animation(walkingRight, duration);
		walkLeft = new Animation(walkingLeft, duration);
		blinkLeft = new Animation(blinkingLeft, duration);
		blinkRight = new Animation(blinkingRight, duration);
		nelson = walkRight;
	}

	public Character getCharacter() {
		return this.character;
	}
	
	public Shape getSlickShape() {
		return this.slickShape;
	}
	
	public Body getCharacterBody() {
		return characterBody;
	}

	public void setCharacterBody(Body characterBody) {
		this.characterBody = characterBody;
	}

	public Animation getAnimation() {
		return this.nelson;
	}
	
	public void setAnimation(Animation animation) {
		this.nelson = animation;
	}

	public boolean isBlinking() {
		return this.nelson == blinkLeft || nelson == blinkRight;
	}

	public void animateBlinkingLeft() {
		this.nelson = blinkLeft;
	}
	
	public void animateBlinkingRight() {
		this.nelson = blinkRight;
	}
	
	public void animateWalkingRight() {
		this.nelson = walkRight;
	}
	
	public void animateWalkingLeft() {
		this.nelson = walkLeft;
	}

	public boolean isWalkingLeft() {
		return this.nelson == walkLeft;
	}

	public boolean isBlinkingLeft() {
		return this.nelson == blinkLeft;
	}	
}
package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import model.Character;

public class CharacterView {
	private Character character;
	private Shape slickShape;
	private Body characterBody;
	private Animation nelson, walkRight, walkLeft, blinkLeft, blinkRight, standRight, standLeft;
	
	public CharacterView(Character character) throws SlickException {
		this.character = character;
		this.slickShape = new Circle(this.character.getPos().getX()-(Character.RADIUS/2f), 
			this.character.getPos().getY()-(Character.RADIUS/2f), Character.RADIUS);
		
		//load images
		Image imageRight1 = new Image("pics/nelson1.png");
		Image imageRight2 = new Image("pics/nelson2.png");
		Image invisibleNelson = new Image("pics/invisibleNelson.png");
		Image imageLeft1 = imageRight1.getFlippedCopy(true, false);
		Image imageLeft2 = imageRight2.getFlippedCopy(true, false);
		//create image arrays to be used in animations
		Image[] walkingRight = {imageRight1, imageRight2};
		Image[] walkingLeft = {imageLeft1, imageLeft2};
		Image[] blinkingRight = {invisibleNelson, imageRight1, imageRight2};
		Image[] blinkingLeft = {invisibleNelson, imageLeft1, imageLeft2};
		Image[] standingRight = {imageRight1, imageRight1};
		Image[] standingLeft = {imageLeft1, imageLeft1};
		
		int duration = 300;	//change animation image every 300 ms	
		walkRight = new Animation(walkingRight, duration);
		walkLeft = new Animation(walkingLeft, duration);
		blinkLeft = new Animation(blinkingLeft, duration);
		blinkRight = new Animation(blinkingRight, duration);
		standRight = new Animation(standingRight, duration);
		standLeft = new Animation(standingLeft, duration);
		nelson = walkLeft; //set starting animation to walking left
	}

	public Character getCharacter() {
		return this.character;
	}
	
	public Shape getSlickShape() {
		return this.slickShape;
	}
	
	public Body getCharacterBody() {
		return this.characterBody;
	}

	public void setCharacterBody(Body characterBody) {
		this.characterBody = characterBody;
	}

	public Animation getAnimation() {
		return this.nelson;
	}

	public boolean isBlinking() {
		return this.nelson == this.blinkLeft || this.nelson == this.blinkRight;
	}

	public void animateBlinkingLeft() {
		this.nelson = this.blinkLeft;
	}
	
	public void animateBlinkingRight() {
		this.nelson = this.blinkRight;
	}
	
	public void animateWalkingRight() {
		this.nelson = this.walkRight;
	}
	
	public void animateWalkingLeft() {
		this.nelson = this.walkLeft;
	}

	public boolean isWalkingLeft() {
		return this.nelson == this.walkLeft;
	}
	
	public boolean isBlinkingLeft() {
		return this.nelson == this.blinkLeft;
	}

	public void animateStandingRight() {
		this.nelson = this.standRight;
	}
	
	public void animateStandingLeft() {
		this.nelson = this.standLeft;
	}

	public boolean isStandingLeft() {
		return this.nelson == this.standLeft;
	}
}
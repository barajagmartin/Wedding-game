package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import model.Character;

public class CharacterView {
	private final Character character;
	private final Shape slickShape;
	private Body characterBody;
	private Animation animation;
	private final Animation walkRight;
	private final Animation walkLeft;
	private final Animation blinkLeft;
	private final Animation blinkRight;
	private final Animation standRight;
	private final Animation standLeft;
	
	public CharacterView(final Character character) throws SlickException {
		this.character = character;
		this.slickShape = new Circle(this.character.getPos().getX()-(Character.RADIUS/2f), 
			this.character.getPos().getY()-(Character.RADIUS/2f), Character.RADIUS);
		
		//load images
		final Image imageRight1 = new Image("pics/nelson1.png");
		final Image imageRight2 = new Image("pics/nelson2.png");
		final Image invisibleNelson = new Image("pics/invisibleNelson.png");
		final Image imageLeft1 = imageRight1.getFlippedCopy(true, false);
		final Image imageLeft2 = imageRight2.getFlippedCopy(true, false);
		//create image arrays to be used in animations
		final Image[] walkingRight = {imageRight1, imageRight2};
		final Image[] walkingLeft = {imageLeft1, imageLeft2};
		final Image[] blinkingRight = {invisibleNelson, imageRight1, imageRight2};
		final Image[] blinkingLeft = {invisibleNelson, imageLeft1, imageLeft2};
		final Image[] standingRight = {imageRight1, imageRight1};
		final Image[] standingLeft = {imageLeft1, imageLeft1};
		
		final int duration = 300;	//change animation image every 300 ms	
		walkRight = new Animation(walkingRight, duration);
		walkLeft = new Animation(walkingLeft, duration);
		blinkLeft = new Animation(blinkingLeft, duration);
		blinkRight = new Animation(blinkingRight, duration);
		standRight = new Animation(standingRight, duration);
		standLeft = new Animation(standingLeft, duration);
		animation = walkLeft; //set starting animation to walking left
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

	public void setCharacterBody(final Body characterBody) {
		this.characterBody = characterBody;
	}

	public Animation getAnimation() {
		return this.animation;
	}

	public boolean isBlinking() {
		return this.animation == this.blinkLeft || this.animation == this.blinkRight;
	}

	public void animateBlinkingLeft() {
		this.animation = this.blinkLeft;
	}
	
	public void animateBlinkingRight() {
		this.animation = this.blinkRight;
	}
	
	public void animateWalkingRight() {
		this.animation = this.walkRight;
	}
	
	public void animateWalkingLeft() {
		this.animation = this.walkLeft;
	}

	public boolean isWalkingLeft() {
		return this.animation == this.walkLeft;
	}
	
	public boolean isBlinkingLeft() {
		return this.animation == this.blinkLeft;
	}

	public void animateStandingRight() {
		this.animation = this.standRight;
	}
	
	public void animateStandingLeft() {
		this.animation = this.standLeft;
	}

	public boolean isStandingLeft() {
		return this.animation == this.standLeft;
	}
}
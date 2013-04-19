package view;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import model.Character;

public class CharacterView {
	private Character character;
	private Shape slickShape;
	private PolygonShape jBox2DRectangle;
	private BodyDef bodyDef;
	private FixtureDef fixtureDef;
	private Color color;
	
	public CharacterView(Character character) {
		this.character = character;
		this.slickShape= new Rectangle(character.getX(), character.getY(), character.width, character.height); //x, y, width, heigh
		this.color = Color.blue;
		
		jBox2DRectangle = new PolygonShape(); 
		jBox2DRectangle.setAsBox(character.width, character.height);
		
		//ska inställningarna vara i controllern? vi tror det! :)
		bodyDef = new BodyDef();
		bodyDef.position.set(character.getX(),character.getY());
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.fixedRotation = true;
		
		fixtureDef = new FixtureDef();
		fixtureDef.shape = this.jBox2DRectangle;
		fixtureDef.density = 0.5f; //gör till konstanter TODO
		fixtureDef.friction = 0.3f;       
		fixtureDef.restitution = 0.5f;
	}
	
	public org.newdawn.slick.geom.Shape getSlickShape(){
		return this.slickShape;
	}
	
	public org.jbox2d.collision.shapes.PolygonShape getjBox2DRectangle() {
		return this.jBox2DRectangle;
	}
	
	public BodyDef getBodyDef() {
		return this.bodyDef;
	}

	public FixtureDef getFixtureDef() {
		return this.fixtureDef;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}

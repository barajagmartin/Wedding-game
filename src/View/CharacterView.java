package view;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import controller.WorldUtils;

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
		this.slickShape= new Rectangle(character.getX()+100, character.getY(), character.WIDTH, character.HEIGHT); //x, y, width, height
		this.color = Color.blue;
		
		jBox2DRectangle = new PolygonShape(); 
		jBox2DRectangle.setAsBox(character.WIDTH/50, character.HEIGHT/50);
		
		//ska inställningarna vara i controllern? vi tror det! :)
		bodyDef = new BodyDef();
		bodyDef.position.set(WorldUtils.pixel2Meter((int)(character.getX())),WorldUtils.pixel2Meter(character.getY()));
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.fixedRotation = true;
		
		fixtureDef = new FixtureDef();
		fixtureDef.shape = this.jBox2DRectangle;
		fixtureDef.density = 1f; //gör till konstanter TODO
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0f;
		
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

	public Character getCharacter() {
		return this.character;
	}
}

package view;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

public class CharacterView {
	private Character character;
	private org.newdawn.slick.geom.Shape slickShape;
	private org.jbox2d.collision.shapes.PolygonShape jBox2DRectangle;
	private BodyDef bodyDef;
	private FixtureDef fixtureDef;
	private Color color;
	
	public CharacterView(Character character) {
		this.character = character;
		this.slickShape= new Rectangle(character.getX(), character.getY(), 50, 60); //x, y, width, heigh
		this.color = Color.blue;
		bodyDef = new BodyDef();
		bodyDef.position.set(this.x,this.y);
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.fixedRotation = true;
		this.jBox2DRectangle = new PolygonShape(); 
		this.jBox2DRectangle.setAsBox(50, 60); 
		fixtureDef = new FixtureDef();
		fixtureDef.shape = this.jBox2DRectangle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.3f;       
		fixtureDef.restitution = 0.5f;
	}
	
	public void setSlickShapeX(float x) {
		slickShape.setX(x);
	}
	
	public void setSlickShapeY(float y) {
		slickShape.setY(y);
	}
	
	public org.newdawn.slick.geom.Shape getSlickShape(){
		return this.slickShape;
	}
	
	public org.jbox2d.collision.shapes.PolygonShape getjBox2DRectangle() {
		return jBox2DRectangle;
	}
	
	public BodyDef getBodyDef() {
		return bodyDef;
	}

	public FixtureDef getFixtureDef() {
		return fixtureDef;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
}

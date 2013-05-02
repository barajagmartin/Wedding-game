package view;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.joints.WeldJointDef;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


import utils.WorldUtils;

import model.Character;

public class CharacterView {
	private Character character;
	private WorldView worldView;
	private Shape slickShape;
	private CircleShape jBox2DCircle;
	private BodyDef bodyDef;
	private FixtureDef fixtureDef;
	private Color color;
	private CircleShape feetShape;
	private BodyDef antiFrictionBodyDef;
	private FixtureDef antiFrictionFixtureDef;
	private Body characterBody;
	private Body antiFrictionBody;
	private WeldJointDef weldJointDef;

	
	public CharacterView(Character character, WorldView worldView) {
		this.character = character;
		this.worldView = worldView;
		//this.slickShape= new Rectangle(character.getX() - character.WIDTH/2, character.getY() - character.HEIGHT/2,
			//	character.WIDTH, character.HEIGHT); //start position of character on the screen
		this.slickShape = new Circle(this.character.getX()-(Character.RADIUS/2), 
				this.character.getY()-(Character.RADIUS/2), Character.RADIUS);
		this.color = Color.blue;
		
		jBox2DCircle = new CircleShape();
		jBox2DCircle.m_radius = WorldUtils.pixel2Meter(Character.RADIUS);
		//jBox2DRectangle.setAsBox(WorldUtils.pixel2Meter(character.WIDTH)/2, WorldUtils.pixel2Meter(character.HEIGHT)/2);
		
		//ska inställningarna vara i controllern? vi tror det! :)
		bodyDef = new BodyDef();
		bodyDef.position.set(WorldUtils.pixel2Meter(character.getX()),WorldUtils.pixel2Meter(character.getY()));
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.fixedRotation = true;
		
		fixtureDef = new FixtureDef();
		fixtureDef.shape = this.jBox2DCircle;
		fixtureDef.density = 1f; //gör till konstanter TODO
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0f;
		
		feetShape = new CircleShape();
		feetShape.m_radius = WorldUtils.pixel2Meter(Character.RADIUS+20);
		
		antiFrictionBodyDef = new BodyDef();
		antiFrictionBodyDef.position.set(WorldUtils.pixel2Meter(character.getX()), WorldUtils.pixel2Meter(character.getY()-1));
		antiFrictionBodyDef.type = BodyType.DYNAMIC;
		
		antiFrictionFixtureDef = new FixtureDef();
		antiFrictionFixtureDef.shape = feetShape;
		antiFrictionFixtureDef.density = 0.1f;
		antiFrictionFixtureDef.friction = 0f;
		antiFrictionFixtureDef.restitution = 0f;
		
		characterBody = worldView.getjBox2DWorld().createBody(bodyDef);
		characterBody.createFixture(fixtureDef);
		characterBody.m_mass = 35f;
		antiFrictionBody = worldView.getjBox2DWorld().createBody(antiFrictionBodyDef);
		antiFrictionBody.createFixture(antiFrictionFixtureDef);
		antiFrictionBody.m_mass = 0.00000001f;
		antiFrictionBody.setAwake(false);
		weldJointDef = new WeldJointDef();
		
		weldJointDef.collideConnected = false;
		weldJointDef.localAnchorA.set(0,10);
		weldJointDef.localAnchorB.set(0,-10);
		weldJointDef.initialize(characterBody, antiFrictionBody, characterBody.getPosition());
		
		worldView.getjBox2DWorld().createJoint(weldJointDef);
		
		
	}
	
	public org.newdawn.slick.geom.Shape getSlickShape() {
		return this.slickShape;
	}
	
	public Body getCharacterBody() {
		return characterBody;
	}

	public org.jbox2d.collision.shapes.CircleShape getjBox2DCircle() {
		return this.jBox2DCircle;
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

	public WorldView getWorldView() {
		return worldView;
	}

	public BodyDef getFeetBodyDef() {
		return antiFrictionBodyDef;
	}

	public FixtureDef getFeetFixtureDef() {
		return antiFrictionFixtureDef;
	}
}

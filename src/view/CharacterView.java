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
	private CircleShape antiFrictionShape;
	private BodyDef leftAntiFrictionBodyDef;
	private BodyDef rightAntiFrictionBodyDef;
	private FixtureDef antiFrictionFixtureDef;
	private Body characterBody;
	private Body leftAntiFrictionBody;
	private Body rightAntiFrictionBody;
	private WeldJointDef leftWeldJointDef;
	private WeldJointDef rightWeldJointDef;

	
	public CharacterView(Character character, WorldView worldView) {
		this.character = character;
		this.worldView = worldView;
		//this.slickShape= new Rectangle(character.getX() - character.WIDTH/2, character.getY() - character.HEIGHT/2,
			//	character.WIDTH, character.HEIGHT); //start position of character on the screen
		this.slickShape = new Circle((float)(this.character.getX()-(Character.RADIUS/2f)), 
				(float)(this.character.getY()-(Character.RADIUS/2f)), Character.RADIUS);
		this.color = Color.blue;
		
		jBox2DCircle = new CircleShape();
		jBox2DCircle.m_radius = WorldUtils.pixel2Meter(Character.RADIUS);
		
		//ska inställningarna vara i controllern? vi tror det! :)
		bodyDef = new BodyDef();
		bodyDef.position.set(WorldUtils.pixel2Meter(character.getX()),WorldUtils.pixel2Meter(character.getY()));
		bodyDef.type = BodyType.DYNAMIC;
		bodyDef.fixedRotation = true;
		
		fixtureDef = new FixtureDef();
		fixtureDef.shape = this.jBox2DCircle;
		fixtureDef.density = 1f; //gör till konstanter TODO
		fixtureDef.friction = 0.8f;
		fixtureDef.restitution = 0f;
		
		characterBody = worldView.getjBox2DWorld().createBody(bodyDef);
		characterBody.createFixture(fixtureDef);
		characterBody.m_mass = 35f;
		
		antiFrictionShape = new CircleShape();
		antiFrictionShape.m_radius = WorldUtils.pixel2Meter(Character.RADIUS);
		
		leftAntiFrictionBodyDef = new BodyDef();
		leftAntiFrictionBodyDef.position.set(WorldUtils.pixel2Meter(character.getX()-1), WorldUtils.pixel2Meter(character.getY()-1));
		leftAntiFrictionBodyDef.type = BodyType.DYNAMIC;
		
		rightAntiFrictionBodyDef = new BodyDef();
		rightAntiFrictionBodyDef.position.set(WorldUtils.pixel2Meter(character.getX()+1), WorldUtils.pixel2Meter(character.getY()-1));
		rightAntiFrictionBodyDef.type = BodyType.DYNAMIC;
		
		antiFrictionFixtureDef = new FixtureDef();
		antiFrictionFixtureDef.shape = antiFrictionShape;
		antiFrictionFixtureDef.density = 1f;
		antiFrictionFixtureDef.friction = 0.1f;
		antiFrictionFixtureDef.restitution = 0f;
		
		leftAntiFrictionBody = worldView.getjBox2DWorld().createBody(leftAntiFrictionBodyDef);
		leftAntiFrictionBody.createFixture(antiFrictionFixtureDef);
		leftAntiFrictionBody.m_mass = 1f;
		leftAntiFrictionBody.setAwake(false);
		
		leftWeldJointDef = new WeldJointDef();
		leftWeldJointDef.collideConnected = false;
		leftWeldJointDef.localAnchorA.set(0,0);
		leftWeldJointDef.localAnchorB.set(0,0);
		leftWeldJointDef.initialize(leftAntiFrictionBody, characterBody, characterBody.getWorldCenter());
		worldView.getjBox2DWorld().createJoint(leftWeldJointDef);
		
		rightAntiFrictionBody = worldView.getjBox2DWorld().createBody(rightAntiFrictionBodyDef);
		rightAntiFrictionBody.createFixture(antiFrictionFixtureDef);
		rightAntiFrictionBody.m_mass = 1f;
		rightAntiFrictionBody.setAwake(false);
		
		rightWeldJointDef = new WeldJointDef();
		rightWeldJointDef.collideConnected = false;
		rightWeldJointDef.localAnchorA.set(0, 0);
		rightWeldJointDef.localAnchorB.set(0, 0);
		rightWeldJointDef.initialize(rightAntiFrictionBody, characterBody, characterBody.getWorldCenter());
		worldView.getjBox2DWorld().createJoint(rightWeldJointDef);
	}
	
	public org.newdawn.slick.geom.Shape getSlickShape() {
		return this.slickShape;
	}
	
	public Body getCharacterBody() {
		return characterBody;
	}

	public Body getAntiFrictionBody() {
		return leftAntiFrictionBody;
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
}

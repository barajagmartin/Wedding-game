package utils;

import model.Character;
import model.Position;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.WeldJointDef;


public class WorldBodyFactory {
	public static Body createBody(WorldObjects worldObject, World jBox2DWorld, Position pos) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(WorldUtils.pixel2Meter(pos.getX()),WorldUtils.pixel2Meter(pos.getY()));
		FixtureDef fixtureDef = new FixtureDef();
		Shape shape;
		Body body = null; //TODO is it needed to check if it is null at the end?

		if (worldObject.equals(WorldObjects.CHARACTER)) {
			shape = new CircleShape();
			shape.m_radius = WorldUtils.pixel2Meter(Character.RADIUS);

			fixtureDef.shape = shape;
			fixtureDef.density = 1f; //gör till konstanter TODO
			fixtureDef.friction = 0.8f;
			fixtureDef.restitution = 0f;
			fixtureDef.userData = "player";

			bodyDef.type = BodyType.DYNAMIC;
			bodyDef.fixedRotation = true;

			body = jBox2DWorld.createBody(bodyDef);
			body.createFixture(fixtureDef);
			body.m_mass = 35f;

			CircleShape antiFrictionShape = new CircleShape();
			antiFrictionShape.m_radius = WorldUtils.pixel2Meter(Character.RADIUS);

			BodyDef leftAntiFrictionBodyDef = new BodyDef();
			leftAntiFrictionBodyDef.position.set(WorldUtils.pixel2Meter(pos.getX()-1), WorldUtils.pixel2Meter(pos.getY()-1));
			leftAntiFrictionBodyDef.type = BodyType.DYNAMIC;

			BodyDef rightAntiFrictionBodyDef = new BodyDef();
			rightAntiFrictionBodyDef.position.set(WorldUtils.pixel2Meter(pos.getX()+1), WorldUtils.pixel2Meter(pos.getY()-1));
			rightAntiFrictionBodyDef.type = BodyType.DYNAMIC;

			FixtureDef antiFrictionFixtureDef = new FixtureDef();
			antiFrictionFixtureDef.shape = antiFrictionShape;
			antiFrictionFixtureDef.density = 1f;
			antiFrictionFixtureDef.friction = 0.1f;
			antiFrictionFixtureDef.restitution = 0f;

			Body leftAntiFrictionBody = jBox2DWorld.createBody(leftAntiFrictionBodyDef);
			leftAntiFrictionBody.createFixture(antiFrictionFixtureDef);
			leftAntiFrictionBody.m_mass = 1f;
			leftAntiFrictionBody.setAwake(false);

			WeldJointDef leftWeldJointDef = new WeldJointDef();
			leftWeldJointDef.collideConnected = false;
			leftWeldJointDef.localAnchorA.set(0,0);
			leftWeldJointDef.localAnchorB.set(0,0);
			leftWeldJointDef.initialize(leftAntiFrictionBody, body, body.getWorldCenter());
			jBox2DWorld.createJoint(leftWeldJointDef);

			Body rightAntiFrictionBody = jBox2DWorld.createBody(rightAntiFrictionBodyDef);
			rightAntiFrictionBody.createFixture(antiFrictionFixtureDef);
			rightAntiFrictionBody.m_mass = 1f;
			rightAntiFrictionBody.setAwake(false);

			WeldJointDef rightWeldJointDef = new WeldJointDef();
			rightWeldJointDef.collideConnected = false;
			rightWeldJointDef.localAnchorA.set(0, 0);
			rightWeldJointDef.localAnchorB.set(0, 0);
			rightWeldJointDef.initialize(rightAntiFrictionBody, body, body.getWorldCenter());
			jBox2DWorld.createJoint(rightWeldJointDef);
			
		} else if (worldObject.equals(WorldObjects.MOVEABLE_BOX)) {
			//create moveable box
		}
		return body;
	}
}
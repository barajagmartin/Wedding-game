package utils;

import model.Character;
import model.MoveableBox;
import model.Position;
import model.Spikes;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.WeldJointDef;

public class WorldBodyFactory {
	public static Body createBody(WorldObjects worldObject, World jBox2DWorld, Position pos) {
		Shape shape;
		FixtureDef fixtureDef = new FixtureDef();
		BodyDef bodyDef = new BodyDef();
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
			bodyDef.position.set(WorldUtils.pixel2Meter(pos.getX()),WorldUtils.pixel2Meter(pos.getY()));

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
			shape = new PolygonShape();
			((PolygonShape) shape).setAsBox(WorldUtils.pixel2Meter(MoveableBox.HALF_WIDTH), WorldUtils.pixel2Meter(MoveableBox.HALF_HEIGHT));
			
			fixtureDef.shape = shape;
			fixtureDef.density = 1f;
			fixtureDef.friction = 0.7f;
			fixtureDef.restitution = 0f;
			fixtureDef.userData = "moveableBox";
			
			bodyDef.type = BodyType.DYNAMIC;
			bodyDef.fixedRotation = true;
			bodyDef.position.set(WorldUtils.pixel2Meter(pos.getX()+MoveableBox.HALF_WIDTH-3), // -3 is for correcting starting position with pixel precision
					WorldUtils.pixel2Meter(pos.getY()+MoveableBox.HALF_HEIGHT));				 // to make it look good
			
			body = jBox2DWorld.createBody(bodyDef);
			body.createFixture(fixtureDef);
			body.m_mass = 2000f;
		} else if (worldObject.equals(WorldObjects.SPIKES_SENSOR)) {
			shape = new CircleShape();
			shape.m_radius = WorldUtils.pixel2Meter(Spikes.RADIUS);
			bodyDef = new BodyDef();
			bodyDef.position.set(WorldUtils.pixel2Meter(pos.getX()), WorldUtils.pixel2Meter(pos.getY())); //FIXME jbox sensor should be in the center
			bodyDef.type = BodyType.STATIC;
			bodyDef.fixedRotation = true;
			
			fixtureDef = new FixtureDef();
			fixtureDef.isSensor = true;
			fixtureDef.shape = shape;
			fixtureDef.userData = "spikes";
					
			body = jBox2DWorld.createBody(bodyDef);
			body.createFixture(fixtureDef);
		}
		return body;
	}
	
	public static void addSolidGround(final Vec2 pos, final Vec2 size, final float friction, final float restitution, World jBox2DWorld) {
		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(size.x, size.y);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = polygonShape;
		fixtureDef.friction = friction;
		fixtureDef.density = 1f;
		fixtureDef.restitution = restitution;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(pos);
		bodyDef.type = BodyType.STATIC;
		bodyDef.fixedRotation = true;
		
		Body body = jBox2DWorld.createBody(bodyDef);
		body.createFixture(fixtureDef);
	}
}
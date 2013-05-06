package view;

import model.Spikes;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import utils.WorldUtils;


public class SpikesView {
	private Image image;
	private Circle circle;
	private Spikes spikes;
	private Color color;
	private Shape shape;

	public SpikesView(Spikes spikes, WorldView worldView){
		this.spikes = spikes;
		this.color = color.gray;
		this.circle = new Circle(spikes.getX(), spikes.getY(), Spikes.RADIUS);
		this.shape = new CircleShape();
		this.shape.m_radius = WorldUtils.pixel2Meter(Spikes.RADIUS);
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(WorldUtils.pixel2Meter(spikes.getX()), WorldUtils.pixel2Meter(spikes.getY()));
		bodyDef.type = BodyType.STATIC;
		bodyDef.fixedRotation = true;
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.isSensor = true;
		
		Body spikesBody = worldView.getjBox2DWorld().createBody(bodyDef);
		spikesBody.createFixture(fixtureDef);
	}

	public Spikes getSpikes() {
		return spikes;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public Color getColor() {
		return color;
	}

	
	
	
}

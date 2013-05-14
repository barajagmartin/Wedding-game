package view;

import model.Spikes;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import utils.WorldBodyFactory;
import utils.WorldObjects;
import utils.WorldUtils;


public class SpikesView {
	private Image image;
	private Circle circle;
	private Spikes spikes;
	private Color color;
	private Body body;

	public SpikesView(Spikes spikes, WorldView worldView) throws SlickException {
		this.spikes = spikes;
		this.color = color.gray;
		this.circle = new Circle(spikes.getPos().getX(), spikes.getPos().getY(), Spikes.RADIUS);
		image = new Image("pics/spikes2.png");
		body = WorldBodyFactory.createBody(WorldObjects.SPIKES_SENSOR, worldView.getjBox2DWorld(), spikes.getPos());
	}

	public Spikes getSpikes() {
		return spikes;
	}
	
	public Circle getShape() {
		return circle;
	}
	
	public Color getColor() {
		return color;
	}

	public Image getImage() {
		return image;
	}
}

package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import model.Spikes;

public class SpikesView {
	final private Image image;
	final private Circle circle;
	final private Spikes spikes;
	final private Color color;
	private Body body;

	public SpikesView(final Spikes spikes) throws SlickException {
		this.spikes = spikes;
		this.color = Color.gray;
		this.circle = new Circle(spikes.getPos().getX(), spikes.getPos().getY(), Spikes.RADIUS);
		image = new Image("pics/spikes2.png");
	}

	public Body getBody() {
		return body;
	}

	public void setBody(final Body body) {
		this.body = body;
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
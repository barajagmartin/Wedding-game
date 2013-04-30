package view;

import model.Spikes;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class SpikesView {
	private Image image;
	private Shape shape;
	private Spikes spikes;
	private Color color;

	public SpikesView(Spikes spikes){
		this.spikes = spikes;
		this.color = color.gray;
		this.shape = new Circle(spikes.getX(), spikes.getY(), Spikes.RADIUS);
		
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

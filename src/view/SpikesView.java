package view;

import model.Spikes;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public class SpikesView {
	private Image image;
	private Shape shape;
	public Shape getShape() {
		return shape;
	}
	
	public SpikesView(Spikes spikes){
		this.spikes = spikes;
		
	}

	public Spikes getSpikes() {
		return spikes;
	}

	private Spikes spikes;
	
	
}

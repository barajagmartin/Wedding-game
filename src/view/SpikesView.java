package view;

import model.Spikes;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
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
		try {
			this.image = new Image("pics/spikes2.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public Image getImage() {
		return image;
	}	
	
}

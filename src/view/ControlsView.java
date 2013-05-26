package view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ControlsView {
	final private Image image;
	
	public ControlsView() throws SlickException {
		image = new Image("pics/controls_image3.jpg");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		image.draw();
	}
}
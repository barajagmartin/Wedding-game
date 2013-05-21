package view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ControlsView {

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Image image = new Image("pics/controls_image.png");
		image.draw();
	}
}

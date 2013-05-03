package view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import controller.GameController;

public class EndOfLevelView {
	
	public EndOfLevelView () {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		Image i = new Image("pics/rainbowattheend.jpg"); //Will be get from the Multimedia class later
		i.draw();
		
	}

}

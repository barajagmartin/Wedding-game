package view;

import model.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenuView {

	public StartMenuView () {
		
	}
	
	
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.setColor(Color.pink);
		g.drawString("PRESS ENTER TO START THE GAME", model.Game.WINDOW_WIDTH/2, Game.WINDOW_HEIGHT/2);
		
	}




}

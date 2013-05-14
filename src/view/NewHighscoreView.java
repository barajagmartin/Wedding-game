package view;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class NewHighscoreView {
	
	public NewHighscoreView(TextField textField) {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("New highscore!", Game.WINDOW_WIDTH/2, Game.WINDOW_HEIGHT/4);
	}
}

package view;

import java.awt.Font;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class NewHighscoreView {
	
	private TextField textField;
	
	public NewHighscoreView(TextField textField) {
		this.textField = textField;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {					
		g.drawString("New highscore!", Game.WINDOW_WIDTH/4, Game.WINDOW_HEIGHT/4);
		textField.setFocus(true);
		textField.render(gc, g);
		
	}

	public TextField getTextField() {
		return textField;
	}
}

package view;

import java.awt.Font;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class NewHighscoreView {
	
	private TextField textField;
	
	public NewHighscoreView() {
		
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {		
		TrueTypeFont font = new TrueTypeFont(new Font("Courier", Font.BOLD, 50), false);
		g.setFont(font);
		g.drawString("New highscore!", Game.WINDOW_WIDTH/4, Game.WINDOW_HEIGHT/4);
		this.textField = new TextField(gc, font, Game.WINDOW_WIDTH/4, Game.WINDOW_HEIGHT/2, 300, font.getHeight());
		this.textField.setMaxLength(8);
		textField.setText("Enter name");
		textField.render(gc, g);
	}

	public TextField getTextField() {
		return textField;
	}
}

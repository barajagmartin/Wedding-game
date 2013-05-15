package controller;

import java.awt.Font;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.NewHighscoreView;

public class NewHighscoreController extends BasicGameState implements ComponentListener {
	
	private NewHighscoreView newHighscoreView;
	private StateBasedGame sbg;
	private TrueTypeFont font;
	private TextField textField;
	
	public NewHighscoreController() {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {						
		this.sbg = sbg;
		this.font = new TrueTypeFont(new Font("Courier", Font.BOLD, 50), false);
		this.textField = new TextField(gc, font, Game.WINDOW_WIDTH/4, Game.WINDOW_HEIGHT/2, 300, 50);
		this.textField.setMaxLength(8);
		this.textField.setText("Enter");
		textField.addListener(this);
		this.newHighscoreView = new NewHighscoreView(textField);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.newHighscoreView.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
	}
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ENTER) {
			sbg.enterState(Game.HIGHSCORE);
		}
	}

	@Override
	public int getID() {
		return Game.NEW_HIGHSCORE;
	}

	@Override
	public void componentActivated(AbstractComponent textField) {
		textField.setFocus(false);
		sbg.enterState(Game.HIGHSCORE);
		
	}

}

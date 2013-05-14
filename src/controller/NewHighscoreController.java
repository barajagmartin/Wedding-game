package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.NewHighscoreView;

public class NewHighscoreController extends BasicGameState {
	
	private NewHighscoreView newHighscoreView;
	private TextField textField;
	
	public NewHighscoreController() {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {		
		this.textField = new TextField(gc, null, 500, 500, 300, 50);
		this.textField.setMaxLength(8);
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
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return Game.NEW_HIGHSCORE;
	}

}

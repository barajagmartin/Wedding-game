package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.NewHighscoreView;

public class NewHighscoreController extends BasicGameState {
	
	private NewHighscoreView newHighscoreView;
	private StateBasedGame sbg;
	
	public NewHighscoreController() {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {				
		this.newHighscoreView = new NewHighscoreView();
		this.sbg = sbg;
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
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ENTER) {
			sbg.enterState(Game.HIGHSCORE);
		}
	}

	@Override
	public int getID() {
		return Game.NEW_HIGHSCORE;
	}

}

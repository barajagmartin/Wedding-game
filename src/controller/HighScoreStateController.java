package controller;

import model.HighScore;
import model.StartMenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.HighScoreStateView;

public class HighScoreStateController extends BasicGameState{
	
	private final GameController gameController;
	private HighScoreStateView highScoreStateView;
	private GameContainer gc;
	private StateBasedGame sbg;
	
	public HighScoreStateController (GameController gameController) {
		super();
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.highScoreStateView = new HighScoreStateView();
		this.gc = gc;
		this.sbg=sbg;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.highScoreStateView.render(gc, sbg, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
	}
	
	@Override
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_TAB) {
			this.gameController.changeFullscreen(this.gc);
		}
		else if (key == Input.KEY_ENTER || key == Input.KEY_ESCAPE) {
			//back to start menu 
			sbg.enterState(StartMenu.STATE_ID);
		}
	}

	@Override
	public int getID() {
		return HighScore.STATE_ID;
	}

}

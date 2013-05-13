package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.HighScoreStateView;

public class HighScoreStateController extends BasicGameState{
	
	private GameController gameController;
	private HighScoreStateView highScoreStateView;
	private GameContainer gc;
	private StateBasedGame sbg;
	
	public HighScoreStateController (GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.highScoreStateView = new HighScoreStateView(this.gameController.getScoreList(), this.gameController.getNameList());
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
		// TODO Auto-generated method stub
		
	}
	
	public void keyPressed (int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			gc.exit();
		} else if (key == Input.KEY_ENTER) {
			//back to start menu or somethig
			sbg.enterState(Game.START_MENU);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Game.HIGHSCORE;
	}

}

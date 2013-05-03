package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.EndOfLevelView;

public class EndOfLevelController extends BasicGameState{
	private EndOfLevelView endOflevelView;
	private GameController gameController;
	
	public EndOfLevelController (GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		this.endOflevelView = new EndOfLevelView();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.endOflevelView.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return Game.END_OF_LEVEL;
	}

}

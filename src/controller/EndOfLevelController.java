package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.EndOfLevelView;

public class EndOfLevelController extends BasicGameState{
	private EndOfLevelView endOflevelView;
	private GameController gameController;
	private StateBasedGame sgb;
	private GameContainer gc;
	
	public EndOfLevelController (GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.endOflevelView = new EndOfLevelView();
		this.sgb = sgb;
		this.gc = gc;
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
	
	public void keyPressed (int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			gc.exit();
		} else if (key == Input.KEY_ENTER) {
			//enter a new level
		}
	}

	@Override
	public int getID() {
		return Game.END_OF_LEVEL;
	}

}

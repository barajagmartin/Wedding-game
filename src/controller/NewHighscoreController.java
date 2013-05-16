package controller;


import model.Game;

import view.NewHighscoreView;

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


public class NewHighscoreController extends BasicGameState implements ComponentListener {
	private GameController gameController;
	private NewHighscoreView newHighscoreView;
	private StateBasedGame sbg;
	
	public NewHighscoreController(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {						
		this.sbg = sbg;		
		this.newHighscoreView = new NewHighscoreView(gc);
		this.newHighscoreView.getTextField().addListener(this);
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

	@Override
	public int getID() {
		return Game.NEW_HIGHSCORE;
	}

	@Override
	public void componentActivated(AbstractComponent textField) {
		this.gameController.saveScore(this.gameController.getInGameController().getPlayerController().getPlayer().getScore(),
				this.newHighscoreView.getTextField().getText());
		textField.setFocus(false);
		sbg.enterState(Game.HIGHSCORE);
		
	}

}

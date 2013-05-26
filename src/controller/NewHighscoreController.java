package controller;


import model.HighScore;
import model.NewHighscore;

import utils.SaveUtils;
import view.NewHighscoreView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class NewHighscoreController extends BasicGameState implements ComponentListener {
	private final GameController gameController;
	private NewHighscoreView newHighscoreView;
	private StateBasedGame sbg;
	private GameContainer gc;
	
	public NewHighscoreController(final GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {						
		this.sbg = sbg;
		this.newHighscoreView = new NewHighscoreView(gc, this.gameController.getGame().getInGame().getPlayer().getScore());
	}
	
	public void enter(GameContainer container, StateBasedGame game)
			throws SlickException {
		super.enter(container, game);
		newHighscoreView.reset(this.gameController.getGame().getInGame().getPlayer().getScore());
		this.newHighscoreView.getTextField().addListener(this);
		newHighscoreView.getTextField().setFocus(true);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.newHighscoreView.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		this.gc = gc;
	}
	
	@Override
	public void keyPressed (int key, char c) {
		if (key == Input.KEY_TAB) {
			this.gameController.changeFullscreen(this.gc);

		}
	}

	@Override
	public int getID() {
		return NewHighscore.STATE_ID;
	}

	@Override
	public void componentActivated(AbstractComponent textField) {
		SaveUtils.saveScore(this.gameController.getGame().getInGame().getPlayer().getScore(),
				this.newHighscoreView.getTextField().getText());
		textField.setFocus(false);
		sbg.enterState(HighScore.STATE_ID);
		textField.removeListener(this);
	}

}

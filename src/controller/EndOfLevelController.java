package controller;

import model.*;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import utils.SaveUtils;
import view.EndOfLevelView;

public class EndOfLevelController extends BasicGameState{
	private EndOfLevelView endOflevelView;
	private GameController gameController;
	private StateBasedGame sbg;
	private GameContainer gc;
	private boolean gameOver;
	private boolean victory;
	private boolean newHighScore;
	
	public EndOfLevelController (GameController gameController) {
		this.gameController = gameController;
		this.gameOver = false;
		this.victory = false;
		this.newHighScore = false;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.sbg = sbg;
		this.gc = gc;
	}
	
	public void enter(GameContainer container, StateBasedGame game)
			throws SlickException {
		super.enter(container, game);
		
		//kolla om det finns fler banor?
		this.victory = this.gameController.getGame().getInGame().getNbrOfFiles(this.gameController.getGame().getInGame().getLevel() + 1) == 0;
		//kolla om spelaren förlorat
		this.gameOver = (this.gameController.getGame().getInGame().isGameOver());
		//kolla om newHighScore
		this.newHighScore = (this.gameController.getGame().getInGame().getPlayer().getScore() > SaveUtils.getScoreList()[9]);
			
		this.endOflevelView = new EndOfLevelView(this.gameController.getGame().getInGame().getPlayer().getScore(), gameOver, victory);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.endOflevelView.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
	}
	
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_TAB) {
			this.gameController.changeFullscreen(this.gc);
		}
		if (key == Input.KEY_ESCAPE) {
			sbg.enterState(StartMenu.STATE_ID);
		} else if (key == Input.KEY_ENTER) {
			 if (this.newHighScore && (this.gameOver || this.victory)) {
				sbg.enterState(NewHighscore.STATE_ID);
			} else if (this.gameOver || this.victory) {
				sbg.enterState(HighScore.STATE_ID);
			} else {
				sbg.enterState(InGame.STATE_ID);
			}
		}
	}

	@Override
	public int getID() {
		return EndOfLevel.STATE_ID;
	}

}

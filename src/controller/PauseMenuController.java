package controller;

import model.Controls;
import model.PauseMenu;
import model.StartMenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.PauseMenuView;

public class PauseMenuController extends BasicGameState{
	private StateBasedGame sbg;
	private GameController gameController;
	private PauseMenuView pauseView;
	private PauseMenu pauseMenu;
	private GameContainer gc;
	private static int previousState;
	
	public PauseMenuController(GameController gameController) {
		this.gameController = gameController;
		PauseMenuController.setPreviousState(-1);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.sbg = sbg;
		this.pauseMenu = new PauseMenu();
		this.pauseView = new PauseMenuView(this.pauseMenu, gameController.getGameView());
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg) {
		this.pauseMenu.resetIsMarked();
	}
	
	/*Render in view*/
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.pauseView.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		this.gc = gc;
	}
	
	@Override
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_TAB) {
			this.gameController.changeFullscreen(this.gc);
		}
		if(key == Input.KEY_ESCAPE) {
			//check if we have a valid previous state
			if(PauseMenuController.previousState >= 0){
				sbg.enterState(PauseMenuController.previousState);
			} else {
				System.out.println("ERROR: previousState has not been initialized");
			}
		}
		if(key == Input.KEY_DOWN) {
			pauseMenu.markButtonDown();
		}
		if(key == Input.KEY_UP) {
			pauseMenu.markButtonUp();
		}
		if(key == Input.KEY_ENTER) {
			switch(pauseMenu.isMarked()) {
				case 0:	sbg.enterState(PauseMenuController.previousState);
						break;
				case 1: if(gameController.getGame().isSoundOn()) {
							gameController.getGame().setSoundOn(false);
						} else {
							gameController.getGame().setSoundOn(true);
						}
						break;
				case 2: if(gameController.getGame().isMusicOn()) {
							gameController.getInGameMusic().pause();	
							gameController.getGame().setMusicOn(false);
						} else {
							gameController.getInGameMusic().play(1.0f, 0.3f); 
							gameController.getGame().setMusicOn(true);
						}	
						break;
				case 3: sbg.enterState(Controls.STATE_ID);
						break;
				case 4: gameController.getGame().getInGame().setPaused(false);
						gameController.getInGameMusic().stop(); //Stop current thread
						sbg.enterState(StartMenu.STATE_ID);
						break;
			}
		}
	}
	
	public PauseMenuView getPauseView(){
		return pauseView;
	}

	public static int getPreviousState() {
		return previousState;
	}

	public static void setPreviousState(int previousState) {
		PauseMenuController.previousState = previousState;
	}

	@Override
	public int getID() {
		return PauseMenu.STATE_ID;
	}
	

}

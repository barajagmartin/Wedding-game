package controller;

import model.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.PauseView;

public class PauseController extends BasicGameState{
	private StateBasedGame sbg;
	private GameController gameController;
	private PauseView pauseView;
	
	public PauseController(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.sbg = sbg;
		this.pauseView = new PauseView(gameController.getInGameController().getWorldController().getWorld().getWorldWidthPx(), 
									gameController.getInGameController().getWorldController().getWorld().getWorldHeightPx());
									//width, height
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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_ESCAPE) {
			sbg.enterState(Game.IN_GAME); //this way or getID? FIXME
		}
		if(key == Input.KEY_DOWN) {
			pauseView.markButtonDown();
		}
		if(key == Input.KEY_UP) {
			pauseView.markButtonUp();
		}
		if(key == Input.KEY_ENTER) {
			switch(pauseView.getIsMarked()){
				case 0: sbg.enterState(Game.IN_GAME); //this way or getID? FIXME
						break;
				case 1: //Sound: On/Off
						break;
				case 2: //Music: On/Off
						break;
				case 3: //Enter state "Controls"
						break;
				case 4: //Enter state "Start Menu" TODO
						break;
			}
		}
	}

	@Override
	public int getID() {
		return Game.PAUSE_MENU;
	}
	
	

}

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
	private static int previousState;
	
	public PauseController(GameController gameController) {
		this.gameController = gameController;
		PauseController.setPreviousState(-1);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.sbg = sbg;
		this.pauseView = new PauseView();
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
			//check if we have a valid previous state
			if(PauseController.previousState >= 0){
				sbg.enterState(PauseController.previousState); 
			} else {
				System.out.println("ERROR: previousState has not been initialized");  //FIXME
			}
		}
		if(key == Input.KEY_DOWN) {
			pauseView.markButtonDown();
		}
		if(key == Input.KEY_UP) {
			pauseView.markButtonUp();
		}
		if(key == Input.KEY_ENTER) {
			switch(pauseView.getIsMarked()){
				case 0: sbg.enterState(PauseController.previousState);
						break;
				case 1: //Sound: On/Off
						break;
				case 2: //Music: On/Off
						break;
				case 3: //Enter state "Controls"
						break;
				case 4: sbg.enterState(Game.START_MENU);
						break;
			}
		}
	}

	public static int getPreviousState() {
		return previousState;
	}

	public static void setPreviousState(int previousState) {
		PauseController.previousState = previousState;
	}
	
	@Override
	public int getID() {
		return Game.PAUSE_MENU;
	}
	

}

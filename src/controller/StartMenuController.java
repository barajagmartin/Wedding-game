package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.StartMenuView;

public class StartMenuController extends BasicGameState {
	private StartMenuView startMenuView;
	private StateBasedGame sbg;
	private GameController gameController;
	
	public StartMenuController(GameController gameController) {
		this.gameController = gameController;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.sbg = game;
		this.startMenuView = new StartMenuView(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		this.startMenuView.render(container, game, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_DOWN) {
			startMenuView.markButtonDown();
		}
		if(key == Input.KEY_UP) {
			startMenuView.markButtonUp();
		}
		if(key == Input.KEY_ENTER) {
			switch(startMenuView.getIsMarked()){
				case 0: sbg.enterState(Game.IN_GAME);
						break;
				case 1: //Sound: On/Off
						break;
				case 2: //Music: On/Off
						break;
				case 3: //Enter state "Controls"
						break;
				case 4: System.exit(0);
						break;
			}
		}
	}

	@Override
	public int getID() {
		return Game.START_MENU;
	}

}

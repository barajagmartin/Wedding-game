package controller;

import java.io.FileNotFoundException;

import model.Game;
import model.InGame;
import model.Player;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class GameController extends StateBasedGame {
	private Game game; //ta eventuellt bort FIXME
	private InGameController inGameController;
	private PauseController pauseController;
	private EndOfLevelController endOfLevelController;
	
	public GameController(String name) {
		super(name);
		this.game = new Game(); //So long this is unnecessary FIXME
		this.inGameController = new InGameController();
		this.pauseController = new PauseController(this);
		this.endOfLevelController = new EndOfLevelController(this);
		this.addState(inGameController);
		this.addState(pauseController);
		this.addState(endOfLevelController);
	}
	
	/** Initialise the list of states making up the game */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		//this.getState(inGameController.getID()).init(container, this); TODO, ska den här anropas alls?! den anropas ändå!
		this.enterState(inGameController.getID());
	}
	
	public InGameController getInGameController(){
		return inGameController;
	}
	
	public PauseController getPauseController(){
		return pauseController;
	}

}

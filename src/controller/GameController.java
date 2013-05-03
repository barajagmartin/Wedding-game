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
	
	public GameController(String name) {
		super(name);
		this.game = new Game(); //So long this is unnecessary FIXME
		this.inGameController = new InGameController();
		this.pauseController = new PauseController(this);
		this.addState(inGameController);
		this.addState(pauseController);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		//this.getState(inGameController.getID()).init(container, this); TODO, ska den här anropas alls?! den anropas ändå!
		this.enterState(inGameController.getID());
		this.enterState(pauseController.getID()); //Behöver hämta currentGameState
	}
	
	public InGameController getInGameController(){
		return inGameController;
	}
	
	public PauseController getPauseController(){
		return pauseController;
	}

}

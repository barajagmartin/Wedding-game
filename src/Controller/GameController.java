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
	public GameController(String name) throws FileNotFoundException, SlickException {
		super(name);
		this.game = new Game(); //So long this is unnecessary FIXME
		this.inGameController = new InGameController();
		this.addState(inGameController);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(inGameController.getID()).init(container, this);
		this.enterState(inGameController.getID());
	}

}

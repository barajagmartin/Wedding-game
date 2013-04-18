package controller;

import model.Game;
import model.InGame;
import model.Player;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class GameController extends StateBasedGame {
	private Game game;
	public GameController(Game game, String name) {
		super(name);
		this.game = game;
		this.addState(new InGame(game.IN_GAME, new Player()));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(game.IN_GAME).init(container, this);
		this.enterState(game.IN_GAME);
	}

}

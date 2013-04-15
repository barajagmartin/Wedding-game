package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class GameModel extends StateBasedGame {
	private static final int START_MENU = 0;
	private static final int IN_GAME = 1;
	private static final int HIGHSCORE = 2;
	
	public GameModel(String name) {
		super(name);
		this.addState(new InGameModel(IN_GAME));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(IN_GAME).init(container, this);
		this.enterState(IN_GAME);
	}

}

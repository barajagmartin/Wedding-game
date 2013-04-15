package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class InGameModel extends BasicGameState {
	private final int STATE_ID;
	private WorldModel world;
	//Ska vara en StatusBar med TODO
	
	public InGameModel(final int STATE_ID, PlayerModel player) {
		this.STATE_ID = STATE_ID;
		world = new WorldModel(player.getCharacter());
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int id)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return STATE_ID;
	}

}

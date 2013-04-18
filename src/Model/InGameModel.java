package Model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class InGameModel extends BasicGameState {
	private final int STATE_ID;
	private WorldModel world;
	private Controller.CharacterController characterController;
	private int velocityIterations = 6;
	private int positionIterations = 2;
	private PlayerModel player;
	private int statusBarHeight;
	
	//Ska vara en StatusBar med TODO
	
	public InGameModel(final int STATE_ID, PlayerModel player) {
		this.STATE_ID = STATE_ID;
		this.player=player;
		
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.statusBarHeight=gc.getHeight()/5;	
		
		world = new WorldModel(player.getCharacter(), gc.getWidth(), gc.getHeight()-statusBarHeight);
		characterController = new Controller.CharacterController(world.getCharacter());
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(this.player.getCharacter().getColor());
		g.fill(world.getCharacter().getShape());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		characterController.keyPressedUpdate(gc, delta);
		//simulate the JBox2D world
		world.getJBox2DWorld().step(delta, velocityIterations, positionIterations);
		
	}

	@Override
	public int getID() {
		return STATE_ID;
	}

}

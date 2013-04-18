package view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import model.InGame;

/**
 * 	Visar upp World & StatusBar
 */
public class InGameView {
	private InGame inGame;
	
	//Till controller
	private float timeStep = 1.0f / 60.0f;
	private int velocityIterations = 6;
	private int positionIterations = 2;
	
	
	public InGameView(InGame inGame) {
		this.inGame = inGame;
	}
	
	//Ska ligga i någon typ av init metod
	characterController = new oldController.CharacterController(world.getCharacter());
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(this.player.getCharacter().getColor());
		g.fill(world.getCharacter().getShape());
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		characterController.keyPressedUpdate(gc, delta);
		//simulate the JBox2D world
		world.getJBox2DWorld().step(timeStep, velocityIterations, positionIterations);
		world.updateSlick();
	}
}

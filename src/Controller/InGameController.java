package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.InGameView;
import model.BlockMap;
import model.InGame;

public class InGameController extends BasicGameState {
	private InGame inGame;
	private InGameView inGameView;
	private CharacterController characterController;
	private WorldController worldController;
	private BlockMapController blockMapController;
	
	//should be based on the frame update (delta or something like that)
	private float timeStep = 1.0f / 60.0f;
	private int velocityIterations = 6;
	private int positionIterations = 2;
	
	public InGameController() {
		this.characterController = new CharacterController(this);
		this.blockMapController = new BlockMapController();
		this.worldController = new WorldController(this);
		this.inGame = new InGame(worldController.getWorld());
		this.inGameView = new InGameView(inGame, worldController.getWorldView());
		//Will create ItemController etc.
	}

	public CharacterController getCharacterController() {
		return characterController;
	}

	public WorldController getWorldController() {
		return worldController;
	}
	
	public BlockMapController getBlockMapController() {
		return blockMapController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		//TODO ladda in filer
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.inGameView.render(gc, sbg, g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		characterController.keyPressedUpdate(gc);
		//simulate the JBox2D world TODO timeStep --> delta
		worldController.getWorldView().getJBox2DWorld().step(5, velocityIterations, positionIterations);
		worldController.updateSlickShape();
	}

	@Override
	public int getID() {
		return inGame.getID();
	}
}

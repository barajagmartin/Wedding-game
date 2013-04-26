package controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import utils.BlockMapUtils;
import view.BlockMapView;
import view.InGameView;
import model.BlockMap;
import model.Game;
import model.InGame;

public class InGameController extends BasicGameState {
	private InGame inGame;
	private InGameView inGameView;
	private CharacterController characterController;
	private WorldController worldController;
	private BlockMapController blockMapController;
	private CandyMonsterController candyMonsterController;
	private ItemController itemController;
	private int prevFPS = 0;
	
	//should be based on the frame update (delta or something like that)
	private float timeStep = 1.0f / 60.0f;
	private int velocityIterations = 6;
	private int positionIterations = 2;
	
	public InGameController() {
		
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
		 this.blockMapController = new BlockMapController(new TiledMap(BlockMapUtils.getTmxFile(1)));
		 this.characterController = new CharacterController(this);
		 /*Create all candy monsters and their items*/
		 for(int i = 1; i <= 3; i++){
			 this.candyMonsterController = new CandyMonsterController(this, i); 
			 this.itemController = new ItemController(this, i); 
		 }
		 this.worldController = new WorldController(this);
		 this.inGame = new InGame(worldController.getWorld());
		 this.inGameView = new InGameView(inGame, worldController.getWorldView());
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
		if(delta > 0) {
			this.timeStep = (float) delta / 1000f;
		}
		worldController.getWorldView().getJBox2DWorld().step(timeStep, velocityIterations, positionIterations);
		worldController.updateSlickShape();
		prevFPS = gc.getFPS();
	}

	@Override
	public int getID() {
		return Game.IN_GAME;
	}
}

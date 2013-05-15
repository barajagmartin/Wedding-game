package controller;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import utils.BlockMapUtils;
import utils.WorldUtils;
import view.CandyMonsterView;
import view.InGameView;
import view.MoveableBoxView;
import view.SpikesView;
import model.FixedPosition;
import model.Game;
import model.InGame;
import model.Item;

public class InGameController extends BasicGameState {
	private InGame inGame;
	private InGameView inGameView;
	private CharacterController characterController;
	private PlayerController playerController;
	private WorldController worldController;
	private StatusBarController statusBarController;
	private BlockMapController blockMapController;
	private ArrayList <CandyMonsterController> candyMonsterControllers;
	private ArrayList <ItemController> itemControllers;
	private ArrayList <SpikesController> spikesControllers;
	private ArrayList <MoveableBoxController> moveableBoxControllers;
	private ArrayList <Item> itemList; //used when checking if pickedUp in update
	private Item lastHeldItem;
	private int itemsDelivered;
	private StateBasedGame sbg;
	private GameController gameController;
	private static int level;
	private File folder;
	private boolean isPaused;
	//should be based on the frame update (delta or something like that)
	private float timeStep = 1.0f / 60.0f;
	private int velocityIterations = 6;
	private int positionIterations = 2;
	private boolean gameOver;
	private Music music; 
	public InGameController(GameController gameController) {
		this.gameController = gameController;

	}


	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.sbg = sbg;
		this.playerController = new PlayerController(this);
		folder = new File(".");
		this.statusBarController = new StatusBarController(this);
		isPaused = false;
		this.music = new Music("music/backgroundMusic.wav");
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game)
			throws SlickException {
		super.enter(container, game);
		if (!isPaused) {
			if (InGame.isNewGame()) {
				level = 1;
				playerController.getPlayer().reset();
				InGame.setNewGame(false);
			}else {
				level++;
			}
			music.loop();
			this.gameOver = false;
			this.inGame = new InGame(playerController.getPlayer());
			this.candyMonsterControllers = new ArrayList<CandyMonsterController>();
			this.itemControllers = new ArrayList<ItemController>();
			this.spikesControllers = new ArrayList<SpikesController>();
			this.moveableBoxControllers = new ArrayList<MoveableBoxController>();

			int nbrOfVersions = getNbrOfFiles(level);
			System.out.println("nbr of versions: " + nbrOfVersions + "of the level: " + level);
			//Get a new level, randomize between different level versions (i.e. there are many level 1 to randomize from)
			this.blockMapController = new BlockMapController(this, new TiledMap(BlockMapUtils.getTmxFile(level, inGame.randomizeVersion(nbrOfVersions))));
			/*Create candy monster and its items*/
			for (int i = 0; i < blockMapController.getCandyMonsterMap().getBlockList().size(); i++){
				this.candyMonsterControllers.add(new CandyMonsterController(this, i)); 
				this.itemControllers.add(new ItemController(this, i));
			}

			this.worldController = new WorldController(this);
			/*Create spikes*/
			for (int i = 0; i < blockMapController.getSpikesMap().getBlockList().size(); i++){
				this.spikesControllers.add(new SpikesController(this, i));
			}
			this.characterController = new CharacterController(this);
			for (FixedPosition pos : blockMapController.getBlockMapView().getMoveableBoxMap().getBlockList()) {
				this.moveableBoxControllers.add(new MoveableBoxController(this, pos));
			}

			//temporarily store the SpikesViews in a list
			ArrayList<SpikesView> tmpSpikesViewList = new ArrayList<SpikesView>();
			for (SpikesController spikesController : spikesControllers) {
				tmpSpikesViewList.add(spikesController.getSpikesView());
			}
			//temporarily store the MoveableBoxViews in a list
			ArrayList<MoveableBoxView> tmpMoveableBoxViewList = new ArrayList<MoveableBoxView>();
			for (MoveableBoxController moveableBoxController : moveableBoxControllers) {
				tmpMoveableBoxViewList.add(moveableBoxController.getMoveableBoxView());
			}

			this.inGameView = new InGameView(inGame, worldController.getWorldView(), statusBarController.getStatusBarView(), 
					characterController.getCharacterView(), tmpMoveableBoxViewList, tmpSpikesViewList, this.level);
			itemsDelivered = 0;

			itemList = new ArrayList<Item>();
			for (ItemController itemController : itemControllers) {
				itemList.add(itemController.getItem());
			}
		} else {
			isPaused = false;
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.inGameView.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		//change the time for the game and the character
		this.inGame.setTime(this.inGame.getTime()-(delta/1000f));
		this.characterController.getCharacter().setTimeSinceHit(this.characterController.getCharacter().getTimeSinceHit() + delta/1000f);
		//check if the player is hit by spikes
		if(this.characterController.getCharacter().isOnSpikes() && this.characterController.getCharacter().getTimeSinceHit() > 1) {
			this.playerController.getPlayer().loseOneLife();
			this.characterController.getCharacter().setTimeSinceHit(0);
		}
		//update the timeBar
		this.statusBarController.getStatusBarView().updateTimeBar(this.inGame.getLevelTime(), this.inGame.getTime());
		//check if the game is over
		checkGameOverConditions();
		//check key presses
		characterController.keyPressedUpdate(gc);
		//simulate the JBox2D world, timeStep --> delta
		if(delta > 0) {
			this.timeStep = (float) delta / 1000f * 4; //4 is for getting a good speed
		}
		worldController.getWorldView().getjBox2DWorld().step(timeStep, velocityIterations, positionIterations);
		worldController.updateSlickShape();
		worldController.updateItemPosition(worldController.getItemViewList(), characterController.getCharacterView());
		characterController.getCharacter().setX((int)characterController.getCharacterView().getSlickShape().getX());
		characterController.getCharacter().setY((int)characterController.getCharacterView().getSlickShape().getY());
		for (int i = 0; i < moveableBoxControllers.size(); i++) {
			moveableBoxControllers.get(i).getMoveableBox().setX(WorldUtils.meter2Pixel(
					moveableBoxControllers.get(i).getMoveableBoxView().getBoxBody().getPosition().x));
			moveableBoxControllers.get(i).getMoveableBox().setY(WorldUtils.meter2Pixel(
					moveableBoxControllers.get(i).getMoveableBoxView().getBoxBody().getPosition().y));


		}
	}

	@Override
	public void keyPressed (int key, char c) {
		if (key == Input.KEY_DOWN) {
			if (characterController.findItemToPickUp()!= null && !characterController.getCharacter().isHoldingItem(itemList)) {
				characterController.getCharacterView().setColor(Color.pink);
				characterController.getCharacter().pickUpItem(characterController.findItemToPickUp());
			} else if (characterController.getCharacter().isHoldingItem(itemList) && 
					characterController.getCharacterView().getCharacterBody().getLinearVelocity().y == 0) {
				lastHeldItem = characterController.getCharacter().getHeldItem();	
				characterController.getCharacter().dropDownItem(characterController.getCharacter().getHeldItem());
				this.itemControllers.get(lastHeldItem.CANDY_NUMBER).uppdateItemShape();
				candyMonsterControllers.get(lastHeldItem.CANDY_NUMBER).isDroppedOnMonster(lastHeldItem);
			}
		}
		if (key == Input.KEY_UP) {
			characterController.tryToJumpCharacter();
		}
		if (key == Input.KEY_ESCAPE){
			try {
				isPaused = true;
				inGameView.createPauseImage();
			} catch (SlickException e) {
				System.out.println("ERROR: No image could be created");
				e.printStackTrace();
			}
			//Set previous state to the state you where in before entering pause menu

			PauseMenuController.setPreviousState(Game.IN_GAME); 
			PauseMenuController.setPreviousState(Game.IN_GAME); 
			music.stop();
			sbg.enterState(Game.PAUSE_MENU);
		}
	}

	/**
	 * checks if the game is done by checking the lives on the character 
	 * and the items left in the world.
	 * 
	 */
	public void checkGameOverConditions() {
		if (this.itemControllers.size() == itemsDelivered) {
			System.out.println("No more items to pick up, level cleared!");
			if (this.getNbrOfFiles(this.gameController.getInGameController().getLevel() + 1) == 0) {
				this.playerController.getPlayer().setScore((int)this.inGame.getTime(), this.itemsDelivered, getPlayerController().getPlayer().getLife());
			} else {
				this.playerController.getPlayer().setScore((int)this.inGame.getTime(), this.itemsDelivered);
			}
			music.stop();
			sbg.enterState(Game.END_OF_LEVEL);
		} else if (this.playerController.getPlayer().getLife() == 0 || this.inGame.getTime() <= 0) {
			System.out.println("you are dead!");
			this.gameOver = true;
			music.stop();
			sbg.enterState(Game.END_OF_LEVEL);
		}
	}

	@Override
	public int getID() {
		return Game.IN_GAME;
	}

	public InGame getInGame() {
		return inGame;
	}


	public InGameView getInGameView() {
		return inGameView;
	}


	public int getItemsDelivered() {
		return itemsDelivered;
	}


	public void setItemsDelivered(int itemsDelivered) {
		this.itemsDelivered = itemsDelivered;
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


	public ArrayList<CandyMonsterController> getCandyMonsterController() {
		return candyMonsterControllers;
	}


	public ArrayList<ItemController> getItemController() {
		return itemControllers;
	}


	public ArrayList<SpikesController> getSpikesController() {
		return spikesControllers;
	}


	public PlayerController getPlayerController() {
		return playerController;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}


	/**
	 * Find files that are on the form levelx.y.tmx.
	 * 
	 * x is the level
	 * y is the level version
	 * @return the filenameFilter
	 */
	public FilenameFilter findFiles(final int level) {
		FilenameFilter filenameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.matches("level" + String.valueOf(level) + ".\\d.tmx");
			}
		};
		return filenameFilter;
	}


	public int getLevel() {
		return this.level;
	}
	
	public int getNbrOfFiles(int level) {
		return folder.listFiles(findFiles(level)).length;
		
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
}

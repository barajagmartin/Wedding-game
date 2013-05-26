package controller;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import utils.BlockMapUtils;
import utils.LevelUtils;
import utils.WorldUtils;
import view.CandyMonsterView;
import view.InGameView;
import view.ItemView;
import view.MoveableBoxView;
import view.SpikesView;
import model.Character;
import model.EndOfLevel;
import model.FixedPosition;
import model.InGame;
import model.Item;
import model.PauseMenu;

/**
 * This class is the state that is the actual game. It's here all different object in the world are created.
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class InGameController extends BasicGameState {
	private final InGame inGame;
	private InGameView inGameView;
	private CharacterController characterController;
	private final PlayerController playerController;
	private WorldController worldController;
	private StatusBarController statusBarController;
	private BlockMapController blockMapController;
	private List<CandyMonsterController> candyMonsterControllers;
	private List<ItemController> itemControllers;
	private List<SpikesController> spikesControllers;
	private List<MoveableBoxController> moveableBoxControllers;
	private List<Item> itemList; //used when checking if pickedUp in update
	private Item lastHeldItem;
	private StateBasedGame sbg;
	private final GameController gameController;
	private GameContainer gameContainer;
	//should be based on the frame update (delta or something like that)
	private float timeStep = 1.0f / 60.0f;
	private final int velocityIterations = 6;
	private final int positionIterations = 2;
	private Sound happySound;
	private Sound hurtSound;
	private boolean isMusicHighPitched;
	
	
	public InGameController(final GameController gameController) {
		super();
		this.gameController = gameController;
		this.playerController = new PlayerController();
		this.inGame = new InGame(playerController.getPlayer());
	}


	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.sbg = sbg;
		this.statusBarController = new StatusBarController();
		this.happySound = new Sound("music/happy0.wav");
		this.hurtSound = new Sound("music/aj0.wav");
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game)
			throws SlickException {
		super.enter(container, game);
		gameController.getInGameMusic().setVolume(1f);
		
		if (!inGame.isPaused()) {
			if (inGame.isNewGame()) {
				inGame.resetLevel();
				playerController.getPlayer().reset();
				inGame.setNewGame(false);
			}else {
				this.inGame.levelUp();
			}
			if(this.gameController.getGame().isMusicOn()) {
				gameController.getInGameMusic().loop();
			}
			
			this.inGame.reset();
			this.inGame.setGameOver(false);
			this.isMusicHighPitched = false;
			this.candyMonsterControllers = new ArrayList<CandyMonsterController>();
			this.itemControllers = new ArrayList<ItemController>();
			this.spikesControllers = new ArrayList<SpikesController>();
			this.moveableBoxControllers = new ArrayList<MoveableBoxController>();

			final int nbrOfVersions = LevelUtils.getNbrOfFiles(this.inGame.getLevel());
			//Get a new level, randomize between different level versions (i.e. there are many level 1 to randomize from)
			this.blockMapController = new BlockMapController(this, new TiledMap(BlockMapUtils.getTmxFile(this.inGame.getLevel(), inGame.randomizeVersion(nbrOfVersions)), "levels"));
			/*Create candy monster and their items*/
			for (int i = 0; i < blockMapController.getCandyMonsterMap().getBlockList().size(); i++){
				this.candyMonsterControllers.add(new CandyMonsterController(this, blockMapController.getBlockMapView().getCandyMonsterNbrMap().get(i), i));
				this.itemControllers.add(new ItemController(this, blockMapController.getBlockMapView().getItemNbrMap().get(i), i));
			}

			this.characterController = new CharacterController(this);

			/*Create spikes*/
			for (int i = 0; i < blockMapController.getSpikesMap().getBlockList().size(); i++){
				this.spikesControllers.add(new SpikesController(this, i));
			}
			for (FixedPosition pos : blockMapController.getBlockMapView().getMoveableBoxMap().getBlockList()) {
				this.moveableBoxControllers.add(new MoveableBoxController(pos));
			}

			//temporarily store the MoveableBoxViews in a list
			ArrayList<MoveableBoxView> tmpMoveableBoxViewList = new ArrayList<MoveableBoxView>();
			for (MoveableBoxController moveableBoxController : moveableBoxControllers) {
				tmpMoveableBoxViewList.add(moveableBoxController.getMoveableBoxView());
			}
			
			//temporarily store the CandyMonsterViews in a list
			ArrayList<CandyMonsterView> tmpCandyMonsterViewList = new ArrayList<CandyMonsterView>();
			for (CandyMonsterController candyMonsterController : candyMonsterControllers) {
				tmpCandyMonsterViewList.add(candyMonsterController.getCandyMonsterView());
			}
			
			//temporarily store the ItemViews in a list
			ArrayList<ItemView> tmpItemViewList = new ArrayList<ItemView>();
			for (ItemController itemController : itemControllers) {
				tmpItemViewList.add(itemController.getItemView());
			}
			
			//temporarily store the SpikesViews in a list
			ArrayList<SpikesView> tmpSpikesViewList = new ArrayList<SpikesView>();
			for (int i = 0; i < spikesControllers.size(); i++) {
				tmpSpikesViewList.add(spikesControllers.get(i).getSpikesView());
			}
			
			
			this.worldController = new WorldController(this, characterController.getCharacterView(),
					tmpMoveableBoxViewList,
					tmpCandyMonsterViewList,
					tmpItemViewList,
					tmpSpikesViewList);
			inGame.setWorld(worldController.getWorld());
			this.inGameView = new InGameView(inGame, worldController.getWorldView(), statusBarController.getStatusBarView(), 
					characterController.getCharacterView(), tmpMoveableBoxViewList, tmpSpikesViewList, this.inGame.getLevel());

			itemList = new ArrayList<Item>();
			for (ItemController itemController : itemControllers) {
				itemList.add(itemController.getItem());
			}
		} else {
			this.inGame.setPaused(false);
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
		this.gameContainer = gc;
		//change the time for the game and the character
		this.inGame.setTime(this.inGame.getTime()-(delta/1000f));
		this.characterController.getCharacter().setTimeSinceHit(this.characterController.getCharacter().getTimeSinceHit() + delta/1000f);
		//update animation so that it animates at the right speed
		characterController.getCharacterView().getAnimation().update(delta);
		//check if the player is hit by spikes
		if(this.characterController.getCharacter().isOnSpikes() && this.characterController.getCharacter().getTimeSinceHit() > 1) {
			//plays hurt sound if sound is on
			if(gameController.getGame().isSoundOn()){
				this.hurtSound.play();  
			}
			this.playerController.getPlayer().loseOneLife();
			this.characterController.getCharacter().setTimeSinceHit(0);
		}
		
		if(this.characterController.getCharacter().getTimeSinceHit() <= 1) {
			if(characterController.getCharacterView().isWalkingLeft()) {
				characterController.getCharacterView().animateBlinkingLeft();
			} else {
				characterController.getCharacterView().animateBlinkingRight();
			}
		} else if (this.characterController.getCharacter().getTimeSinceHit() > 1 && characterController.getCharacterView().isBlinking()) {
			if(characterController.getCharacterView().isBlinkingLeft()) {
				characterController.getCharacterView().animateWalkingLeft();
			} else {
				characterController.getCharacterView().animateWalkingRight();
			}
		}
		
		//update the timeBar
		this.statusBarController.getStatusBarView().updateTimeBar(this.inGame.getLevelTime(), this.inGame.getTime());
		
		//increase pitch when time is running out
		if(this.gameController.getGame().isMusicOn() && inGame.isTimeRunningOut() && !isMusicHighPitched) {
				gameController.getInGameMusic().play(1.4f, 1f);
				isMusicHighPitched = true;
		}
		
		//check if the game is over
		if (inGame.checkIfGameIsOver(itemControllers.size(),LevelUtils.getNbrOfFiles(inGame.getLevel() + 1))) {
			gameController.getInGameMusic().stop();
			sbg.enterState(EndOfLevel.STATE_ID);
		}
		//check key presses
		characterController.keyPressedUpdate(gc);

		//simulate the JBox2D world, timeStep --> delta
		if(delta > 0) {
			this.timeStep = (float) delta / 1000f * 4; //4 is for getting a good speed
		}
		worldController.getWorldView().getjBox2DWorld().step(timeStep, velocityIterations, positionIterations);
		
		characterController.getCharacter().getPos().setX(WorldUtils.meter2Pixel(
				inGameView.getCharacterView().getCharacterBody().getPosition().x) -
				Character.RADIUS);
		characterController.getCharacter().getPos().setY(WorldUtils.meter2Pixel(
				inGameView.getCharacterView().getCharacterBody().getPosition().y) -
				Character.RADIUS);
		
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).isPickedUp()) {
				if (this.characterController.getCharacterView().isWalkingLeft() || this.characterController.getCharacterView().isBlinkingLeft() || this.characterController.getCharacterView().isStandingLeft()) {
					itemList.get(i).getPos().setX((int)characterController.getCharacterView().getSlickShape().getX());
					itemList.get(i).getPos().setY((int)characterController.getCharacterView().getSlickShape().getY() + Character.RADIUS);
				} else {
					itemList.get(i).getPos().setX((int)characterController.getCharacterView().getSlickShape().getX() + Character.RADIUS +5);
					itemList.get(i).getPos().setY((int)characterController.getCharacterView().getSlickShape().getY() + Character.RADIUS);
				}
				
			}
		}
		
		worldController.updateCharacterSlickShape();
		worldController.updateItemSlickShapePosition(worldController.getItemViewList(), characterController.getCharacterView());
		characterController.getCharacter().getPos().setX((int)characterController.getCharacterView().getSlickShape().getX());
		characterController.getCharacter().getPos().setY((int)characterController.getCharacterView().getSlickShape().getY());
		for (int i = 0; i < moveableBoxControllers.size(); i++) {
			moveableBoxControllers.get(i).getMoveableBox().getPos().setX(WorldUtils.meter2Pixel(
					moveableBoxControllers.get(i).getMoveableBoxView().getBoxBody().getPosition().x));
			moveableBoxControllers.get(i).getMoveableBox().getPos().setY(WorldUtils.meter2Pixel(
					moveableBoxControllers.get(i).getMoveableBoxView().getBoxBody().getPosition().y));
		}
		
	}


	@Override
	public void keyPressed (int key, char c) {
		if (key == Input.KEY_DOWN) {
			if (characterController.findItemToPickUp()!= null && !characterController.getCharacter().isHoldingItem(itemList)) {
				characterController.getCharacter().pickUpItem(characterController.findItemToPickUp());
			} else if (characterController.getCharacter().isHoldingItem(itemList) && 
					characterController.getCharacterView().getCharacterBody().getLinearVelocity().y == 0) {
				lastHeldItem = characterController.getCharacter().getHeldItem();
				characterController.getCharacter().dropDownItem(lastHeldItem);
				this.itemControllers.get(blockMapController.getBlockMapView().getItemNbrMap().indexOf(lastHeldItem.CANDY_NUMBER)).updateItemShape();
				if(candyMonsterControllers.get(blockMapController.getBlockMapView().getCandyMonsterNbrMap().indexOf(lastHeldItem.CANDY_NUMBER)).isDroppedOnMonster(lastHeldItem) && gameController.getGame().isSoundOn()) {
					this.happySound.play();
				}
			}
		}
		else if (key == Input.KEY_UP) {
			characterController.tryToJumpCharacter();
		}
		else if (key == Input.KEY_ESCAPE){
			try {
				inGame.setPaused(true);
				inGameView.createPauseImage();
				gameController.getGameView().setPauseImage(inGameView.getPauseImage());
			} catch (SlickException e) {
				e.printStackTrace();
			}
			//Set previous state to the state you where in before entering pause menu
			PauseMenuController.setPreviousState(InGame.STATE_ID); 
			
			gameController.getInGameMusic().setVolume(0.3f);
			sbg.enterState(PauseMenu.STATE_ID);
		}
		
		else if(key == Input.KEY_TAB) {
			this.gameController.changeFullscreen(this.gameContainer);
		}
	}

	@Override
	public int getID() {
		return InGame.STATE_ID;
	}

	public InGame getInGame() {
		return inGame;
	}


	public InGameView getInGameView() {
		return inGameView;
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


	public List<MoveableBoxController> getMoveableBoxControllers() {
		return moveableBoxControllers;
	}


	public List<CandyMonsterController> getCandyMonsterControllers() {
		return candyMonsterControllers;
	}


	public List<ItemController> getItemControllers() {
		return itemControllers;
	}


	public List<SpikesController> getSpikesControllers() {
		return spikesControllers;
	}


	public PlayerController getPlayerController() {
		return playerController;
	}
	

	public Sound getHappySound() {
		return happySound;
	}

	
}
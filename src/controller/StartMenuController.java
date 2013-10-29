package controller;

import model.Controls;
import model.HighScore;
import model.InGame;
import model.StartMenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.StartMenuView;
/**
 * This state is the first state entering the game, the start menu. You will always return to this state before exiting the game
 * @author Josefin
 *
 */
public class StartMenuController extends BasicGameState {
	private StartMenuView startMenuView;
	private final StartMenu startMenu;
	private StateBasedGame sbg;
	private final GameController gameController;
	private Music startMenuMusic;
	private GameContainer gc;
	
	public StartMenuController(final GameController gameController) {
		super();
		this.gameController = gameController;
		this.startMenu = new StartMenu();
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.sbg = game;
		this.startMenuView = new StartMenuView(this.startMenu, gameController.getGameView());
		this.startMenuMusic = new Music("music/bgMusic.wav");
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		super.enter(container, game);
		this.gameController.getGame().getInGame().setNewGame(true);
		if(gameController.getGame().isMusicOn() && !this.startMenuMusic.playing()) {
			this.startMenuMusic.loop();
		}
		this.startMenuMusic.setVolume(0.7f);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		this.startMenuView.render(container, game, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		this.gc = container;
		
	}
	
	@Override
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_DOWN) {
			startMenu.markButtonDown();
		}
		if(key == Input.KEY_UP) {
			startMenu.markButtonUp();
		}
		if(key == Input.KEY_ENTER) {
			switch(startMenu.isMarked()) {
				//Start game
				case 0: sbg.enterState(InGame.STATE_ID);
						break;
				//Highscore
				case 1: sbg.enterState(HighScore.STATE_ID);
						break;
				//Sound
				case 2: if(gameController.getGame().isSoundOn()) {
							gameController.getGame().setSoundOn(false);
						} else {
							gameController.getGame().setSoundOn(true);
						}
						break;
				//Music
				case 3: if(gameController.getGame().isMusicOn()) {
							this.startMenuMusic.pause();
							gameController.getGame().setMusicOn(false);
						} else {
							startMenuMusic.resume();
							startMenuMusic.setVolume(0.7f);
							gameController.getGame().setMusicOn(true);
						}	
						break;
				//Controls
				case 4: sbg.enterState(Controls.STATE_ID);
						break;
				//Exit game
				case 5: System.exit(0);
			}
		}
		if(key == Input.KEY_TAB) {
			this.gameController.changeFullscreen(this.gc);
		}
	}

	public StartMenu getStartMenu() {
		return startMenu;
	}

	public Music getStartMenuMusic() {
		return startMenuMusic;
	}

	@Override
	public int getID() {
		return StartMenu.STATE_ID;
	}
}

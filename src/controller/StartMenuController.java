package controller;

import model.Game;
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

public class StartMenuController extends BasicGameState {
	private StartMenuView startMenuView;
	private StartMenu startMenu;
	private StateBasedGame sbg;
	private GameController gameController;
	private Music startMenuMusic;
	private GameContainer gc;
	
	public StartMenuController(GameController gameController) {
		this.gameController = gameController;
		this.startMenu = new StartMenu();
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.sbg = game;
		this.startMenuView = new StartMenuView(this.startMenu);
		this.startMenuMusic = new Music("music/backgroundMusic.wav");
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		super.enter(container, game);
		this.gameController.getGame().getInGame().setNewGame(true);
		if(this.startMenu.isMusicOn()) {
			this.startMenuMusic.loop();
		}
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
	
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_DOWN) {
			startMenu.markButtonDown();
		}
		if(key == Input.KEY_UP) {
			startMenu.markButtonUp();
		}
		if(key == Input.KEY_ENTER) {
			switch(startMenu.getIsMarked()) {
				case 0: sbg.enterState(Game.IN_GAME);
						break;
				case 1: sbg.enterState(Game.HIGHSCORE);
						break;
				case 2: if(startMenu.isSoundOn()) {
							startMenu.setSoundOn(false);
						} else {
							startMenu.setSoundOn(true);
						}
						break;
				case 3: if(startMenu.isMusicOn()) {
							this.startMenuMusic.pause();
							startMenu.setMusicOn(false);
						} else {
							this.startMenuMusic.play();
							startMenu.setMusicOn(true);
						}	
						break;
				case 4: sbg.enterState(Game.CONTROLS);
						break;
				case 5: System.exit(0);
			}
		}
		if(key == Input.KEY_F11) {
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
		return Game.START_MENU;
	}

}

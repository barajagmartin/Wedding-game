package controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class GameController extends StateBasedGame {
	private Game game;
	private StartMenuController startMenuController;
	private InGameController inGameController;
	private PauseMenuController pauseMenuController;
	private EndOfLevelController endOfLevelController;
	private HighScoreStateController highScoreStateController;
	private NewHighscoreController newHighscoreController;
	private ControlsController controlsController;
	private Music inGameMusic;

	
	public GameController(String name) throws SlickException {
		super(name);
		this.inGameMusic = new Music("music/Marimba.wav");
		this.startMenuController = new StartMenuController(this);
		this.highScoreStateController = new HighScoreStateController(this);
		this.newHighscoreController = new NewHighscoreController(this);
		this.inGameController = new InGameController(this);
		this.pauseMenuController = new PauseMenuController(this);
		this.endOfLevelController = new EndOfLevelController(this);
		this.controlsController = new ControlsController(this);
		this.game = new Game(inGameController.getInGame(), startMenuController.getStartMenu());
		this.addState(inGameController);
		this.addState(highScoreStateController);
		this.addState(pauseMenuController);
		this.addState(newHighscoreController);
		this.addState(pauseMenuController);
		this.addState(endOfLevelController);
		this.addState(startMenuController);
		this.addState(controlsController);
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.enterState(startMenuController.getID());
	}
	
	public StartMenuController getStartMenuController(){
		return startMenuController;
	}
	
	public InGameController getInGameController(){
		return inGameController;
	}
	
	public PauseMenuController getPauseController(){
		return pauseMenuController;
	}

	public HighScoreStateController getHighScoreStateController() {
		return highScoreStateController;
	}

	public Game getGame() {
		return game;
	}

	public Music getInGameMusic() {
		return inGameMusic;
	}
}

package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import utils.SaveUtils;

public class Game {
	
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	private boolean isMusicOn;
	private boolean isSoundOn;
	
	
	private InGame inGame;
	private StartMenu startMenu;
	
	public Game(InGame inGame) {
		this.inGame = inGame;
		this.isMusicOn = true;
		this.isSoundOn = true;
		SaveUtils.init();
	}
	

	public StartMenu getStartMenu() {
		return startMenu;
	}
	
	public InGame getInGame() {
		return inGame;
	}

	
	public void setSoundOn(boolean isSoundOn){
		this.isSoundOn = isSoundOn;
	}
	
	public boolean isSoundOn() {
		return isSoundOn;
	}
	
	public void setMusicOn(boolean isMusicOn){
		this.isMusicOn = isMusicOn;
	}
	
	public boolean isMusicOn() {
		return isMusicOn;
	}
	
}

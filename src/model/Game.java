package model;

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
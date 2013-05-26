package view;

import org.newdawn.slick.Image;

import model.Game;

public class GameView {
	private Game game;
	private Image pauseImage;
	
	public GameView(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public Image getPauseImage() {
		return pauseImage;
	}

	public void setPauseImage(Image pauseImage) {
		this.pauseImage = pauseImage;
	}
}
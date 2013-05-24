package view;

import model.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import controller.GameController;

public class EndOfLevelView {
	private int score;
	private boolean gameOver;
	private boolean victory;
	
	
	public EndOfLevelView (int score, boolean gameOver, boolean victory) {
		this.score = score;
		this.gameOver = gameOver;
		this.victory = victory;
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if (gameOver) {
			Image i = new Image("pics/gameOver.png");
			i.draw();
			g.setColor(Color.red);
		} else if (victory) {
			Image i = new Image("pics/victory.png");
			i.draw();
			g.setColor(Color.green);
		} else {
			Image i = new Image("pics/levelCleared.png");
			i.draw();
			g.setColor(Color.yellow);
		}
		g.drawString("ENTER - continue", Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 40);
		g.drawString("ESC - back to menu", Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 60);
		g.drawString("Score: " + this.score, Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 90);
	}
	


}

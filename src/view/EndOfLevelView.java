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
	private int Score;
	
	
	public EndOfLevelView (int Score) {
		this.Score = Score;
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		Image i = new Image("pics/rainbowattheend.jpg"); 
		i.draw();
		g.setColor(Color.black);
		g.drawString("ENTER - start new level", Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 40);
		g.drawString("ESC - quit the game", Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 60);
		g.drawString("Score: " + this.Score, Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 90);
	}

	public void setScore(int score) {
		Score = score;
	}
	


}

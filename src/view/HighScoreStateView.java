package view;

import model.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class HighScoreStateView {
	
	public int[] scoreList;
	public String[] nameList;
	
	public HighScoreStateView (int[] scoreList, String[] nameList) {
		this.scoreList = scoreList;
		this.nameList = nameList;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.green);
		int y = 200;
		for (int i = 0; i < 10; i++) {
			g.drawString(Integer.toString(i+1) + ". " + this.nameList[i] + " .................................... " + Integer.toString(this.scoreList[i]), (Game.WINDOW_WIDTH/2-200), y);
			y = y + 40;
		}
		
	}
	
}

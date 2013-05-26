package view;

import model.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import utils.SaveUtils;

public class HighScoreStateView {
	private Image background;
	private StringBuilder stringBuilder;
	
	public HighScoreStateView () throws SlickException {
		background = new Image("pics/highscore_background.png");
		stringBuilder = new StringBuilder();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		background.draw();
		g.setColor(Color.green);
		int y = 200;
		
		String space = " ";
		for (int i = 0; i < 10; i++) {
			stringBuilder.delete(0, stringBuilder.length());
			if (i == 9) {
				space = "";
			}
			stringBuilder.append(Integer.toString(i+1)).append(". ").append(space).append(SaveUtils.getNameList()[i]);
			if (SaveUtils.getNameList()[i].length() == 0) {
				stringBuilder.append(".");
			} else {
				stringBuilder.append(" ");
			}
			for (int j = 0 ; j < 36 - SaveUtils.getNameList()[i].length()
					- String.valueOf(SaveUtils.getScoreList()[i]).length() + 1; j++) {
				stringBuilder.append(".");
			}
			stringBuilder.append(Integer.toString(SaveUtils.getScoreList()[i]));
			
			g.drawString(stringBuilder.toString(), (Game.WINDOW_WIDTH/2-200), y);
			y = y + 40;
		}
	}
}
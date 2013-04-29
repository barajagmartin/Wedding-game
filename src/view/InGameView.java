package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import model.InGame;

/**
 * 	Visar upp World & StatusBar.
 */
public class InGameView {
	private InGame inGame;
	private WorldView worldView;
	
	public InGameView(InGame inGame, WorldView worldView) {
		this.inGame = inGame;
		this.worldView = worldView;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		Image i = new Image("pics/pinkbg.png"); //Will be get from the Multimedia class later
		i.draw();
		g.setColor(worldView.getCharacterView().getColor());
		g.fill(worldView.getCharacterView().getSlickShape());
		worldView.getBlockMapView().getTiledMap().render(0, 0);
	}

	
}

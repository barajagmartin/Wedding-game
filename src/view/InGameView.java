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
		worldView.getBlockMapView().getTiledMap().render(0, 0);
		//draw candyMonsters
		for (int j = 0; j < worldView.getCandyMonsterViewList().length; j++) {
			g.setColor(worldView.getCandyMonsterViewList()[j].getColor());
			g.fill(worldView.getCandyMonsterViewList()[j].getShape());
		}
		//draw character
		g.setColor(worldView.getCharacterView().getColor());
		g.fill(worldView.getCharacterView().getSlickShape());
		//draw items
		for (int j = 0; j < worldView.getItemViewList().length; j++) {
			g.setColor(worldView.getItemViewList()[j].getColor());
			g.fill(worldView.getItemViewList()[j].getShape());
		}
		//draw spikes
		for (int j = 0; j < worldView.getSpikesViewList().length; j++) {
			g.setColor(worldView.getSpikesViewList()[j].getColor());
			g.fill(worldView.getSpikesViewList()[j].getShape());
		}
		
	}

	
}

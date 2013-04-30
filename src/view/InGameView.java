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
		
		//draw character
		g.setColor(worldView.getCharacterView().getColor());
		g.fill(worldView.getCharacterView().getSlickShape());
		Image i = new Image("pics/rainbow.jpg"); //Will be get from the Multimedia class later
		i.draw();
		worldView.getBlockMapView().getTiledMap().render(0, 0);
		//draw candyMonsters
		for (int j = 0; j < worldView.getCandyMonsterViewList().size(); j++) {
			g.setColor(worldView.getCandyMonsterViewList().get(j).getColor());
			g.fill(worldView.getCandyMonsterViewList().get(j).getShape());
		}	
		//draw spikes
				for (int j = 0; j < worldView.getSpikesViewList().size(); j++) {
					g.setColor(worldView.getSpikesViewList().get(j).getColor());
					g.fill(worldView.getSpikesViewList().get(j).getShape());
				}
		
		Image player = new Image("pics/GulNelson.png");
		
		player.draw(worldView.getCharacterView().getSlickShape().getX(),worldView.getCharacterView().getSlickShape().getY());
		//draw items
		for (int j = 0; j < worldView.getItemViewList().size(); j++) {
			g.setColor(worldView.getItemViewList().get(j).getColor());
			g.fill(worldView.getItemViewList().get(j).getShape());
		}
		
	}

	
}

package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.StateBasedGame;

import model.Game;
import model.InGame;
import model.StatusBar;

/**
 * 	Visar upp World & StatusBar.
 */
public class InGameView {
	private InGame inGame;
	private WorldView worldView;
	private StatusBarView statusBarView;
	private CharacterView characterView;
	private Graphics g;
	
	public InGameView(InGame inGame, WorldView worldView, StatusBarView statusBarView, CharacterView characterView) {
		this.inGame = inGame;
		this.worldView = worldView;
		this.statusBarView = statusBarView;
		this.characterView = characterView;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.g = g;
		//draw character
		g.setColor(characterView.getColor());
		g.fill(characterView.getSlickShape());
		Image background = new Image("pics/rainbow.jpg"); //Will be get from the Multimedia class later
		background.draw();
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
		
		player.draw(characterView.getSlickShape().getX(), characterView.getSlickShape().getY());
		//draw items
		for (int j = 0; j < worldView.getItemViewList().size(); j++) {
			g.setColor(worldView.getItemViewList().get(j).getColor());
			g.fill(worldView.getItemViewList().get(j).getShape());
		}
		//draw a temporary timer
		g.drawString("Time : " + this.inGame.getTime(), 10, 25);
		
		//draw status bar
		g.drawString("LIFE", 35, 570);
		for(int k = 0; k < characterView.getCharacter().getLife(); k++) {
			statusBarView.getHeart()[k].draw(StatusBar.HEART_POSX[k], StatusBar.HEART_POSY);
		}
		g.drawString("TIME", 630, 570);
		g.setColor(Color.darkGray);
		g.fill(statusBarView.getFixedBar());
		g.setColor(Color.green);
		g.fill(statusBarView.getTimeBar());

	}
	
	public void createPauseImage() throws SlickException{
		//Save all contents in an Image for the pause state
		Image pauseImage = new Image(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		g.copyArea(pauseImage, 0, 0);
		ImageOut.write(pauseImage.copy(), "pics/pauseBackground.png", false);
		pauseImage.destroy();
	}

	
}

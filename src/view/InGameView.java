package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import model.InGame;
import model.Spikes;
import model.StatusBar;

/**
 * 	Visar upp World & StatusBar.
 */
public class InGameView {
	private InGame inGame;
	private WorldView worldView;
	private StatusBarView statusBarView;
	private CharacterView characterView;
	
	public InGameView(InGame inGame, WorldView worldView, StatusBarView statusBarView, CharacterView characterView) {
		this.inGame = inGame;
		this.worldView = worldView;
		this.statusBarView = statusBarView;
		this.characterView = characterView;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		//draw character
		g.setColor(characterView.getColor());
		g.fill(characterView.getSlickShape());
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
					//set the color when "debugging"
					//g.setColor(worldView.getSpikesViewList().get(j).getColor());
					g.setColor(Color.transparent); //so it does not show the circle
					g.fill(worldView.getSpikesViewList().get(j).getShape());
					g.drawImage(this.worldView.getSpikesViewList().get(j).getImage(), 
							this.worldView.getSpikesViewList().get(j).getSpikes().getX()- Spikes.RADIUS - 3, 
							this.worldView.getSpikesViewList().get(j).getSpikes().getY() - Spikes.RADIUS - 3);
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
		for(int k = 0; k < characterView.getCharacter().getLife(); k++) {
			statusBarView.getHeart()[k].draw(StatusBar.HEART_POSX[k], StatusBar.HEART_POSY);
		}
		g.setColor(Color.white);
		g.drawString("LIFE", StatusBar.HEART_POSX[0] - 15, StatusBar.HEART_POSY - 20);
		g.drawString("TIME", StatusBar.FIXED_BAR_POSX - 15, StatusBar.HEART_POSY - 20);
		g.setColor(Color.darkGray);
		g.fill(statusBarView.getFixedBar());
		g.setColor(Color.green);
		g.fill(statusBarView.getTimeBar());
	}

	
}

package view;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.StateBasedGame;

import model.Game;
import model.InGame;
import model.MoveableBox;
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
	private ArrayList<MoveableBoxView> moveableBoxViewList;
	private ArrayList<SpikesView> spikesViewList;
	private Image pauseImage;
	public CharacterView getCharacterView() {
		return characterView;
	}
	private Graphics g;
	private int level;

	public InGameView(InGame inGame, WorldView worldView, StatusBarView statusBarView, CharacterView characterView, ArrayList<MoveableBoxView> tmpMoveableBoxViewList, ArrayList<SpikesView> spikesViewList, int level) {
		this.inGame = inGame;
		this.worldView = worldView;
		this.statusBarView = statusBarView;
		this.characterView = characterView;
		this.moveableBoxViewList = tmpMoveableBoxViewList;
		this.spikesViewList = spikesViewList;
		this.level = level;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.g = g;
		//draw character
		this.g.setColor(characterView.getColor());
		this.g.fill(characterView.getSlickShape());
		Image background = new Image("pics/rainbow.jpg");
		background.draw();
		worldView.getBlockMapView().getTiledMap().render(0, 0, worldView.getBlockMapView().getTiledMap().getLayerIndex("solids"));
		//draw candyMonsters
		for (int j = 0; j < worldView.getCandyMonsterViewList().size(); j++) {
			this.g.setColor(Color.transparent);
			this.g.fill(worldView.getCandyMonsterViewList().get(j).getShape());
			
			if (worldView.getItemViewList().get(j).getItem().isDelivered()) {
			this.g.drawImage(worldView.getCandyMonsterViewList().get(j).getHappyImage(),
					worldView.getCandyMonsterViewList().get(j).getCandyMonster().getX(),
					worldView.getCandyMonsterViewList().get(j).getCandyMonster().getY());
			} else {
				this.g.drawImage(worldView.getCandyMonsterViewList().get(j).getSadImage(),
						worldView.getCandyMonsterViewList().get(j).getCandyMonster().getX(),
						worldView.getCandyMonsterViewList().get(j).getCandyMonster().getY());
			}
		}	
		//draw spikes
		for (int j = 0; j < spikesViewList.size(); j++) {
			//set the color when "debugging"
			g.setColor(Color.transparent); //so it does not show the circle
			g.fill(spikesViewList.get(j).getShape());
			g.drawImage(spikesViewList.get(j).getImage(), 
					spikesViewList.get(j).getSpikes().getPos().getX()- Spikes.RADIUS - 3, 
					spikesViewList.get(j).getSpikes().getPos().getY() - Spikes.RADIUS - 3);
		}
		
		//draw Nelson
		characterView.getAnimation().draw(characterView.getCharacter().getX(), characterView.getCharacter().getY());
		
		for (MoveableBoxView moveableBoxView : moveableBoxViewList) {
			g.drawImage(moveableBoxView.getImage(), moveableBoxView.getMoveableBox().getPos().getX()-MoveableBox.HALF_WIDTH,
					moveableBoxView.getMoveableBox().getPos().getY()-MoveableBox.HALF_HEIGHT+1); // +1 is to correct position which
																							// probably is rounded incorrectly
		}

		//draw items
		for (int j = 0; j < worldView.getItemViewList().size(); j++) {
			this.g.setColor(Color.transparent);
			this.g.fill(worldView.getItemViewList().get(j).getShape());
			this.g.drawImage(worldView.getItemViewList().get(j).getImage(),
					worldView.getItemViewList().get(j).getItem().getX(),
					worldView.getItemViewList().get(j).getItem().getY());
		}
		//draw a temporary timer
		this.g.drawString("Time : " + this.inGame.getTime(), 10, 25);

		//draw status bar
		for(int k = 0; k < inGame.getPlayer().getLife(); k++) {
			statusBarView.getHeart()[k].draw(StatusBar.HEART_POSX[k], StatusBar.HEART_POSY);
		}
		this.g.setColor(Color.white);
		this.g.drawString("LIFE", StatusBar.HEART_POSX[0] - 15, StatusBar.HEART_POSY - 20);
		this.g.drawString("TIME", StatusBar.FIXED_BAR_POSX - 15, StatusBar.HEART_POSY - 20);
		this.g.drawString("Lv." + this.level, Game.WINDOW_WIDTH - 60, StatusBar.HEART_POSY - 40);
		this.g.setColor(Color.darkGray);
		this.g.fill(statusBarView.getFixedBar());
		
		if(inGame.getTime()/inGame.getLevelTime() < 0.1) { //when 10% of the time remains
			this.g.setColor(Color.red);
		} else {
			this.g.setColor(Color.green);
		}
		this.g.fill(statusBarView.getTimeBar());
		

	}
	/**Save all graphics in an Image to create an illusion of a paused screen in PauseView
	 * @throws SlickException */
	public void createPauseImage() throws SlickException {
		pauseImage = new Image(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		this.g.copyArea(pauseImage, 0, 0);
<<<<<<< HEAD
		ImageOut.write(pauseImage.copy(), "pics/pauseBackground.png", false);
		pauseImage.destroy();
=======
>>>>>>> 07434cb087b4f0451a3a18f8108487976dc52d98
	}
	
	public Image getPauseImage(){
		return pauseImage;
	}
}

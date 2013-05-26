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
	private Image cloud;
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
		try {
			this.cloud = new Image("pics/cloud.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.level = level;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.g = g;
		Image background = new Image("pics/bg_"+level+".jpg");
		background.draw();
		worldView.getBlockMapView().getTiledMap().render(0, 0, worldView.getBlockMapView().getTiledMap().getLayerIndex("solids"));
		//draw candyMonsters and clouds
		for (int j = 0; j < worldView.getCandyMonsterViewList().size(); j++) {
			this.g.setColor(Color.transparent);
			this.g.fill(worldView.getCandyMonsterViewList().get(j).getShape());
			this.g.drawImage(worldView.getCandyMonsterViewList().get(j).getImage(),
					worldView.getCandyMonsterViewList().get(j).getCandyMonster().getPos().getX(),
					worldView.getCandyMonsterViewList().get(j).getCandyMonster().getPos().getY());
			//clouds w. candy
			if (!worldView.getCandyMonsterViewList().get(j).getCandyMonster().isHappy) {
				this.g.drawImage(this.cloud, worldView.getCandyMonsterViewList().get(j).getCandyMonster().getPos().getX(),
						worldView.getCandyMonsterViewList().get(j).getCandyMonster().getPos().getY()-30);
				for (int k = 0; k < this.worldView.getItemViewList().size(); k++) {
					if (this.worldView.getItemViewList().get(k).getItem().CANDY_NUMBER == worldView.getCandyMonsterViewList().get(j).getCandyMonster().CANDY_NUMBER) {
						this.g.drawImage(worldView.getItemViewList().get(k).getImage(), worldView.getCandyMonsterViewList().get(j).getCandyMonster().getPos().getX()+5, 
								worldView.getCandyMonsterViewList().get(j).getCandyMonster().getPos().getY()-27);
					}
				}
			}
			
		}

		//draw spikes
		for (int j = 0; j < spikesViewList.size(); j++) {
			g.setColor(Color.transparent); //so it does not show the circle
			g.fill(spikesViewList.get(j).getShape());
			g.drawImage(spikesViewList.get(j).getImage(), 
					spikesViewList.get(j).getSpikes().getPos().getX()- Spikes.RADIUS - 3, 
					spikesViewList.get(j).getSpikes().getPos().getY() - Spikes.RADIUS - 3);
		}

		//draw Nelson
		characterView.getAnimation().draw(characterView.getCharacter().getX(), characterView.getCharacter().getY());

		//draw items
		for (int j = 0; j < worldView.getItemViewList().size(); j++) {
			this.g.setColor(Color.transparent);
			this.g.fill(worldView.getItemViewList().get(j).getShape());
			this.g.drawImage(worldView.getItemViewList().get(j).getImage(),
					worldView.getItemViewList().get(j).getItem().getPos().getX(),
					worldView.getItemViewList().get(j).getItem().getPos().getY());
		}
		
		for (MoveableBoxView moveableBoxView : moveableBoxViewList) {
			g.drawImage(moveableBoxView.getImage(), moveableBoxView.getMoveableBox().getPos().getX()-MoveableBox.HALF_WIDTH,
					moveableBoxView.getMoveableBox().getPos().getY()-MoveableBox.HALF_HEIGHT+1); // +1 is to correct position which
			// probably is rounded incorrectly
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

		if(inGame.isTimeRunningOut()) { //when 10% of the time remains
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
	}

	public Image getPauseImage(){
		return pauseImage;
	}
}

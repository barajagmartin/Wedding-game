package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PauseController extends BasicGameState{
	private GameContainer gc;
	private GameController gameController;
	
	
	public PauseController(GameController gameController){
		this.gameController = gameController;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.gc = gc;
		
	}
	//vill först skapa en bild av spelet. Över detta menyn
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if(gc.isPaused()){
			/*Create image of game*/
			Rectangle rect = new Rectangle(0, 0, gameController.getInGameController().getWorldController().getWorld().getWorldWidthPx(), 
												gameController.getInGameController().getWorldController().getWorld().getWorldHeightPx());
												//x, y, width, height
			
			//gather contents from the play screen and make a new Image
			//get graphics and render your scene in the new Image
			//set Image as background
			//create a fill rect for opacity and color if needed
			
			/*if you pause, you keep the last state id in memory and you do a transition to your paused state
			 * if you resume you get the last state back by id and everyting "resumes" automatically without 
			 * doing noting, the state is paused (not rendered or updated) until you go back to that state*/
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed (int key, char c) {
		if(key == Input.KEY_ESCAPE){
			gc.setPaused(!gc.isPaused()); //Pause, unpause
		}
	}

	@Override
	public int getID() {
		return Game.PAUSE_MENU;
	}
	
	

}

package controller;

import org.newdawn.slick.SlickException;

import view.StatusBarView;
import model.StatusBar;

public class StatusBarController {

	private StatusBarView statusBarView;
	private InGameController inGameController;
	
	public StatusBarController(InGameController inGameController) throws SlickException {
		statusBarView = new StatusBarView();
		
	}

	public StatusBarView getStatusBarView() {
		return statusBarView;
	}
	
	
}

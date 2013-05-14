package controller;

import org.newdawn.slick.SlickException;

import view.StatusBarView;
import model.StatusBar;

public class StatusBarController {

	private StatusBar statusBar;
	private StatusBarView statusBarView;
	private InGameController inGameController;
	
	public StatusBarController(InGameController inGameController) throws SlickException {
		statusBar = new StatusBar();
		statusBarView = new StatusBarView(statusBar);
		
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public StatusBarView getStatusBarView() {
		return statusBarView;
	}
	
	
}

package controller;

import org.newdawn.slick.SlickException;

import view.StatusBarView;

public class StatusBarController {

	private final StatusBarView statusBarView;
	public StatusBarController() throws SlickException {
		statusBarView = new StatusBarView();
		
	}

	public StatusBarView getStatusBarView() {
		return statusBarView;
	}
	
	
}

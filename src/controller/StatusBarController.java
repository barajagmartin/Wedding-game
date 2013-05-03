package controller;

import view.StatusBarView;
import model.StatusBar;

public class StatusBarController {

	private StatusBar statusBar;
	private StatusBarView statusBarView;
	
	public StatusBarController() {
		statusBar = new StatusBar();
		statusBarView = new StatusBarView(statusBar);
		
	}
	
}

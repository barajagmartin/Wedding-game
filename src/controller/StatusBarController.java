package controller;

import org.newdawn.slick.SlickException;

import view.StatusBarView;
/**
 * The statusbar is shown beneath the world when you're playing. Here you can see you current lives and the time remaining
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class StatusBarController {

	private final StatusBarView statusBarView;
	public StatusBarController() throws SlickException {
		statusBarView = new StatusBarView();
		
	}

	public StatusBarView getStatusBarView() {
		return statusBarView;
	}
	
	
}

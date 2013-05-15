package view;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**All menuView's shall extend this class to get basic logic*/
public abstract class AbstractMenuView {
	/*Images for menus*/
	private Image background;
	private Image candyMonsterTitle;
	private Image startGameLabel;
	private Image highscoreLabel;
	private Image soundOnLabel;
	private Image soundOffLabel;
	private Image musicOnLabel;
	private Image musicOffLabel;
	private Image controlsLabel;
	private Image exitGameLabel;	
	private Image resumeLabel;
	private Image exitToMenuLabel;
	
	public AbstractMenuView() throws SlickException {
		background = new Image("pics/bluebg.png");
		candyMonsterTitle = new Image("pics/candy_monsters_orange.png");
		startGameLabel = new Image("pics/start_game.png");
		highscoreLabel = new Image("pics/highscore.png");
		soundOnLabel = new Image("pics/sound_on.png");
		soundOffLabel = new Image("pics/sound_off.png");
		musicOnLabel = new Image("pics/music_on.png");
		musicOffLabel = new Image("pics/music_off.png");
		controlsLabel = new Image("pics/controls.png");
		exitGameLabel = new Image("pics/exit_game.png");
		resumeLabel = new Image("pics/resume.png");
		exitToMenuLabel = new Image("pics/exit_to_menu.png");
	}

	public Image getBackground() {
		return this.background;
	}

	public Image getCandyMonsterTitle() {
		return this.candyMonsterTitle;
	}

	public Image getStartGameLabel() {
		return this.startGameLabel;
	}

	public Image getHighscoreLabel() {
		return this.highscoreLabel;
	}

	public Image getSoundOnLabel() {
		return this.soundOnLabel;
	}

	public Image getSoundOffLabel() {
		return this.soundOffLabel;
	}

	public Image getMusicOnLabel() {
		return this.musicOnLabel;
	}

	public Image getMusicOffLabel() {
		return this.musicOffLabel;
	}

	public Image getControlsLabel() {
		return this.controlsLabel;
	}

	public Image getExitGameLabel() {
		return this.exitGameLabel;
	}

	public Image getResumeLabel() {
		return this.resumeLabel;
	}

	public Image getExitToMenuLabel() {
		return this.exitToMenuLabel;
	}
	
}

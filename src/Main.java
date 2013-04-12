import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class Main {
	private static final String GAME_NAME = "Candy Monsters";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");
		AppGameContainer app;
		try {
			app = new AppGameContainer(new GameModel(GAME_NAME));
			app.setDisplayMode(800, 600, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}

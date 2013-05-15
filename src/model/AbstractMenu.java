package model;

/**All menu's shall extend this class to get basic menu logic */
public abstract class AbstractMenu {
	private static boolean isSoundOn = true;
	private static boolean isMusicOn = true;


	/**Move marker in if key is pressed down*/
	public abstract void markButtonDown();
	
	/**Move marker in if key is pressed up*/
	public abstract void markButtonUp();
	
	public void setSoundOn(boolean isSoundOn){
		AbstractMenu.isSoundOn = isSoundOn;
	}
	
	public boolean isSoundOn() {
		return isSoundOn;
	}
	
	public void setMusicOn(boolean isMusicOn){
		AbstractMenu.isMusicOn = isMusicOn;
	}
	
	public boolean isMusicOn() {
		return isMusicOn;
	}
}

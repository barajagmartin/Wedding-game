package model;

/**All menu's shall extend this class to get basic menu logic */
public abstract class AbstractMenu {
	private boolean isSoundOn;
	private boolean isMusicOn;
	
	public AbstractMenu() {
		isSoundOn = true;
		isMusicOn = true;
	}

	/**Move marker in if key is pressed down*/
	public abstract void markButtonDown();
	
	/**Move marker in if key is pressed up*/
	public abstract void markButtonUp();
	
	public void setSoundOn(boolean isSoundOn){
		this.isSoundOn = isSoundOn;
	}
	
	public boolean isSoundOn() {
		return isSoundOn;
	}
	
	public void setMusicOn(boolean isMusicOn){
		this.isMusicOn = isMusicOn;
	}
	
	public boolean isMusicOn() {
		return isMusicOn;
	}
}

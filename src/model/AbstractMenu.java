package model;

/**All menu's shall implement this class to get basic menu logic */
public abstract class AbstractMenu {
	private boolean isSoundOff;
	private boolean isMusicOff;
	
	public AbstractMenu() {
		isSoundOff = false;
		isMusicOff = false;
	}

	/**Move marker in if key is pressed down*/
	public abstract void markButtonDown();
	
	/**Move marker in if key is pressed up*/
	public abstract void markButtonUp();
	
	public void setIsSoundOff(boolean isSoundOff){
		this.isSoundOff = isSoundOff;
	}
	
	public boolean getIsSoundOff() {
		return isSoundOff;
	}
	
	public void setIsMusicOff(boolean isMusicOff){
		this.isMusicOff = isMusicOff;
	}
	
	public boolean getIsMusicOff() {
		return isMusicOff;
	}
}

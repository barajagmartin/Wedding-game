package model;

public class StartMenu implements IMenu {
	private int isMarked;
	public static final int STATE_ID = 0;
	
	public StartMenu(){
		isMarked = 0;
	}
	
	@Override
	public void markButtonDown() {
		isMarked = ++isMarked % 6;
	}

	@Override
	public void markButtonUp() {
		isMarked = (isMarked + 5) % 6; //add 5 to make positive (--isMarked + 6)
	}
	
	public int getIsMarked(){
		return isMarked;
	}

}

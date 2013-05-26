package model;

public class FixedPosition {
	private final Position pos;
	
	public FixedPosition(final int posX, final int posY) {
		pos = new Position(posX, posY);
	}

	public int getPosX() {
		return pos.getX();
	}

	public int getPosY() {
		return pos.getY();
	}
}
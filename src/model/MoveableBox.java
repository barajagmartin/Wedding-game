package model;

public class MoveableBox {
	public static final int HALF_WIDTH = 16;
	public static final int HALF_HEIGHT = 16;
	private Position pos;
	
	public MoveableBox(final int x, final int y) {
		this(new Position(x,y));
	}
	
	public MoveableBox(final Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
	
	public void setX(final int x) {
		this.pos.setX(x);
	}
	
	public void setY(final int y) {
		this.pos.setY(y);
	}
}
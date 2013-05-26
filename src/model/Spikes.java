package model;

public class Spikes {
	private Position pos;
	public static final int RADIUS = 15;

	public Spikes(final int x, final int y){
		this(new Position(x,y));
	}

	public Spikes(final Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}
}
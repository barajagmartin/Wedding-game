package model;

public class Spikes {
	private int x;
	private int y;
	public final int WIDTH;
	public final int HEIGHT;
	
	public Spikes(int x, int y){
		this.x = x;
		this.y = y;
		this.WIDTH = 50;
		this.HEIGHT = 20;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
}

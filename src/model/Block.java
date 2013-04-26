package model;

public class Block {
	private int posX;
	private int posY;
	private int width;
	private int height;

	
	public Block(final int posX, final int posY, final int width, final int height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}


	public int getPosX() {
		return posX;
	}


	public int getPosY() {
		return posY;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}

}

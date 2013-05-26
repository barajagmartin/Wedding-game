package model;

public class Player {
	private int score;
	private int life;

	public Player() {
		reset();
	}

	public int getScore() {
		return score;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void loseOneLife() {
		this.life--;
	}
	
	/**
	 * set the score at the end of the game, counting in how many lives the character has left.
	 * @param time , the time left on the level when cleared.
	 * @param candy , the number of items delivered.
	 * @param life , the number of lives the character has left when the game ends. 
	 */
	public void setScore(int time, int candy, int life) {
		this.score += time*candy + life*100;
	}
	
	/**
	 * set the score at the end of every level.
	 * @param time , the time left on the level when cleared.
	 * @param candy , the number of items delivered.
	 */
	public void setScore(int time, int candy) {
		this.score += time*candy;
	}

	public void reset() {
		life = 3;
		score = 0;
	}
}
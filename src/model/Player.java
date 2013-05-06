package model;


public class Player {
	private Character character;
	private int score;

	public Player(model.Character character) {
		this.character = character;
		this.score = 0;
	}

	public Character getCharacter() {
		return character;
	}

	public int getScore() {
		return score;
	}
	
	/**
	 * set the score at the end of the game, counting in how many lives the character has left.
	 * @param time , the time left on the level when cleared.
	 * @param candy , the number of items delivered.
	 * @param life , the number of lives the character has left when the game ends. 
	 */
	public void setScore(int time, int candy, int life) {
		this.score =+ time*candy + life*100;
	}
	
	/**
	 * set the score at the end of every level.
	 * @param time , the time left on the level when cleared.
	 * @param candy , the number of items delivered.
	 */
	public void setScore(int time, int candy) {
		this.score =+ time*candy;
	}

}

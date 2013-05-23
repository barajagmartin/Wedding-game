package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	public static final int START_MENU = 0;
	public static final int IN_GAME = 1;
	public static final int HIGHSCORE = 2;
	public static final int PAUSE_MENU = 3; 
	public static final int END_OF_LEVEL = 4;
	public static final int NEW_HIGHSCORE = 5;
	public static final int CONTROLS = 6;
	
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	private boolean isMusicOn;
	private boolean isSoundOn;
	private int[] scoreList;
	private String[] nameList;
	private File scoreFile;
	private File nameFile;
	private Scanner scoreScanner;
	private Scanner nameScanner;
	
	private InGame inGame;
	private StartMenu startMenu;
	
	public Game(InGame inGame) {
		this.scoreList = new int[10];
		this.nameList = new String[10];
		this.scoreFile = new File("savings/scoreList.txt");
		this.nameFile = new File("savings/nameList.txt");
		this.inGame = inGame;
		this.isMusicOn = true;
		this.isSoundOn = true;
		try {
			this.scoreScanner = new Scanner(scoreFile);
			this.nameScanner = new Scanner(nameFile);
			readScoreList();
			readNameList();
		} catch (IOException e) {
			System.out.println("something went wrong with reading the Lists");
			e.printStackTrace();
		}
	}
	

	public StartMenu getStartMenu() {
		return startMenu;
	}
	
	public InGame getInGame() {
		return inGame;
	}

	public int[] getScoreList() {
		return scoreList;
	}

	public String[] getNameList() {
		return nameList;
	}
	
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
	
	public void readScoreList () throws IOException {
		for (int i = 0; i < this.scoreList.length; i++) {
			scoreList[i] = scoreScanner.nextInt();
		}
	}
	
	public void readNameList () throws IOException {
		for (int i = 0; i < this.nameList.length; i++) {
			nameList[i] = nameScanner.nextLine();
		}
	}

	
	/**
	 * saves your score to the file if it is high enough
	 * @param newScore the new score you want to save
	 */
	public void saveScore (int newScore, String name) { 
		this.scoreList[9] = newScore;
		this.nameList[9] = name;
		for (int i = 8; i >= 0; i--) { 
			if (newScore > this.scoreList[i]) {
				this.scoreList[i+1] = this.scoreList[i];
				this.nameList[i+1] = this.nameList[i];
				this.scoreList[i] = newScore;
				this.nameList[i] = name;
				if (i == 0 || this.scoreList[i-1] > newScore) {
					break;
				}

			}
		}
		this.scoreFile.delete();
		this.nameFile.delete();
		this.scoreFile = new File("savings/scoreList.txt");
		this.nameFile = new File("savings/nameList.txt");
		BufferedWriter outputWriterS = null;
		BufferedWriter outputWriterN = null;
		try {
			outputWriterS = new BufferedWriter(new FileWriter("savings/scoreList.txt"));
			outputWriterN = new BufferedWriter(new FileWriter("savings/NameList.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int j = 0; j < 10; j++) {
			try {
				outputWriterS.write(Integer.toString(this.scoreList[j]));
				outputWriterS.newLine();
				outputWriterN.write(this.nameList[j]);
				outputWriterN.newLine();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			outputWriterS.flush();
			outputWriterS.close();
			outputWriterN.flush();
			outputWriterN.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
}

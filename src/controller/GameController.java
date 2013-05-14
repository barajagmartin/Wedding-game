package controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class GameController extends StateBasedGame {
	private StartMenuController startMenuController;
	private InGameController inGameController;
	private PauseController pauseController;
	private EndOfLevelController endOfLevelController;
	private HighScoreStateController highScoreStateController;
	private  int[] scoreList;
	private String[] nameList;
	private File scoreFile;
	private File nameFile;
	private Scanner scoreScanner;
	private Scanner nameScanner;
	
	public GameController(String name) {
		super(name);
		this.scoreList = new int[10];
		this.nameList = new String[10];
		this.scoreFile = new File("savings/scoreList.txt");
		this.nameFile = new File("savings/nameList.txt");
		try {
			this.scoreScanner = new Scanner(scoreFile);
			this.nameScanner = new Scanner(nameFile);
			readScoreList();
			readNameList();
		} catch (IOException e) {
			System.out.println("something went wrong with reading the Lists");
			e.printStackTrace();
		}
		this.startMenuController = new StartMenuController(this);
		this.highScoreStateController = new HighScoreStateController(this);
		this.inGameController = new InGameController(this);
		this.pauseController = new PauseController(this);
		this.endOfLevelController = new EndOfLevelController(this);
		this.addState(inGameController);
		this.addState(highScoreStateController);
		this.addState(pauseController);
		this.addState(endOfLevelController);
		this.addState(startMenuController);
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.enterState(startMenuController.getID());
	}
	
	public StartMenuController getStartMenuController(){
		return startMenuController;
	}
	
	public InGameController getInGameController(){
		return inGameController;
	}
	
	public PauseController getPauseController(){
		return pauseController;
	}

	public HighScoreStateController getHighScoreStateController() {
		return highScoreStateController;
	}

	public int[] getScoreList() {
		return scoreList;
	}

	public String[] getNameList() {
		return nameList;
	}

	public void readScoreList () throws IOException {
		for (int i = 0; i < this.scoreList.length; i++) {
			scoreList[i] = scoreScanner.nextInt();
		}
		System.out.println("ScoreList: " + Arrays.toString(scoreList));
	}
	
	public void readNameList () throws IOException {
		for (int i = 0; i < this.nameList.length; i++) {
			nameList[i] = nameScanner.nextLine();
		}
		System.out.println("NameList: " + Arrays.toString(nameList));
	}

	
	/**
	 * saves your score to the file if it is high enough
	 * @param newScore the new score you want to save
	 */
	public void tryToSaveScore (int newScore) {
		if (newScore > this.scoreList[9]) {
			this.scoreList[9] = newScore; //ändra: kolla detta innan anrop, börja loopen på 9!
			for (int i = 8; i >= 0; i--) { //alternativt läs in en spelares namn här!
				if (newScore > this.scoreList[i]) {
					this.scoreList[i+1] = this.scoreList[i];
					this.scoreList[i] = newScore;
					if (i == 0 || this.scoreList[i-1] > newScore) {
						break;
					}
				}
			}
			this.scoreFile.delete();
			this.scoreFile = new File("scoreList.txt");
			BufferedWriter outputWriter = null;
			try {
				outputWriter = new BufferedWriter(new FileWriter("scoreList.txt"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int j = 0; j < 10; j++) {
			    try {
					outputWriter.write(Integer.toString(this.scoreList[j]));
					outputWriter.newLine();  
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				outputWriter.flush();
				outputWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		}
		System.out.println("new scoreList: " + Arrays.toString(scoreList));
	}
}

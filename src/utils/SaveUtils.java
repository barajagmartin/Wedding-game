package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveUtils {
	private static int[] scoreList = new int[10];
	private static String[] nameList = new String[10];
	private static File scoreFile = new File("savings/scoreList.txt");
	private static File nameFile = new File("savings/nameList.txt");
	private static Scanner scoreScanner;
	private static Scanner nameScanner;
	
	@SuppressWarnings("null")
	public static void init() {
		
		try {
			scoreScanner = new Scanner(scoreFile);
			nameScanner = new Scanner(nameFile);
			readScoreList();
			readNameList();
		} catch (IOException e) {
			File savingsDir = new File("savings");
			savingsDir.mkdir();
			PrintWriter newScoreFile = null;
			PrintWriter newNameFile = null;
			try {
				scoreFile.createNewFile();
				nameFile.createNewFile();
			} catch (IOException e1) {
				System.exit(0);
			}
			try {
				newScoreFile = new PrintWriter(new FileWriter(scoreFile), true);
				newNameFile = new PrintWriter(new FileWriter(nameFile), true);
				for (int j = 0; j < 10; j++) {
					newScoreFile.println("0");
					newNameFile.println("");
				}
				init();
			} catch (IOException e1) {
				System.exit(0);
			}
			
		}
		
		
		
	}
	
	public static int[] getScoreList() {
		return scoreList;
	}

	public static String[] getNameList() {
		return nameList;
	}
	
	public static void readScoreList () throws IOException {
		for (int i = 0; i < scoreList.length; i++) {
			scoreList[i] = scoreScanner.nextInt();
		}
	}
	
	public static void readNameList () throws IOException {
		for (int i = 0; i < nameList.length; i++) {
			nameList[i] = nameScanner.nextLine();
		}
	}
	
	/**
	 * saves your score to the file if it is high enough
	 * @param newScore the new score you want to save
	 */
	public static void saveScore (int newScore, String name) { 
		scoreList[9] = newScore;
		nameList[9] = name;
		scoreFile = new File("savings/scoreList.txt");
		nameFile = new File("savings/nameList.txt");
		for (int i = 8; i >= 0; i--) { 
			if (newScore > scoreList[i]) {
				scoreList[i+1] = scoreList[i];
				nameList[i+1] = nameList[i];
				scoreList[i] = newScore;
				nameList[i] = name;
				if (i == 0 || scoreList[i-1] > newScore) {
					break;
				}

			}
		}
		scoreFile.delete();
		nameFile.delete();
		BufferedWriter outputWriterS = null;
		BufferedWriter outputWriterN = null;
		try {
			outputWriterS = new BufferedWriter(new FileWriter(scoreFile));
			outputWriterN = new BufferedWriter(new FileWriter(nameFile));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int j = 0; j < 10; j++) {
			try {
				outputWriterS.write(Integer.toString(scoreList[j]));
				outputWriterS.newLine();
				outputWriterN.write(nameList[j]);
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

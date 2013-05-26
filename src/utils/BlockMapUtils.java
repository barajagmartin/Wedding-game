package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlockMapUtils {

	private BlockMapUtils() {} 
	
	public static InputStream getTmxFile(int level, int version) {
		try {
			return new FileInputStream("levels/level" + String.valueOf(level) + "." + String.valueOf(version) +".tmx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null; //to satisfy compiler
	}
}
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlockMapUtils {

	private BlockMapUtils() {
		
	}
	public static InputStream getTmxFile(int level) {
		try {
			return new FileInputStream("pics/halfbig.tmx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null; //to satisfy compiler
	}

}

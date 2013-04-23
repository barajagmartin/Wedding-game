package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlockMapUtils {

	private BlockMapUtils() {
		
	}
	public static InputStream getTmxFile(int level) throws FileNotFoundException {
		return new FileInputStream("ny.tmx");
	}

}

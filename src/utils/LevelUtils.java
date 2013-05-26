package utils;

import java.io.FilenameFilter;
import java.io.File;

public class LevelUtils {
	/**
	 * Find files that are on the form levelx.y.tmx.
	 * 
	 * x is the level
	 * y is the level version
	 * @return the filenameFilter
	 */
	private static FilenameFilter findFiles(final int level) {
		final FilenameFilter filenameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.matches("level" + String.valueOf(level) + ".\\d.tmx");
			}
		};
		return filenameFilter;
	}
	
	public static int getNbrOfFiles(int level) {
		return new File("levels").listFiles(findFiles(level)).length;	
	}
}
package utils;

import view.WorldView;

public class WorldUtils {
	public static float SCALE = 25;
	
	public static float pixel2Meter(int px) {
		return px / SCALE;
	}
	
	public static int meter2Pixel(float meter) {
		return (int) (meter * SCALE);
	}
}

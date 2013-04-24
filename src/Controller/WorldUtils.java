package controller;

import view.WorldView;

public class WorldUtils {
	public static float pixel2Meter(int px) {
		return px / WorldView.SCALE;
	}
	
	public static int meter2Pixel(float meter) {
		return (int) (meter * WorldView.SCALE);
	}
}

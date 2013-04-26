package utils;

import java.util.ArrayList;

public class PositionUtils {
	private PositionUtils positionUtils;
	private ArrayList<Integer> candyMonster1X;
	private ArrayList<Integer> candyMonster1Y;
	private ArrayList<Integer> item1X;
	private ArrayList<Integer> item1Y;
	private ArrayList<Integer> spikes1X;
	private ArrayList<Integer> spikes1Y;
	
	
	private PositionUtils() {}
	
	public PositionUtils getInstance() {
		if (positionUtils != null) {
			return positionUtils;
		} else {
			return new PositionUtils();
		}
	}
	

	/**
	 * SEE PARAMETER DEFINITION!!
	 * @param x in pixels (not tile position)
	 * @param y in pixels (not tile position)
	 * @throws NoSuchLevelException 
	 */
	public void addCandyMonsterPosition(int level, int x, int y) throws NoSuchLevelException {
		if (level == 1) {
			candyMonster1X.add(x);
			candyMonster1Y.add(y);
		} else {
			throw new NoSuchLevelException();
		}
	}
	/**
	 * SEE PARAMETER DEFINITION!!
	 * @param x in pixels (not tile position)
	 * @param y in pixels (not tile position)
	 * @throws NoSuchLevelException 
	 */
	public void addItemPosition(int level, int x, int y) throws NoSuchLevelException {
		if (level == 1) {
			item1X.add(x);
			item1Y.add(y);
		} else {
			throw new NoSuchLevelException();
		}
	}
	
	/**
	 * SEE PARAMETER DEFINITION!!
	 * @param x in pixels (not tile position)
	 * @param y in pixels (not tile position)
	 * @throws NoSuchLevelException 
	 */
	public void addSpikePosition(int level, int x, int y) throws NoSuchLevelException {
		if (level == 1) {
			spikes1X.add(x);
			spikes1Y.add(y);
		} else {
			throw new NoSuchLevelException();
		}
	}
	
	public int getCandyMonsterX(int level, int candyNumber) throws IndexOutOfBoundsException, NoSuchLevelException {
		if (level == 1) {
			return candyMonster1X.get(candyNumber-1);
		} else {
			throw new NoSuchLevelException();
		}
	}
	
	public int getCandyMonsterY(int level, int candyNumber) throws IndexOutOfBoundsException, NoSuchLevelException {
		if (level == 1) {
			return candyMonster1X.get(candyNumber-1);
		} else {
			throw new NoSuchLevelException();
		}
	}
	
	public int getItemX(int level, int candyNumber) throws IndexOutOfBoundsException, NoSuchLevelException {
		if (level == 1) {
			return item1X.get(candyNumber-1);
		} else {
			throw new NoSuchLevelException();
		}
	}
	
	public int getItemY(int level, int candyNumber) throws IndexOutOfBoundsException, NoSuchLevelException {
		if (level == 1) {
			return item1Y.get(candyNumber-1);
		} else {
			throw new NoSuchLevelException();
		}
	}
	
	public ArrayList<Integer> getSpikesXList(int level) throws IndexOutOfBoundsException, NoSuchLevelException {
		if (level == 1) {
			return spikes1X;
		} else {
			throw new NoSuchLevelException();
		}
	}
	
	public ArrayList<Integer> getSpikesYList(int level) throws IndexOutOfBoundsException, NoSuchLevelException {
		if (level == 1) {
			return spikes1Y;
		} else {
			throw new NoSuchLevelException();
		}
	}
}
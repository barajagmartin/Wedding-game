package model;

import java.util.ArrayList;

public class BlockMap {	
	private ArrayList<FixedPosition> blockList;
	
	public BlockMap() {
		blockList = new ArrayList<FixedPosition>();		
	}

	public ArrayList<FixedPosition> getBlockList() {
		return blockList;
	}
}
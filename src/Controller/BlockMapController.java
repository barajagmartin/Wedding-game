package controller;

import java.io.FileNotFoundException;

import org.newdawn.slick.SlickException;

import view.BlockMapView;
import model.BlockMap;

public class BlockMapController {

	BlockMap blockMap;
	BlockMapView blockMapView;
	
	public BlockMapController() {
		blockMap = new BlockMap();
		blockMapView = new BlockMapView(blockMap, io.BlockMapUtils.getTmxFile(1));
	}
	
	public BlockMapView getBlockMapView() {
		return this.blockMapView;
	}
	

}

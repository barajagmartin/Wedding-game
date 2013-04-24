package controller;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import view.BlockMapView;
import model.BlockMap;

public class BlockMapController {

	BlockMap blockMap;
	BlockMapView blockMapView;
	
	public BlockMapController(TiledMap tiledMap) {
		blockMap = new BlockMap();
		blockMapView = new BlockMapView(blockMap, tiledMap);
	}
	
	public BlockMapView getBlockMapView() {
		return this.blockMapView;
	}
	

}

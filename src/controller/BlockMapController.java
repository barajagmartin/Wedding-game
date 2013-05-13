package controller;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import view.BlockMapView;
import model.BlockMap;

public class BlockMapController {
	private InGameController inGameController;
	private BlockMap solidGroundMap;
	private BlockMap iceMap;
	private BlockMap springMap;
	private BlockMap candyMonsterMap;
	private BlockMap spikesMap;
	private BlockMap itemMap;
	private BlockMap moveableBoxMap;
	private BlockMapView blockMapView;
	
	public BlockMapController(InGameController inGameController, TiledMap tiledMap) {
		this.inGameController = inGameController;
		solidGroundMap = new BlockMap();
		iceMap = new BlockMap();
		springMap = new BlockMap();
		candyMonsterMap = new BlockMap();
		spikesMap = new BlockMap();
		itemMap = new BlockMap();
		moveableBoxMap = new BlockMap();
		blockMapView = new BlockMapView(solidGroundMap, iceMap, springMap, candyMonsterMap,
				spikesMap, itemMap, moveableBoxMap, tiledMap, inGameController.getInGame());
	}
	
	public BlockMapView getBlockMapView() {
		return this.blockMapView;
	}

	public BlockMap getSolidGroundMap() {
		return solidGroundMap;
	}

	public BlockMap getCandyMonsterMap() {
		return candyMonsterMap;
	}

	public BlockMap getSpikesMap() {
		return spikesMap;
	}

	public BlockMap getItemMap() {
		return itemMap;
	}
	

}

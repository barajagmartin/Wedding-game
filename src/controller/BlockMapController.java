package controller;

import org.newdawn.slick.tiled.TiledMap;

import view.BlockMapView;
import model.BlockMap;

public class BlockMapController {
	private BlockMap solidGroundMap;
	private BlockMap iceMap;
	private BlockMap springMap;
	private BlockMap iceSpringMap;
	private BlockMap candyMonsterMap;
	private BlockMap spikesMap;
	private BlockMap itemMap;
	private BlockMap moveableBoxMap;
	private BlockMapView blockMapView;
	
	public BlockMapController(InGameController inGameController, TiledMap tiledMap) {
		solidGroundMap = new BlockMap();
		iceMap = new BlockMap();
		springMap = new BlockMap();
		iceSpringMap = new BlockMap();
		candyMonsterMap = new BlockMap();
		spikesMap = new BlockMap();
		itemMap = new BlockMap();
		moveableBoxMap = new BlockMap();
		blockMapView = new BlockMapView(solidGroundMap, iceMap, springMap, iceSpringMap, candyMonsterMap,
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

package controller;

import org.newdawn.slick.tiled.TiledMap;

import view.BlockMapView;
import model.BlockMap;

/**
 * Blockmap is essentially a list of fixed positions. Blocks that creates the map.
 * @author Josefin
 *
 */
public class BlockMapController {
	private final BlockMap candyMonsterMap;
	private final BlockMap spikesMap;
	private final BlockMap itemMap;
	private final BlockMapView blockMapView;
	
	public BlockMapController(final InGameController inGameController, final TiledMap tiledMap) {
		final BlockMap solidGroundMap = new BlockMap();
		final BlockMap iceMap = new BlockMap();
		final BlockMap springMap = new BlockMap();
		final BlockMap iceSpringMap = new BlockMap();
		candyMonsterMap = new BlockMap();
		spikesMap = new BlockMap();
		itemMap = new BlockMap();
		final BlockMap moveableBoxMap = new BlockMap();
		blockMapView = new BlockMapView(solidGroundMap, iceMap, springMap, iceSpringMap, candyMonsterMap,
				spikesMap, itemMap, moveableBoxMap, tiledMap, inGameController.getInGame());
	}
	
	public BlockMapView getBlockMapView() {
		return this.blockMapView;
	}

	public BlockMap getCandyMonsterMap() {
		return this.candyMonsterMap;
	}

	public BlockMap getSpikesMap() {
		return this.spikesMap;
	}

	public BlockMap getItemMap() {
		return this.itemMap;
	}
}

package view;

import junit.framework.Test;
import model.Block;
import model.BlockMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class BlockMapView {
	private BlockMap blockMap;
	private TiledMap map;
	private int mapWidth;
	private int mapHeight;
	
	public BlockMapView(BlockMap blockMap, String ref) throws SlickException {
		this.blockMap = blockMap;
		map = new TiledMap("test.tmx");
		mapWidth = map.getWidth() * map.getTileWidth();
		mapHeight = map.getHeight() * map.getTileHeight();

		//loop through map and place out Blocks
		for (int x = 1; x <= map.getWidth(); x++) {
			for (int y = 1; y <= map.getHeight(); y++) {
				//if the tile is solid ground, place a static object
				int id = map.getTileId(x, y, map.getLayerIndex("two"));
				String s = map.getTileProperty(id, "blocked", "true");
				if ("true".equals(s)) {
					blockMap.getBlockList().add(new Block(x*map.getTileWidth(),
							y*map.getTileHeight(),map.getTileWidth(), map.getTileHeight()));
				}
			}
		}
	}
}
//TODO ska delas upp i View och Controller
package view;

import java.io.InputStream;

import model.Block;
import model.BlockMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class BlockMapView {
	private BlockMap blockMap;
	private TiledMap map;
	private int mapWidth;
	private int mapHeight;
	
	public BlockMapView(BlockMap blockMap, InputStream inputStream) throws SlickException {
		this.blockMap = blockMap;
		map = new TiledMap(inputStream);
		mapWidth = map.getWidth() * map.getTileWidth();
		mapHeight = map.getHeight() * map.getTileHeight();

		//loop through map and place out Blocks
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
			int firstgid = map.getTileId(x, y, map.getLayerIndex("two"));
				String tileProperty = map.getTileProperty(firstgid, "blocked", "false"); //If there were no value it would return false
				if (tileProperty.equals("true")) { //if the tile is solid ground, then add its properties to a Block-list
					blockMap.getBlockList().add(new Block(x * map.getTileWidth(),
							y * map.getTileHeight(),map.getTileWidth(), map.getTileHeight()));
				}
			}
		}
	}

	public BlockMap getBlockMap() {
		return blockMap;
	}
}
//TODO ska delas upp i View och Controller
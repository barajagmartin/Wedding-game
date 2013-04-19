package view;

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
		map = new TiledMap(ref);
		mapWidth = map.getWidth() * map.getTileWidth();
		mapHeight = map.getHeight() * map.getTileHeight();

		//loop through map and place out Blocks
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
				//if the tile is solid ground, place a static object
			}
		}
	}
}
//TODO ska delas upp i View och Controller
package Model;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class BlockMapModel {
	
	private TiledMap map;
	private int mapWidth;
	private int mapHeight;
	private ArrayList<BlockModel> blockList;
	
	public BlockMapModel(String ref) throws SlickException {
		map = new TiledMap(ref);
		mapWidth = map.getWidth() * map.getTileWidth();
		mapHeight = map.getHeight() * map.getTileHeight();
		blockList = new ArrayList<BlockModel>();
		
		//loop through map and place out Blocks
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
				//if the tile is solid ground, place a static object
			}
		}
		
	}

}

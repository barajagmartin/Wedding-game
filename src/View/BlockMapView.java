package view;

import java.io.InputStream;

import model.Block;
import model.BlockMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class BlockMapView {
	private BlockMap blockMap;
	private TiledMap tiledMap;
	private int mapWidth;
	private int mapHeight;
	
	public BlockMapView(BlockMap blockMap, InputStream inputStream) {
		this.blockMap = blockMap;
		try {
			tiledMap = new TiledMap(inputStream);
		} catch (SlickException e) {
			System.out.println("steg1");
			e.printStackTrace();
			System.out.println("steg2");
		}
		mapWidth = tiledMap.getWidth() * tiledMap.getTileWidth();
		mapHeight = tiledMap.getHeight() * tiledMap.getTileHeight();

		//loop through map and place out Blocks
		for (int x = 0; x < tiledMap.getWidth(); x++) {
			for (int y = 0; y < tiledMap.getHeight(); y++) {
			int firstgid = tiledMap.getTileId(x, y, tiledMap.getLayerIndex("two"));
				String tileProperty = tiledMap.getTileProperty(firstgid, "blocked", "false"); //If there were no value it would return false
				if (tileProperty.equals("true")) { //if the tile is solid ground, then add its properties to a Block-list
					blockMap.getBlockList().add(new Block(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight(),tiledMap.getTileWidth(), tiledMap.getTileHeight()));
				}
			}
		}
	}

	public BlockMap getBlockMap() {
		return blockMap;
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}
}
//TODO ska delas upp i View och Controller
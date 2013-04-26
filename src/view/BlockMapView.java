package view;

import java.io.InputStream;

import model.Block;
import model.BlockMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class BlockMapView {
	private BlockMap solidGroundMap;
	private TiledMap tiledMap;
	
	public BlockMapView(BlockMap solidGroundMap, TiledMap tiledMap) {
		this.solidGroundMap = solidGroundMap;
		this.tiledMap = tiledMap;

		//loop through map and place out Blocks
		for (int x = 0; x < tiledMap.getWidth(); x++) {
			for (int y = 0; y < tiledMap.getHeight(); y++) {
			int firstgid = tiledMap.getTileId(x, y, tiledMap.getLayerIndex("layer"));
				String tileProperty = tiledMap.getTileProperty(firstgid, "blocked", "false"); //If there were no value it would return false
				if (tileProperty.equals("true")) { //if the tile is solid ground, then add its properties to a Block-list
					solidGroundMap.getBlockList().add(new Block(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				}
			}
		}
	}

	public BlockMap getSolidGroundMap() {
		return solidGroundMap;
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}
}
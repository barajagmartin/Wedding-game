package view;

import java.util.ArrayList;
import org.newdawn.slick.tiled.TiledMap;

import model.FixedPosition;
import model.BlockMap;
import model.CandyMonster;
import model.InGame;
import model.Item;

public class BlockMapView {
	private BlockMap solidGroundMap;
	private BlockMap iceMap;
	private BlockMap springMap;
	private BlockMap iceSpringMap;
	private BlockMap candyMonsterMap;
	private BlockMap spikesMap;
	private BlockMap itemMap;
	private BlockMap moveableBoxMap;
	private TiledMap tiledMap;
	private FixedPosition startingPos;
	private ArrayList<Integer> candyMonsterNbrMap;
	private ArrayList<Integer> itemNbrMap;

	public BlockMapView(BlockMap solidGroundMap, BlockMap iceMap, BlockMap springMap, BlockMap iceSpringMap, BlockMap candyMonsterMap,
			BlockMap spikesMap, BlockMap itemMap, BlockMap moveableBoxMap, TiledMap tiledMap, InGame inGame) {
		this.solidGroundMap = solidGroundMap;
		this.iceMap = iceMap;
		this.springMap = springMap;
		this.iceSpringMap = iceSpringMap;
		this.candyMonsterMap = candyMonsterMap;
		this.spikesMap = spikesMap;
		this.itemMap = itemMap;
		this.moveableBoxMap = moveableBoxMap;
		this.tiledMap = tiledMap;
		candyMonsterNbrMap = new ArrayList<Integer>();
		itemNbrMap = new ArrayList<Integer>();


		//loop through map and save positions of tiles
		for (int x = 0; x < tiledMap.getWidth(); x++) {
			for (int y = 0; y < tiledMap.getHeight(); y++) {
				int solidsID = tiledMap.getTileId(x, y, tiledMap.getLayerIndex("solids"));
				int positionID = tiledMap.getTileId(x, y, tiledMap.getLayerIndex("position"));
				String layerTileProperty = tiledMap.getTileProperty(solidsID, "property", "nothing"); //If there were no value it would return false
				String positionTileProperty = tiledMap.getTileProperty(positionID, "property", "nothing"); //If there were no value it would return false
				if (layerTileProperty.equals("solidGround")) { //if the tile is solid ground, then add its properties to a Block-list
					solidGroundMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				} else if (layerTileProperty.equals("ice")) {
					iceMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				} else if (layerTileProperty.equals("spring")) {
					springMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				} else if (layerTileProperty.equals("iceSpring")) {
					iceSpringMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));	
				} else if (positionTileProperty.equals("candyMonster")) {
					candyMonsterMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth()+(tiledMap.getTileWidth()/2 - CandyMonster.WIDTH/2),
							y * tiledMap.getTileHeight()+(tiledMap.getTileHeight() - CandyMonster.HEIGHT)));
					String candyNumber = tiledMap.getTileProperty(positionID, "candyNumber", "1");
					candyMonsterNbrMap.add(Integer.valueOf(candyNumber));
				} else if (positionTileProperty.equals("spikes")) {
					spikesMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth() + (tiledMap.getTileWidth()/2),
							y * tiledMap.getTileHeight() + (tiledMap.getTileHeight()/2)));
				} else if (positionTileProperty.equals("item")) {
					itemMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth() + (tiledMap.getTileWidth()/2 - Item.WIDTH/2),
							y * tiledMap.getTileHeight() + (tiledMap.getTileHeight() - Item.HEIGHT)));
					String candyNumber = tiledMap.getTileProperty(positionID, "candyNumber", "1");
					itemNbrMap.add(Integer.valueOf(candyNumber));
				} else if (positionTileProperty.equals("player")) {
					this.startingPos = new FixedPosition(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight());
				} else if (positionTileProperty.equals("moveableBox")) {
					moveableBoxMap.getBlockList().add(new FixedPosition(x * tiledMap.getTileWidth()+(tiledMap.getTileWidth()/2 - CandyMonster.WIDTH/2),
							y * tiledMap.getTileHeight()+(tiledMap.getTileHeight() - CandyMonster.HEIGHT)));
				}
			}
		}
		int dataID = tiledMap.getTileId(0, 0, tiledMap.getLayerIndex("data"));
		String timeTileProperty = tiledMap.getTileProperty(dataID, "time", "60");
		inGame.setLevelTime(Float.valueOf(timeTileProperty));
		inGame.setTime(Float.valueOf(timeTileProperty));
	}

	public BlockMap getSolidGroundMap() {
		return solidGroundMap;
	}

	public BlockMap getIceMap() {
		return iceMap;
	}

	public BlockMap getSpringMap() {
		return springMap;
	}

	public BlockMap getIceSpringMap() {
		return iceSpringMap;
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

	public BlockMap getMoveableBoxMap() {
		return moveableBoxMap;
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}

	public FixedPosition getStartingPos() {
		return startingPos;
	}

	public ArrayList<Integer> getCandyMonsterNbrMap() {
		return candyMonsterNbrMap;
	}

	public ArrayList<Integer> getItemNbrMap() {
		return itemNbrMap;
	}
}
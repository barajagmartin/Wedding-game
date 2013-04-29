package view;

import java.util.ArrayList;

import model.Block;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import utils.WorldUtils;

public class WorldView {
	private model.World world;
	private CharacterView characterView;
	private Vec2 gravity;
	boolean doSleep;
	private World jBox2DWorld;
	private Body characterBody;
	private Body groundBody;
	private Body leftWallBody;
	private Body rightWallBody;
	private Body roofBody;
	private ArrayList<Body> tileBodyList;
	private BlockMapView blockMapView;
	private ItemView[] itemViewList;
	private CandyMonsterView[] candyMonsterViewList;
	private SpikesView[] spikesViewList;
	
	private float worldWidthMeter;
	private float worldHeightMeter;
	
	public WorldView(model.World world, CharacterView characterView, BlockMapView blockMapView,
			ItemView[] itemViews, CandyMonsterView[] candyMonsterViews, SpikesView[] spikes) {
		this.world = world;
		worldWidthMeter = WorldUtils.pixel2Meter(world.getWorldWidthPx());
		worldHeightMeter = WorldUtils.pixel2Meter(world.getWorldHeightPx());
		this.characterView = characterView;
		this.blockMapView = blockMapView;
		this.itemViewList = itemViews;
		this.candyMonsterViewList = candyMonsterViews;
		this.spikesViewList = spikes;
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);
		

		//ground
		addSolidGround(new Vec2(0, worldHeightMeter), new Vec2(worldWidthMeter, WorldUtils.pixel2Meter(2)), groundBody); //(x, y, width, height)
		//left wall
		addSolidGround(new Vec2(0, 0), new Vec2(WorldUtils.pixel2Meter(2), worldHeightMeter), leftWallBody);
		//right wall
		addSolidGround(new Vec2(worldWidthMeter, 0), new Vec2(WorldUtils.pixel2Meter(2), worldHeightMeter), rightWallBody);
		//roof
		addSolidGround(new Vec2(0, 0), new Vec2(worldWidthMeter, WorldUtils.pixel2Meter(2)), roofBody);

		for (Block block : this.blockMapView.getSolidGroundMap().getBlockList()) {
			Body temp = null;
			
			addSolidGround(new Vec2(WorldUtils.pixel2Meter(block.getPosX() + this.blockMapView.getTiledMap().getTileWidth()/2),
					WorldUtils.pixel2Meter(block.getPosY() + this.blockMapView.getTiledMap().getTileWidth()/2)),
					new Vec2(WorldUtils.pixel2Meter(this.blockMapView.getTiledMap().getTileWidth()/2),
							WorldUtils.pixel2Meter(this.blockMapView.getTiledMap().getTileHeight()/2)), temp);
			//tileBodyList.add(temp);
		}
		
		characterBody = jBox2DWorld.createBody(characterView.getBodyDef());
		characterBody.createFixture(characterView.getFixtureDef());
		characterBody.m_mass = 35f;
	}
	
	public CharacterView getCharacterView() {
		return characterView;
	}
	
	public BlockMapView getBlockMapView() {
		return blockMapView;
	}

	public ItemView[] getItemViewList() {
		return itemViewList;
	}

	public CandyMonsterView[] getCandyMonsterViewList() {
		return candyMonsterViewList;
	}

	public SpikesView[] getSpikesViewList() {
		return spikesViewList;
	}

	public World getJBox2DWorld() {
		return jBox2DWorld;
	}
	
	public Body getCharacterBody() {
		return characterBody;
	}
	
	public Body getGroundBody() {
		return groundBody;
	}

	
	
	/**
	 * Add solid ground to prevent the character from moving outside of the window.
	 */
	private void addSolidGround(final Vec2 pos, final Vec2 size, Body body) {
		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(size.x, size.y);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = polygonShape;
		fixtureDef.friction = 0.7f;
		fixtureDef.density = 1f;
		fixtureDef.restitution = 0f;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(pos);
		bodyDef.type = BodyType.STATIC;
		bodyDef.fixedRotation = true;
		
		body = jBox2DWorld.createBody(bodyDef);
		body.createFixture(fixtureDef);
	}
	
}

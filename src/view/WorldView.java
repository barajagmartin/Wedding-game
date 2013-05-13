package view;

import java.util.ArrayList;

import model.FixedPosition;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.WeldJointDef;

import utils.WorldUtils;

public class WorldView {
	public static final float NORMAL_FRICTION = 0.7f;
	public static final float ICE_FRICTION = 0f;
	public static final float NO_BOUNCE_RESTITUTION = 0f;
	public static final float BOUNCE_RESTITUTION = 1f;
	
	
	private model.World world;
	private Vec2 gravity;
	boolean doSleep;
	private World jBox2DWorld;
	private Body groundBody;
	private Body leftWallBody;
	private Body rightWallBody;
	private Body roofBody;
	private BlockMapView blockMapView;
	private ArrayList<ItemView> itemViewList;
	private ArrayList<CandyMonsterView> candyMonsterViewList;

	
	private float worldWidthMeter;
	private float worldHeightMeter;
	
	public WorldView(model.World world, BlockMapView blockMapView, 
			ArrayList<ItemView> itemViewList, 
			ArrayList<CandyMonsterView> candyMonsterViewList) {
		this.world = world;
		worldWidthMeter = WorldUtils.pixel2Meter(world.getWorldWidthPx());
		worldHeightMeter = WorldUtils.pixel2Meter(world.getWorldHeightPx());
		this.blockMapView = blockMapView;
		this.itemViewList = itemViewList;
		this.candyMonsterViewList = candyMonsterViewList;
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);
		

		//ground
		addSolidGround(new Vec2(0, worldHeightMeter), new Vec2(worldWidthMeter, WorldUtils.pixel2Meter(2)),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION); //(x, y, width, height)
		//left wall
		addSolidGround(new Vec2(0, 0), new Vec2(WorldUtils.pixel2Meter(2), worldHeightMeter),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION);
		//right wall
		addSolidGround(new Vec2(worldWidthMeter, 0), new Vec2(WorldUtils.pixel2Meter(2), worldHeightMeter),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION);
		//roof
		addSolidGround(new Vec2(0, 0), new Vec2(worldWidthMeter, WorldUtils.pixel2Meter(2)),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION);

		//Create normal ground
		addIterativeSolids(this.blockMapView.getSolidGroundMap().getBlockList(), NORMAL_FRICTION, NO_BOUNCE_RESTITUTION);		
		
		//Create ice
		addIterativeSolids(this.blockMapView.getIceMap().getBlockList(), ICE_FRICTION, NO_BOUNCE_RESTITUTION);		
		
		//Create springs
		addIterativeSolids(this.blockMapView.getSpringMap().getBlockList(), NORMAL_FRICTION, BOUNCE_RESTITUTION);
		
		//Create clouds
		addIterativeSolids(this.blockMapView.getIceSpringMap().getBlockList(), ICE_FRICTION, BOUNCE_RESTITUTION);
		
	}
	
	public World getjBox2DWorld() {
		return jBox2DWorld;
	}

	public BlockMapView getBlockMapView() {
		return blockMapView;
	}

	public ArrayList<ItemView> getItemViewList() {
		return itemViewList;
	}

	public ArrayList<CandyMonsterView> getCandyMonsterViewList() {
		return candyMonsterViewList;
	}


	public Body getGroundBody() {
		return groundBody;
	}	
	
	/**
	 * Add solid ground to prevent the character from moving outside of the window.
	 */
	private void addSolidGround(final Vec2 pos, final Vec2 size, final float friction, final float restitution) {
		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(size.x, size.y);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = polygonShape;
		fixtureDef.friction = friction;
		fixtureDef.density = 1f;
		fixtureDef.restitution = restitution;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(pos);
		bodyDef.type = BodyType.STATIC;
		bodyDef.fixedRotation = true;
		
		Body body = jBox2DWorld.createBody(bodyDef);
		body.createFixture(fixtureDef);
	}
	
	private void addIterativeSolids(ArrayList<FixedPosition> blockList, final float friction, final float restitution) {
		for (FixedPosition block : blockList) {
			addSolidGround(new Vec2(WorldUtils.pixel2Meter(block.getPosX() + this.blockMapView.getTiledMap().getTileWidth()/2),
					WorldUtils.pixel2Meter(block.getPosY() + this.blockMapView.getTiledMap().getTileWidth()/2)),
					new Vec2(WorldUtils.pixel2Meter(this.blockMapView.getTiledMap().getTileWidth()/2),
							WorldUtils.pixel2Meter(this.blockMapView.getTiledMap().getTileHeight()/2)),
							friction, restitution);
		}
	}
}

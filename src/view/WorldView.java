package view;

import java.util.ArrayList;

import model.Block;

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

public class WorldView implements ContactListener {
	private model.World world;
	private CharacterView characterView;
	private Vec2 gravity;
	boolean doSleep;
	private World jBox2DWorld;
	private Body characterBody;
	private Body feetBody;
	private WeldJointDef weldJointDef;
	private Body groundBody;
	private Body leftWallBody;
	private Body rightWallBody;
	private Body roofBody;
	private ArrayList<Body> tileBodyList;
	private BlockMapView blockMapView;
	private ArrayList<ItemView> itemViewList;
	private ArrayList<CandyMonsterView> candyMonsterViewList;
	private ArrayList<SpikesView> spikesViewList;
	
	private float worldWidthMeter;
	private float worldHeightMeter;
	
	public WorldView(model.World world, CharacterView characterView, BlockMapView blockMapView, 
			ArrayList<ItemView> itemViewList, 
			ArrayList<CandyMonsterView> candyMonsterViewList, 
			ArrayList<SpikesView> spikesViewList) {
		this.world = world;
		worldWidthMeter = WorldUtils.pixel2Meter(world.getWorldWidthPx());
		worldHeightMeter = WorldUtils.pixel2Meter(world.getWorldHeightPx());
		this.characterView = characterView;
		this.blockMapView = blockMapView;
		this.itemViewList = itemViewList;
		this.candyMonsterViewList = candyMonsterViewList;
		this.spikesViewList = spikesViewList;
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
		feetBody = jBox2DWorld.createBody(characterView.getFeetBodyDef());
		feetBody.createFixture(characterView.getFeetFixtureDef());
		feetBody.m_mass = 0.00000001f;
		feetBody.setAwake(false);
		weldJointDef = new WeldJointDef();
		
		weldJointDef.collideConnected = false;
		weldJointDef.localAnchorA.set(0,10);
		weldJointDef.localAnchorB.set(0,-10);
		weldJointDef.initialize(characterBody, feetBody, characterBody.getPosition());
		
		jBox2DWorld.createJoint(weldJointDef);
		jBox2DWorld.setContactListener(this);
	}
	
	public CharacterView getCharacterView() {
		return characterView;
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

	public ArrayList<SpikesView> getSpikesViewList() {
		return spikesViewList;
	}

	public World getJBox2DWorld() {
		return jBox2DWorld;
	}
	
	public Body getCharacterBody() {
		return characterBody;
	}
	
	public Body getFeetBody() {
		return feetBody;
	}

	public WeldJointDef getWeldJointDef() {
		return weldJointDef;
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

	@Override
	public void beginContact(Contact contact) {
		System.out.println();
		System.out.println("x: " + characterBody.getPosition().x + "\ty: " + characterBody.getPosition().x);
		System.out.println("x: " + feetBody.getPosition().x + "\ty: " + feetBody.getPosition().x);
	}

	@Override
	public void endContact(Contact contact) {
		System.out.println("Nuddar inte mark!");
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}
	
}

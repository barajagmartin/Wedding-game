package view;

import java.util.ArrayList;

import model.Block;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Filter;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import controller.WorldUtils;

import sun.font.CreatedFontTracker;

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
	public static int SCALE = 25;
	private float worldWidthMeter;
	private float worldHeightMeter;
	
	public WorldView(model.World world, CharacterView characterView, BlockMapView blockMapView) {
		this.world = world;
		worldWidthMeter = WorldUtils.pixel2Meter(world.getWorldWidthPx());
		worldHeightMeter = WorldUtils.pixel2Meter(world.getWorldHeightPx());
		this.characterView = characterView;
		this.blockMapView = blockMapView;
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);
		// TODO måste använda f på något sätt.
		//ground
<<<<<<< HEAD
<<<<<<< HEAD
		addSolidGround(0, 500, 800, 0); //(x, y, width, height)
		//left wall
		addSolidGround(0, 0, 0, 500);
		//right wall
		addSolidGround(800, 0, 0, 600);
		//roof
		addSolidGround(0, 0, 800, 1);
=======
		addSolidGround(0, world.getWorldHeight(), world.getWorldWidth(), 1, groundBody); //(x, y, width, height)
=======
		addSolidGround(new Vec2(0, worldHeightMeter), new Vec2(worldWidthMeter, WorldUtils.pixel2Meter(1)), groundBody); //(x, y, width, height)
>>>>>>> 9f91b5a8a4129bc0847bee302d109bb67437d970
		//left wall
		addSolidGround(new Vec2(WorldUtils.pixel2Meter(-1), 0), new Vec2(WorldUtils.pixel2Meter(1), worldHeightMeter), leftWallBody);
		//right wall
		addSolidGround(new Vec2(worldWidthMeter, 0), new Vec2(WorldUtils.pixel2Meter(1), worldHeightMeter), rightWallBody);
		//roof
		addSolidGround(new Vec2(WorldUtils.pixel2Meter(-1), WorldUtils.pixel2Meter(-1)), new Vec2(worldHeightMeter, WorldUtils.pixel2Meter(1)), roofBody);
		
		for (Block block : this.blockMapView.getBlockMap().getBlockList()) {
			Body temp = null;
			addSolidGround(new Vec2(WorldUtils.pixel2Meter((int)block.getPosX()), WorldUtils.pixel2Meter((int)block.getPosY())),
					new Vec2(WorldUtils.pixel2Meter((int)block.getWidth()), WorldUtils.pixel2Meter((int)block.getHeight())), temp);
			//tileBodyList.add(temp);
		}
		
>>>>>>> aa2c4d2f1bc4ae7b4235799b5ed3d6f3d9db2c07
		characterBody = jBox2DWorld.createBody(characterView.getBodyDef());
		characterBody.createFixture(characterView.getFixtureDef());
		characterBody.m_mass = 50f;
	}
	
	public CharacterView getCharacterView() {
		return characterView;
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

	public BlockMapView getBlockMapView() {
		return blockMapView;
	}
	
	/**
	 * Add solid ground to prevent the character from moving outside of the window.
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	private void addSolidGround(final float posX, final float posY, final float width, final float height) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(posX, posY);
		bodyDef.type = BodyType.STATIC;
		bodyDef.fixedRotation = true;
		
=======
	private void addSolidGround(final float posX, final float posY, final float width, final float height, Body body) {
>>>>>>> aa2c4d2f1bc4ae7b4235799b5ed3d6f3d9db2c07
=======
	private void addSolidGround(final Vec2 pos, final Vec2 size, Body body) {
>>>>>>> 9f91b5a8a4129bc0847bee302d109bb67437d970
		PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(size.x, size.y);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = polygonShape;
		fixtureDef.friction = 0.4f;
		fixtureDef.density = 1f;
<<<<<<< HEAD
<<<<<<< HEAD

		groundBody = jBox2DWorld.createBody(bodyDef);
		groundBody.createFixture(fixtureDef);
=======
=======
		fixtureDef.restitution = 0f;
>>>>>>> 9f91b5a8a4129bc0847bee302d109bb67437d970
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(pos);
		bodyDef.type = BodyType.STATIC;
		bodyDef.fixedRotation = true;
		
		body = jBox2DWorld.createBody(bodyDef);
		body.createFixture(fixtureDef);
>>>>>>> aa2c4d2f1bc4ae7b4235799b5ed3d6f3d9db2c07
	}
	
}

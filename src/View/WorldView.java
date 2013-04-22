package view;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Filter;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;


public class WorldView {
	private model.World world;
	private CharacterView characterView;
	private Vec2 gravity;
	boolean doSleep;
	private World jBox2DWorld;
	private Body characterBody;
	private Body groundBody;
	
	public WorldView(model.World world, CharacterView characterView) {
		this.world = world;
		this.characterView = characterView;
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);
		addSolidGround(0, world.getWorldHeight(), world.getWorldWidth(), 1);
		addSide(-50,0);
		addSide(world.getWorldWidth(), 0);
		characterBody = jBox2DWorld.createBody(characterView.getBodyDef());
		characterBody.createFixture(characterView.getFixtureDef());
		characterBody.m_mass = 1000f;
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
	
	
	
	
	
	/**
	 * Make ground at the bottom of the screen to prevent character from falling down.
	 */
	private void addSolidGround(final float posX, final float posY, final float width, final float height) {
		PolygonShape ps = new PolygonShape();
		ps.setAsBox(width, height);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = ps;
		fixtureDef.friction = 0.1f;
		fixtureDef.density = 1f;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(posX, posY);
		bodyDef.type = BodyType.STATIC;
		bodyDef.fixedRotation = true;
		
		groundBody = jBox2DWorld.createBody(bodyDef);
		groundBody.createFixture(fixtureDef);
	}
	
	/**
	 * Make walls at the specified position of the screen.
	 * @param posX where to place it
	 * @param posY where to place it
	 */
	private void addSide (float posX, float posY) {
		PolygonShape ps = new PolygonShape();
		ps.setAsBox(1, world.getWorldHeight());
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = ps;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.3f;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(posX, posY);
		bodyDef.type = BodyType.STATIC; // eller?
		
		jBox2DWorld.createBody(bodyDef).createFixture(fixtureDef);
	}	
}

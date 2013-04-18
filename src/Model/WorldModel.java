package Model;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;


public class WorldModel {
	private CharacterModel character;
	private Vec2 gravity;
	boolean doSleep;
	private World jBox2DWorld;
	private int worldWidth;
	private int worldHeight;
	private Body body;
	
	//Kommer ha spikes, Items och CandyMonster
	
	
	public WorldModel(CharacterModel character, int worldWidth, int worldHeight) {
		this.character = character;
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		addGround();
		addSide(0,worldHeight);
		addSide(worldWidth, worldHeight);
		jBox2DWorld.createBody(character.getBodyDef());
		body.createFixture(character.getFixtureDef());
	}
	
	public CharacterModel getCharacter(){
		return character;
	}
	
	public World getJBox2DWorld() {
		return jBox2DWorld;
	}
	
	/**
	 * Make ground at the bottom of the screen to prevent character from falling down.
	 */
	private void addGround() {
		PolygonShape ps = new PolygonShape();
		ps.setAsBox(worldWidth, worldHeight);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = ps;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position = gravity;
		
		jBox2DWorld.createBody(bodyDef).createFixture(fixtureDef);
	}
	
	/**
	 * Make walls at the specified position of the screen.
	 * @param posX where to place it
	 * @param posY where to place it
	 */
	private void addSide (float posX, float posY) {
		PolygonShape ps = new PolygonShape();
		ps.setAsBox(1, worldHeight);
		
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
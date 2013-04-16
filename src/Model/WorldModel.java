package Model;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;


public class WorldModel {
	private CharacterModel character;
	private Vec2 gravity;
	boolean doSleep;
	private World jBox2DWorld;
	private int worldWidth;
	private int worldHeight;
	
	//Kommer ha spikes, Items och CandyMonster
	
	
	public WorldModel(CharacterModel character, int worldWidth, int worldHeight) {
		this.character = character;
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
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
	public void addGround() {
		PolygonShape ps = new PolygonShape();
		ps.setAsBox(worldWidth, worldHeight);
		
		FixtureDef fd = new FixtureDef();
		fd.shape = ps;
		
		BodyDef bd = new BodyDef();
		bd.position = gravity;
		
		jBox2DWorld.createBody(bd).createFixture(fd);
	}
}
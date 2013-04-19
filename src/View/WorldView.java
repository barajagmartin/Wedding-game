package view;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;


public class WorldView {
	private model.World world;
	private Vec2 gravity;
	boolean doSleep;
	private World jBox2DWorld;
	private Body characterBody;
	private Body groundBody;
	
	public WorldView() {
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);
		addGround();
		//addSide(0,worldHeight);
		//addSide(worldWidth, worldHeight);
		characterBody = jBox2DWorld.createBody(world.getCharacter().getBodyDef());
		characterBody.createFixture(world.getCharacter().getFixtureDef());
	}
	public World getJBox2DWorld() {
		return jBox2DWorld;
	}
	
	/**
	 * Make ground at the bottom of the screen to prevent character from falling down.
	 */
	private void addGround() {
		PolygonShape ps = new PolygonShape();
		ps.setAsBox(100,10);
		
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = ps;
		fixtureDef.density = 1.0f;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position = new Vec2(0.0f, -9.82f);
		bodyDef.type = BodyType.STATIC;
		
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
		ps.setAsBox(100, worldHeight);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = ps;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.3f;
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(posX, posY);
		bodyDef.type = BodyType.STATIC; // eller?
		
		jBox2DWorld.createBody(bodyDef).createFixture(fixtureDef);
	}

	public void updateSlickShape() {
		character.setX(characterBody.getPosition().x);
		character.setY(characterBody.getPosition().y);
	}
	public void moveBodyRight(){
		//add force to move right
	      this.characterBody.applyLinearImpulse(new Vec2(10, 0), characterBody.getPosition());
	}
	
	public void moveBodyLeft(){
		//add force to move left
		 this.characterBody.applyLinearImpulse(new Vec2(-10, 0), characterBody.getPosition());
	}
	
}
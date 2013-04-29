package controller;

import org.jbox2d.common.Vec2;

import utils.WorldUtils;
import view.WorldView;

import model.World;

public class WorldController {
	private InGameController inGameController;
	private model.World world;
	private WorldView worldView;
	
	public WorldController(InGameController inGameController) {
		this.inGameController = inGameController;
		this.world = new World(inGameController.getCharacterController().getCharacter(), 800, 600);
		this.worldView = new WorldView(world, inGameController.getCharacterController().getCharacterView(),
				inGameController.getBlockMapController().getBlockMapView());
	}
	
	public model.World getWorld() {
		return world;
	}

	public WorldView getWorldView() {
		return worldView;
	}

	public void moveBodyRight() {
		//add force to move right - maxSpeed right
		if(worldView.getCharacterBody().m_linearVelocity.x <= 2.5){
	      worldView.getCharacterBody().applyLinearImpulse(new Vec2(5f, 0), worldView.getCharacterBody().getPosition());
		}
	}
	
	public void moveBodyLeft() {
		//add force to move left - maxSpeed left
		if(worldView.getCharacterBody().m_linearVelocity.x >= -2.5){
			worldView.getCharacterBody().applyLinearImpulse(new Vec2(-5f, 0), worldView.getCharacterBody().getPosition()); 
		}
	}

	
	public void jumpBody(){
		final float impulse = worldView.getCharacterBody().getMass();
		worldView.getCharacterBody().applyLinearImpulse(new Vec2(0,-impulse), worldView.getCharacterBody().getWorldCenter());
	}
	
	public void updateSlickShape() {
		worldView.getCharacterView().getSlickShape().setX(WorldUtils.meter2Pixel(worldView.getCharacterBody().getPosition().x) - worldView.getCharacterView().getCharacter().RADIUS);
		worldView.getCharacterView().getSlickShape().setY(WorldUtils.meter2Pixel(worldView.getCharacterBody().getPosition().y) - worldView.getCharacterView().getCharacter().RADIUS);
	}
	
}

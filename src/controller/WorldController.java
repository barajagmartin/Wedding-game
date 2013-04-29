package controller;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;

import utils.WorldUtils;
import view.CandyMonsterView;
import view.ItemView;
import view.SpikesView;
import view.WorldView;

import model.CandyMonster;
import model.Item;
import model.World;

public class WorldController {
	private InGameController inGameController;
	private ArrayList<ItemView> itemViewList;
	private ArrayList<CandyMonsterView> candyMonsterViewList;
	private ArrayList<SpikesView> spikesViewList;
	private model.World world;
	private WorldView worldView;
	
	public WorldController(InGameController inGameController) {
		this.inGameController = inGameController;
		itemViewList = new ArrayList<ItemView>();
		candyMonsterViewList = new ArrayList<CandyMonsterView>();
		spikesViewList = new ArrayList<SpikesView>();
		
		for (ItemController itemController : inGameController.getItemController()) {
			itemViewList.add(itemController.getItemView());
		}
		for (CandyMonsterController candyMonsterController : inGameController.getCandyMonsterController()) {
			candyMonsterViewList.add(candyMonsterController.getCandyMonsterView());
		}
		for (SpikesController spikesController : inGameController.getSpikesController()) {
			spikesViewList.add(spikesController.getSpikesView());
		}
		
		
		this.world = new World(inGameController.getCharacterController().getCharacter(), 800, 600);
		this.worldView = new WorldView(world, inGameController.getCharacterController().getCharacterView(),
				inGameController.getBlockMapController().getBlockMapView(),
				itemViewList,
				candyMonsterViewList,
				spikesViewList);
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

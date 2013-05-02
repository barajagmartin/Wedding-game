package controller;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;

import utils.WorldUtils;
import view.CandyMonsterView;
import view.CharacterView;
import view.ItemView;
import view.SpikesView;
import view.WorldView;

import model.CandyMonster;
import model.Character;
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
		
		
		this.world = new World(1250, 700);
		this.worldView = new WorldView(world, inGameController.getBlockMapController().getBlockMapView(),
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

	public ArrayList<ItemView> getItemViewList() {
		return itemViewList;
	}

	public void moveBodyRight() {
		//add force to move right - maxSpeed right
		if(inGameController.getCharacterController().getCharacterView().getCharacterBody().m_linearVelocity.x <= 2.5){
			inGameController.getCharacterController().getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(5f, 0),
					inGameController.getCharacterController().getCharacterView().getCharacterBody().getPosition());
		}
	}
	
	public void moveBodyLeft() {
		//add force to move left - maxSpeed left
		if(inGameController.getCharacterController().getCharacterView().getCharacterBody().m_linearVelocity.x >= -2.5){
			inGameController.getCharacterController().getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(-5f, 0),
					inGameController.getCharacterController().getCharacterView().getCharacterBody().getPosition()); 
		}
	}

	
	public void jumpBody(){
		final float impulse = inGameController.getCharacterController().getCharacterView().getCharacterBody().getMass();
		inGameController.getCharacterController().getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(0,-impulse),
				inGameController.getCharacterController().getCharacterView().getCharacterBody().getWorldCenter());
	}
	
	public void updateSlickShape() {
		inGameController.getCharacterController().getCharacterView().getSlickShape().setX(WorldUtils.meter2Pixel(
				inGameController.getCharacterController().getCharacterView().getCharacterBody().getPosition().x) -
				inGameController.getCharacterController().getCharacter().RADIUS);
		inGameController.getCharacterController().getCharacterView().getSlickShape().setY(WorldUtils.meter2Pixel(
				inGameController.getCharacterController().getCharacterView().getCharacterBody().getPosition().y) -
				inGameController.getCharacterController().getCharacter().RADIUS);
	}
	
	public void updateItemShape(ArrayList<ItemView> itemList, CharacterView characterView){
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItem().isPickedUp()) {
				itemList.get(i).getShape().setX(characterView.getSlickShape().getX() + Character.RADIUS);
				itemList.get(i).getShape().setY(characterView.getSlickShape().getY() + Character.RADIUS);
			}
		}
	}
	
}

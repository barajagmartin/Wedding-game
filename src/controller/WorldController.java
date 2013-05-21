package controller;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;

import utils.WorldBodyFactory;
import utils.WorldObjects;
import utils.WorldUtils;
import view.CandyMonsterView;
import view.CharacterView;
import view.ItemView;
import view.MoveableBoxView;
import view.SpikesView;
import view.WorldView;

import model.CandyMonster;
import model.Character;
import model.Game;
import model.Item;
import model.MoveableBox;
import model.Spikes;
import model.World;

public class WorldController {
	private InGameController inGameController;
	private ArrayList<MoveableBox> moveableBoxes;
	private ArrayList<CandyMonster> candyMonsters;
	private ArrayList<Item> items;
	private ArrayList<Spikes> spikes;
	private ArrayList<MoveableBoxView> moveableBoxViewList;
	private ArrayList<CandyMonsterView> candyMonsterViewList;
	private ArrayList<ItemView> itemViewList;
	private ArrayList<SpikesView> spikesViewList;
	private model.World world;
	private WorldView worldView;
	
	
	public WorldController(InGameController inGameController, CharacterView characterView) {
		this.inGameController = inGameController;
		candyMonsters = new ArrayList<CandyMonster>();
		items = new ArrayList<Item>();
		moveableBoxViewList = new ArrayList<MoveableBoxView>();
		candyMonsterViewList = new ArrayList<CandyMonsterView>();
		itemViewList = new ArrayList<ItemView>();
		spikesViewList = new ArrayList<SpikesView>();
		
		for (MoveableBoxController moveableBoxController : inGameController.getMoveableBoxControllers()) { //FIXME
			moveableBoxes.add(moveableBoxController.getMoveableBox());
			moveableBoxViewList.add(moveableBoxController.getMoveableBoxView());
		}
		
		for (CandyMonsterController candyMonsterController : inGameController.getCandyMonsterController()) { //FIXME
			candyMonsters.add(candyMonsterController.getCandyMonster());
			candyMonsterViewList.add(candyMonsterController.getCandyMonsterView());
		}
		
		for (ItemController itemController : inGameController.getItemController()) { //FIXME
			items.add(itemController.getItem());
			itemViewList.add(itemController.getItemView());
		}
		
		for (SpikesController spikesController : inGameController.getSpikesController()) { //FIXME
			spikes.add(spikesController.getSpikes());
			spikesViewList.add(spikesController.getSpikesView());
		}
		
		this.world = new World(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, characterView.getCharacter(),
				moveableBoxes, candyMonsters, items, spikes);
		this.worldView = new WorldView(world, characterView,
				inGameController.getBlockMapController().getBlockMapView(), itemViewList,
				candyMonsterViewList);
		
		//create bodies into the jBox2DWorld
		characterView.setCharacterBody(WorldBodyFactory.createBody(WorldObjects.CHARACTER,
				worldView.getjBox2DWorld(), characterView.getCharacter().getPos()));
		
		for (MoveableBoxView moveableBoxView : moveableBoxViewList) {
			moveableBoxView.setBoxBody(WorldBodyFactory.createBody(WorldObjects.MOVEABLE_BOX,
					worldView.getjBox2DWorld(), moveableBoxView.getMoveableBox().getPos()));
		}
		
		for (SpikesView spikesView : spikesViewList) {
			spikesView.setBody(WorldBodyFactory.createBody(WorldObjects.SPIKES_SENSOR,
					worldView.getjBox2DWorld(), spikesView.getSpikes().getPos()));
		}
		for (SpikesController spikesController : inGameController.getSpikesController()) { //FIXME
			worldView.getjBox2DWorld().setContactListener(spikesController);
		}
			
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
		if(inGameController.getInGameView().getCharacterView().getCharacterBody().m_linearVelocity.x <= 3){
			inGameController.getInGameView().getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(5f, 0),
					inGameController.getInGameView().getCharacterView().getCharacterBody().getPosition());
		}
	}
	
	public void moveBodyLeft() {
		//add force to move left - maxSpeed left
		if(inGameController.getInGameView().getCharacterView().getCharacterBody().m_linearVelocity.x >= -3){
			inGameController.getInGameView().getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(-5f, 0),
					inGameController.getInGameView().getCharacterView().getCharacterBody().getPosition()); 
		}
	}

	
	public void jumpBody(){
		final float impulse = inGameController.getInGameView().getCharacterView().getCharacterBody().getMass()+70;
		inGameController.getInGameView().getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(0,-impulse),
				inGameController.getInGameView().getCharacterView().getCharacterBody().getWorldCenter());
	}
	
	public void updateSlickShape() {
		inGameController.getInGameView().getCharacterView().getSlickShape().setX(world.getCharacter().getX());
		inGameController.getInGameView().getCharacterView().getSlickShape().setY(world.getCharacter().getY());
	}
	
	public void updateItemPosition(ArrayList<ItemView> itemList, CharacterView characterView){
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItem().isPickedUp()) {
				itemList.get(i).getShape().setX(characterView.getSlickShape().getX() + Character.RADIUS); 
				itemList.get(i).getShape().setY(characterView.getSlickShape().getY() + Character.RADIUS);
				itemList.get(i).getItem().setX((int)characterView.getSlickShape().getX() + Character.RADIUS);
				itemList.get(i).getItem().setY((int)characterView.getSlickShape().getY() + Character.RADIUS);
			}
		}
	}
	
}

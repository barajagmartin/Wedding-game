package controller;

import java.util.ArrayList;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.contacts.Contact;

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

public class WorldController implements ContactListener {
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
	
	
	public WorldController(InGameController inGameController, CharacterView characterView,
			ArrayList<MoveableBoxView> moveableBoxViewList,
			ArrayList<CandyMonsterView> candyMonsterViewList,
			ArrayList<ItemView> itemViewList,
			ArrayList<SpikesView> spikesViewList) {
		this.inGameController = inGameController;
		moveableBoxes = new ArrayList<MoveableBox>();
		candyMonsters = new ArrayList<CandyMonster>();
		items = new ArrayList<Item>();
		spikes = new ArrayList<Spikes>();
		this.moveableBoxViewList = moveableBoxViewList;;
		this.candyMonsterViewList = candyMonsterViewList;
		this.itemViewList = itemViewList;
		this.spikesViewList = spikesViewList;;
		
		for (MoveableBoxView moveableBoxView : moveableBoxViewList) {
			moveableBoxes.add(moveableBoxView.getMoveableBox());
		}
		
		for (CandyMonsterView candyMonsterView : candyMonsterViewList) {
			candyMonsters.add(candyMonsterView.getCandyMonster());
		}
		
		for (ItemView itemView : itemViewList) {
			items.add(itemView.getItem());
		}
		
		for (int i = 0; i < spikesViewList.size(); i++) {
			spikes.add(spikesViewList.get(i).getSpikes());
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
		
		for (int i = 0; i < spikesViewList.size(); i++) {
			spikesViewList.get(i).setBody(WorldBodyFactory.createBody(WorldObjects.SPIKES_SENSOR,
					worldView.getjBox2DWorld(), spikesViewList.get(i).getSpikes().getPos()));
		}
		worldView.getjBox2DWorld().setContactListener(this);
			
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
		if(worldView.getCharacterView().getCharacterBody().m_linearVelocity.x <= 3){
			worldView.getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(5f, 0),
					worldView.getCharacterView().getCharacterBody().getPosition());
		}
	}
	
	public void moveBodyLeft() {
		//add force to move left - maxSpeed left
		if(worldView.getCharacterView().getCharacterBody().m_linearVelocity.x >= -3){
			worldView.getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(-5f, 0),
					worldView.getCharacterView().getCharacterBody().getPosition()); 
		}
	}

	
	public void jumpBody(){
		final float impulse = worldView.getCharacterView().getCharacterBody().getMass()+70;
		worldView.getCharacterView().getCharacterBody().applyLinearImpulse(new Vec2(0,-impulse),
				worldView.getCharacterView().getCharacterBody().getWorldCenter());
	}
	
	public void updateCharacterSlickShape() {
		worldView.getCharacterView().getSlickShape().setX(world.getCharacter().getX());
		worldView.getCharacterView().getSlickShape().setY(world.getCharacter().getY());
	}
	
	public void updateItemSlickShapePosition(ArrayList<ItemView> itemViewList, CharacterView characterView){
		for (int i = 0; i < itemViewList.size(); i++) {
			if (itemViewList.get(i).getItem().isPickedUp()) {
				itemViewList.get(i).getShape().setX(itemViewList.get(i).getItem().getX()); 
				itemViewList.get(i).getShape().setY(itemViewList.get(i).getItem().getY());
			}
		}
	}
	
	@Override
	public void beginContact(Contact contact) {
		Fixture fixtA = contact.getFixtureA();
		Fixture fixtB = contact.getFixtureB();
		if(fixtA.getUserData() != null && fixtB.getUserData() != null) {
			if((fixtA.getUserData().equals("spikes") && fixtB.getUserData().equals("player") ||
					fixtA.getUserData().equals("player") && fixtB.getUserData().equals("spikes")) && 
					world.getCharacter().getTimeSinceHit() > 1) {
				world.getCharacter().setOnSpikes(true);
			}
		}
	}

	@Override
	public void endContact(Contact contact) {
		Fixture fixtA = contact.getFixtureA();
		Fixture fixtB = contact.getFixtureB();
		if(fixtA.getUserData() != null && fixtB.getUserData() != null) {
			if(fixtA.getUserData().equals("spikes") && fixtB.getUserData().equals("player") ||
					fixtA.getUserData().equals("player") && fixtB.getUserData().equals("spikes")) {
				world.getCharacter().setOnSpikes(false);
			}
		}
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {}	
}

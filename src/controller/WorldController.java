package controller;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.contacts.Contact;

import utils.WorldBodyFactory;
import utils.WorldObjects;
import view.CandyMonsterView;
import view.CharacterView;
import view.ItemView;
import view.MoveableBoxView;
import view.SpikesView;
import view.WorldView;

import model.CandyMonster;
import model.Game;
import model.Item;
import model.MoveableBox;
import model.Spikes;
import model.World;

/**
 * The world is the area where the character, items, candymonster are located, the actual level or map.
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class WorldController implements ContactListener {
	private List<MoveableBox> moveableBoxes;
	private List<CandyMonster> candyMonsters;
	private List<Item> items;
	private List<Spikes> spikes;
	private List<ItemView> itemViewList;
	private model.World world;
	private WorldView worldView;
	
	
	public WorldController(InGameController inGameController, CharacterView characterView,
			List<MoveableBoxView> moveableBoxViewList,
			List<CandyMonsterView> candyMonsterViewList,
			List<ItemView> itemViewList,
			List<SpikesView> spikesViewList) {
		moveableBoxes = new ArrayList<MoveableBox>();
		candyMonsters = new ArrayList<CandyMonster>();
		items = new ArrayList<Item>();
		spikes = new ArrayList<Spikes>();
		this.itemViewList = itemViewList;
		
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

	public List<ItemView> getItemViewList() {
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
		worldView.getCharacterView().getSlickShape().setX(world.getCharacter().getPos().getX());
		worldView.getCharacterView().getSlickShape().setY(world.getCharacter().getPos().getY());
	}
	
	public void updateItemSlickShapePosition(List<ItemView> list, CharacterView characterView){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItem().isPickedUp()) {
				list.get(i).getShape().setX(list.get(i).getItem().getPos().getX()); 
				list.get(i).getShape().setY(list.get(i).getItem().getPos().getY());
			}
		}
	}
	
	@Override
	public void beginContact(Contact contact) {
		final Fixture fixtA = contact.getFixtureA();
		final Fixture fixtB = contact.getFixtureB();
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
		final Fixture fixtA = contact.getFixtureA();
		final Fixture fixtB = contact.getFixtureB();
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

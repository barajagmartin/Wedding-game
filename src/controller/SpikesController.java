package controller;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

import model.Spikes;
import view.CharacterView;
import view.SpikesView;

public class SpikesController implements ContactListener {
	
	private Spikes spikes;
	private SpikesView spikesView;
	private InGameController inGameController;

	public SpikesController(InGameController inGameController, int index){
		this.inGameController = inGameController;
		this.spikes = new Spikes(inGameController.getBlockMapController().getSpikesMap().getBlockList().get(index).getPosX(), 
								inGameController.getBlockMapController().getSpikesMap().getBlockList().get(index).getPosY());
		this.spikesView = new SpikesView(this.spikes, inGameController.getWorldController().getWorldView());
	}

	public Spikes getSpikes() {
		return spikes;
	}

	public SpikesView getSpikesView() {
		return spikesView;
	}

	@Override
	public void beginContact(Contact contact) {
		System.out.println("contact");
		if(inGameController.getCharacterController().getCharacter().getTimeSinceHit() > 1) {
			inGameController.getCharacterController().getCharacter().loseOneLife();
			this.inGameController.getCharacterController().getCharacter().setTimeSinceHit(0);
		}
		
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}
	
}

package controller;

import org.newdawn.slick.SlickException;

import model.Spikes;
import view.SpikesView;

public class SpikesController {
	
	private Spikes spikes;
	private SpikesView spikesView;
	public SpikesController(InGameController inGameController, int index) throws SlickException{
		this.spikes = new Spikes(inGameController.getBlockMapController().getSpikesMap().getBlockList().get(index).getPosX(), 
								inGameController.getBlockMapController().getSpikesMap().getBlockList().get(index).getPosY());
		this.spikesView = new SpikesView(this.spikes);
	}

	public Spikes getSpikes() {
		return spikes;
	}

	public SpikesView getSpikesView() {
		return spikesView;
	}	
}

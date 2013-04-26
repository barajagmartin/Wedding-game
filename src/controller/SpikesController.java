package controller;

import model.Spikes;
import view.SpikesView;

public class SpikesController {
	
	private Spikes spikes;
	private SpikesView spikesView;
	private InGameController inGameController;

	public SpikesController(int x, int y, InGameController inGameController){
		this.inGameController = inGameController;
		this.spikes = new Spikes(x, y);
		this.spikesView = new SpikesView(this.spikes);
	}

	public Spikes getSpikes() {
		return spikes;
	}

	public SpikesView getSpikesView() {
		return spikesView;
	}
}

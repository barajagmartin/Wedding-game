package controller;

import model.Spikes;
import view.SpikesView;

public class SpikesController {
	
	private Spikes spikes;
	private SpikesView spikesView;

	public SpikesController(int x, int y){
		this.spikes = new Spikes(x, y);
		this.spikesView = new SpikesView(this.spikes);
	}
}

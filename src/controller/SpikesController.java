package controller;

import org.newdawn.slick.SlickException;

import model.Spikes;
import view.SpikesView;

/**
 * This class represent the spikes that can hurt the character in the game.
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class SpikesController {
	
	private final Spikes spikes;
	private final SpikesView spikesView;
	public SpikesController(final InGameController inGameController, final int index) throws SlickException{
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

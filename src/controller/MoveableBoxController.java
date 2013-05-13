package controller;

import org.newdawn.slick.SlickException;

import view.MoveableBoxView;
import model.FixedPosition;
import model.MoveableBox;

public class MoveableBoxController {
	private InGameController inGameController;
	private MoveableBox moveableBox;
	private MoveableBoxView moveableBoxView;
	
	public MoveableBoxController(InGameController inGameController, FixedPosition pos) throws SlickException {
		this.inGameController = inGameController; 
		moveableBox = new MoveableBox(pos.getPosX(), pos.getPosY());
		moveableBoxView = new MoveableBoxView(moveableBox, inGameController.getWorldController().getWorldView());
	}

	public MoveableBox getMoveableBox() {
		return moveableBox;
	}

	public MoveableBoxView getMoveableBoxView() {
		return moveableBoxView;
	}
}

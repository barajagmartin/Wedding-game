package controller;

import org.newdawn.slick.SlickException;

import view.MoveableBoxView;
import model.FixedPosition;
import model.MoveableBox;

public class MoveableBoxController {
	private MoveableBox moveableBox;
	private MoveableBoxView moveableBoxView;
	
	public MoveableBoxController(FixedPosition pos) throws SlickException {
		moveableBox = new MoveableBox(pos.getPosX(), pos.getPosY());
		moveableBoxView = new MoveableBoxView(moveableBox);
	}

	public MoveableBox getMoveableBox() {
		return moveableBox;
	}

	public MoveableBoxView getMoveableBoxView() {
		return moveableBoxView;
	}
}

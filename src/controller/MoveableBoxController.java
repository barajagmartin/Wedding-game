package controller;

import org.newdawn.slick.SlickException;

import view.MoveableBoxView;
import model.FixedPosition;
import model.MoveableBox;
/**
 * This class represent the boxes in the game that the character can move around
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class MoveableBoxController {
	private final MoveableBox moveableBox;
	private final MoveableBoxView moveableBoxView;
	
	public MoveableBoxController(final FixedPosition pos) throws SlickException {
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

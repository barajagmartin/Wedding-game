package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import utils.WorldBodyFactory;
import utils.WorldObjects;

import model.MoveableBox;

public class MoveableBoxView {
	private MoveableBox moveableBox;
	private Body boxBody;
	private Image image;
	
	public MoveableBoxView(MoveableBox moveableBox, WorldView worldView) throws SlickException {
		this.moveableBox = moveableBox;
		boxBody = WorldBodyFactory.createBody(WorldObjects.MOVEABLE_BOX, worldView.getjBox2DWorld(), moveableBox.getPos());
		image = new Image("pics/moveableBox.png");
	}

	public MoveableBox getMoveableBox() {
		return moveableBox;
	}

	public Body getBoxBody() {
		return boxBody;
	}

	public Image getImage() {
		return image;
	}
}
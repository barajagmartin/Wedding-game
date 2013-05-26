package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import model.MoveableBox;

public class MoveableBoxView {
	private MoveableBox moveableBox;
	private Body boxBody;
	private Image image;
	
	public MoveableBoxView(MoveableBox moveableBox) throws SlickException {
		this.moveableBox = moveableBox;
		image = new Image("pics/moveableBox.png");
	}

	public MoveableBox getMoveableBox() {
		return moveableBox;
	}
	
	public void setBoxBody(Body boxBody) {
		this.boxBody = boxBody;
	}
	public Body getBoxBody() {
		return boxBody;
	}

	public Image getImage() {
		return image;
	}
}
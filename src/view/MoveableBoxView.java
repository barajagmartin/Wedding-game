package view;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import model.MoveableBox;
/**
 * 
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class MoveableBoxView {
	final private MoveableBox moveableBox;
	private Body boxBody;
	final private Image image;
	
	public MoveableBoxView(final MoveableBox moveableBox) throws SlickException {
		this.moveableBox = moveableBox;
		image = new Image("pics/moveableBox.png");
	}

	public MoveableBox getMoveableBox() {
		return moveableBox;
	}
	
	public void setBoxBody(final Body boxBody) {
		this.boxBody = boxBody;
	}
	public Body getBoxBody() {
		return boxBody;
	}

	public Image getImage() {
		return image;
	}
}
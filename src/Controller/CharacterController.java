package Controller;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import Model.CharacterModel;

public class CharacterController {
	private CharacterModel character;
	//determines how fast the character will move
	private float speed = 0.4f;
	private float posX;
	private float posY;
	
	public CharacterController(Model.CharacterModel character){
		this.character = character;
	}
		
	//check which key is pressed
	public void keyPressedUpdate(GameContainer gc, int delta){
		Input input = gc.getInput();
		posX = character.getX();
		posY = character.getY();
		
		if(input.isKeyDown(Input.KEY_UP)){
			posY -= speed * delta;
			character.setY(posY);
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			posY += speed * delta;
			character.setY(posY);
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			posX += speed * delta;
			character.setX(posX);
			character.setColor(Color.blue);
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			posX -= speed * delta;
			character.setX(posX);
			character.setColor(Color.green);
		}
	}
}

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
	/*Default keyvalues*/
	private int keyRight = Input.KEY_RIGHT;
	private int keyLeft = Input.KEY_LEFT;
	private int keyDown = Input.KEY_DOWN;
	private int keyUp = Input.KEY_UP;
	
	public CharacterController(Model.CharacterModel character){
		this.character = character;
	}
	/*Getters for keypresses*/
	public int getKeyRight(){
		return keyRight;
	}
	
	public int getKeyLeft(){
		return keyLeft;
	}
	
	public int getKeyUp(){
		return keyUp;
	}
	
	public int getKeyDown(){
		return keyDown;
	}
	
	/*Setters for keypresses*/
	public void setKeyRight(int keyRight){
		this.keyRight = keyRight;
	}
	
	public void setKeyLeft(int keyLeft){
		this.keyLeft = keyLeft;
	}
	
	public void setKeyUp(int keyUp){
		this.keyUp = keyUp;
	}
	
	public void setKeyDown(int keyDown){
		this.keyDown = keyDown;
	}
	
	/*Check the key pressed matches the right key*/
	
	public boolean isControllerRight(int key){
		return this.keyRight == key;
	}
	
	public boolean isControllerLeft(int key){
		return this.keyLeft == key;
	}
	
	public boolean isControllerUp(int key){
		return this.keyUp == key;
	}
	
	public boolean isControllerDown(int key){
		return this.keyUp == key;
	}
		
	//check which key is pressed
	public void keyPressedUpdate(GameContainer gc, int delta){
		posX = character.getX();
		posY = character.getY();
		
		if(isControllerRight(Input.ANY_CONTROLLER)){
			posX += speed * delta;
			character.setX(posX);
			character.setColor(Color.blue);
		}
		if(isControllerLeft(Input.ANY_CONTROLLER)){
			posX -= speed * delta;
			character.setX(posX);
			character.setColor(Color.green);
		}
		if(isControllerDown(Input.ANY_CONTROLLER)){
			//plocka upp ett item
		}
		if(isControllerUp(Input.ANY_CONTROLLER)){
			posY -= speed * delta;
			character.setY(posY);
		}

	}
}

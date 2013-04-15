package Model;
import org.newdawn.slick.geom.Rectangle;


public class CharacterModel {
	private float x, y;
	private int life;
	private org.newdawn.slick.geom.Shape slickShape;
	private org.jbox2d.collision.shapes.Shape jBox2DShape;
	
	public CharacterModel(float x, float y){
		this.x=x;
		this.y=y;
		this.life=3;
		this.slickShape= new Rectangle(x, y, 50, 50);
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public int getLife(){
		return this.life;
	}
	
	public org.newdawn.slick.geom.Shape getShape(){
		return this.slickShape;
	}
	
}




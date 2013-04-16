package Model;
import org.jbox2d.dynamics.BodyDef;
import org.newdawn.slick.geom.Rectangle;


public class CharacterModel {
	private float x, y;
	private int life;
	private org.newdawn.slick.geom.Shape slickShape;
	private org.jbox2d.collision.shapes.Shape jBox2DShape;
	private BodyDef bd;
	
	public CharacterModel(float x, float y){
		this.x=x;
		this.y=y;
		this.life=3;
		this.slickShape= new Rectangle(this.x, this.y, 50, 50);
		bd = new BodyDef();
		bd.position.set(50,50);
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public void setX(float x){
		this.x=x;
		slickShape.setX(x);
	}
	
	public void setY(float y){
		this.y=y;
		slickShape.setY(y);
	}
	
	public int getLife(){
		return this.life;
	}
	
	public void loseOneLife() {
		this.life--;
	}
	
	public org.newdawn.slick.geom.Shape getShape(){
		return this.slickShape;
	}
	
}




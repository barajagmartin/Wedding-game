package Model;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;


public class CharacterModel {
	private float x, y;
	private int life;
	private org.newdawn.slick.geom.Shape slickShape;
	private org.jbox2d.collision.shapes.PolygonShape jBox2DRectangle;
	private BodyDef bodyDef;
	private Color color;
	
	public CharacterModel(float x, float y){
		this.x=x;
		this.y=y;
		this.life=3;
		this.slickShape= new Rectangle(this.x, this.y, 50, 60); //x, y, width, height
		this.color = Color.blue;
		bodyDef = new BodyDef();
		bodyDef.position.set(this.x,this.y);
		bodyDef.type = BodyType.DYNAMIC;
		this.jBox2DRectangle = new PolygonShape(); 
		this.jBox2DRectangle.setAsBox(50, 60); 
		bodyDef.fixedRotation = true;
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = this.jBox2DRectangle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.3f;       
		fixtureDef.restitution = 0.5f;
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
	
	public org.jbox2d.collision.shapes.PolygonShape getjBox2DRectangle() {
		return jBox2DRectangle;
	}

	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}	
}




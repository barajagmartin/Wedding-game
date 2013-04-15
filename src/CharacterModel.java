import org.newdawn.slick.geom.Rectangle;


public class CharacterModel {
	private float x, y;
	private int life;
	private org.newdawn.slick.geom.Shape slickShape;
	private org.jbox2d.collision.shapes.Shape jBox2DShape;
<<<<<<< HEAD
}
=======

	
	
	public CharacterModel(float x, float y){
		this.x=x;
		this.y=y;
		this.life=3;
		this.slickShape= new Rectangle(y, x, 50, 50);
		
		
	}
	
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
}



>>>>>>> 5b8dd9d295be457b05f07b511e20dba3ffc1110d

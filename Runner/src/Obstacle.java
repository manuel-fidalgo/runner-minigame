import java.awt.Image;
import java.awt.Rectangle;

public class Obstacle extends Entity{
	
	public Obstacle(GamePanel g){
		this.images = new Image[1];
		this.images[0] = importImage("obstacle_0.png");
		this.x = g.getWidth();
		this.y = g.floor_cordinate-this.images[0].getHeight(null)+5;
		this.weight = this.images[0].getWidth(null);
		this.height = this.images[0].getHeight(null);
		border = new Rectangle(x, y, weight,height );
	}
	
}

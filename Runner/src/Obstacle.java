import java.awt.Image;
import java.awt.Rectangle;

public class Obstacle extends Entity{
	
	public Obstacle(GamePanel g){
		this.images = new Image[1];
		this.images[0] = importImage("obstacle_0.png");
		this.x = g.getWidth();
		this.y = g.floor_cordinate-this.images[0].getHeight(null)+5;
		border = new Rectangle(x, y, this.images[0].getWidth(null), this.images[0].getHeight(null));
	}
	
}

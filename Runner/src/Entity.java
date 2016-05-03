import java.awt.Graphics2D;
import java.awt.Image;

public abstract class Entity {
	
	protected int x;
	protected int y;
	private int weight;
	private int hight;
	protected int currentImage;
	Image [] images;
	
	public void draw(Graphics2D g){
		g.drawImage(images[currentImage],x,y,null);
	}
}

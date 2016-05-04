import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Entity {
	
	protected int x;
	protected int y;
	protected int weight;
	protected int hight;
	protected int currentImage;
	public Image [] images;
	
	public void draw(Graphics2D g){
		g.drawImage(images[currentImage],x,y,null);
	}
	public Image importImage(String path){
		return new ImageIcon(getClass().getResource(path)).getImage();
	}
	public void displazeLeft(){
		this.x = this.x-1;
	}
	public void displazeRight(){
		this.x = this.x+1;
	}
}

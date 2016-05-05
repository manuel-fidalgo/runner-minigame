import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Entity {
	
	public static final boolean DEBUG = false;
	protected int x;
	protected int y;
	protected int weight;
	protected int height;
	protected int currentImage;
	public Image [] images;
	Rectangle border;
	
	public void draw(Graphics2D g){
		g.drawImage(images[currentImage],x,y,null);
		try{
			g.setColor(new Color(0,0,0));
		if(DEBUG)	g.draw(border);
		}catch(NullPointerException e){
			
		}
	}
	public Image importImage(String path){
		return new ImageIcon(getClass().getResource(path)).getImage();
	}
	public void displazeLeft(){
		this.x = this.x-1;
		try{
			border.setLocation(x, y);
		}catch(NullPointerException e){
		}
	}
	public void displazeRight(){
		this.x = this.x+1;
		try{
			border.setLocation(x, y);
		}catch(NullPointerException e){
			//Its a cloud
		}
	}
}

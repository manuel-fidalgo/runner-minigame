import java.awt.Image;

import javax.swing.ImageIcon;

public class Character extends Entity{
	public Character(){
		this.x = 0;
		this.y = 0;
		this.images = new Image[2];
		this.images[0] = new ImageIcon(getClass().getResource("0.png")).getImage();
		this.images[1] = new ImageIcon(getClass().getResource("1.png")).getImage();
	}
	public void jump(){
		this.currentImage = 1;
		this.y = this.y - 60;
	}
}

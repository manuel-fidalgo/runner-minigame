import java.awt.Image;
import java.awt.Rectangle;

public class Character extends Entity{
	
	GamePanel g;
	public Character(){
		this.x = 0;
		this.y = 0;
		this.images = new Image[2];
		this.images[0] = importImage("0.png");
		this.images[1] = importImage("1.png");
		border = new Rectangle(x, y, this.images[1].getWidth(null), this.images[1].getHeight(null));
	}
	public void jump(){
		this.currentImage = 1;
		Physics.startJumpingAnimation();
	}
	public void setX(int x){
		this.x = x;
	}
	public int getFeetPosition() {
		return this.y+this.images[currentImage].getHeight(null);
	}
	public void moveDown() {
		this.y++;
		border.setLocation(x, y);
	}
	public void moveUp() {
		this.y--;
		border.setLocation(x, y);
	}
	public void changeImage() {
		currentImage = (currentImage+1)%images.length;
	}
	public void bend() {

	}
}


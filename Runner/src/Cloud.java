import java.awt.Image;


public class Cloud extends Entity{
	public static final String NAME_0 = "cloud_0.png";
	public static final String NAME_1 = "cloud_1.png";
	
	public Cloud(int init){
		this.images = new Image[1];
		this.y = 30;
		this.x = init;
		
		if(Math.random()*10 < 5){
			this.images[0] = importImage(NAME_0);
		}else{
			this.images[0] = importImage(NAME_1);
		}
	}
}

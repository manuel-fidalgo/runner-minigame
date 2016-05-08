import java.awt.Font;
import java.awt.Graphics2D;

public class GameOver {
	private boolean isGameOver;
	public Font font;
	public int option;
	
	public GameOver(Font font){
		this.font = font;
		isGameOver = false;
		option = 1;
	}
	
	public void draw(Graphics2D g){
		
		font.deriveFont(70f);
		g.drawString("GAME OVER",430,152);
		font.deriveFont(40f);
		g.drawString("Restart", 500, 230);
		g.drawString("Exit", 500, 280);
		if(option==1){
			g.drawString("?",450, 230);
		}else{
			g.drawString("?",450, 280);
		}
		
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}
	
	public void doGameOver(){
		isGameOver = true;
	}
	public void changeOption(){
		if(option==1){
			option = 2;
		}else{
			option = 1;
		}
	}

	public void evaluateOption() {
		if(option==1){
			
		}else{
			System.exit(0);
		}
		
	}
}

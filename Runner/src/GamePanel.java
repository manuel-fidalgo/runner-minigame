import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener{
	
	public Character character;
	public static GamePanel panel_singleton;
	Image[] images;
	public int floor_cordinate;
	public int character_cordinate;
	
	public static GamePanel getGamePanel(){
		if(panel_singleton==null)
			panel_singleton = new GamePanel();
		return panel_singleton;
	}
	public GamePanel(){
		updateReferences();
		this.character = new Character();
		images = new Image[2];
		images[0] = new ImageIcon(getClass().getResource("wall.png")).getImage();
		images[1] = new ImageIcon(getClass().getResource("floor.png")).getImage();
	}
	@Override
	public void paintComponent(Graphics g){
		updateReferences();
		g.drawImage(images[0],(int)this.getAlignmentX(),(int)this.getAlignmentY(),this.getWidth(),this.getHeight(), null);
		g.drawImage(images[1],0, floor_cordinate,this.getWidth(),this.getHeight()-floor_cordinate,null);
		character.draw((Graphics2D) g);
	}
	private void updateReferences() {
		this.floor_cordinate = this.getHeight()-this.getHeight()/6;
		this.character_cordinate = this.getWidth()/6;
	}
	/*KeyListener events*/
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

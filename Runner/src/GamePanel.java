import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	public Character character;
	public static GamePanel panel_singleton;
	
	public static GamePanel getGamePanel(){
		if(panel_singleton==null)
			panel_singleton = new GamePanel();
		return panel_singleton;
	}
	public GamePanel(){
		this.character = new Character();
		
	}
	
}

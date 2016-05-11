import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener{

	public Character character;
	public static GamePanel panel_singleton;
	public Physics physics;
	public CloudAnimator clouder; 
	public ObstacleAnimator animator;
	public Chronometer chrono;
	public GameOver gameover;

	Image[] images;
	public int floor_cordinate;
	public int character_cordinate;

	public Font game_font;
	private static final Font SERIF_FONT = new Font("serif", Font.PLAIN, 24);
	private static final String FONT_NAME = "font.ttf";


	public static GamePanel getGamePanel(){
		if(panel_singleton==null)
			panel_singleton = new GamePanel();
		return panel_singleton;
	}

	private GamePanel(){
		updateReferences();
		setUpImages();

		this.game_font = importFont(FONT_NAME);
		this.character = new Character();
		this.gameover = new GameOver(game_font);
		this.clouder = new CloudAnimator(this);
		this.animator = new ObstacleAnimator(this);
		this.chrono = new Chronometer(this);
		this.physics = new Physics(this.character,this);
		this.character.setX(character_cordinate);

		clouder.start();
		physics.start();
		animator.start();
		chrono.start();

		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g){
		updateReferences();

		//Draw the background and the floor
		g.drawImage(images[0],(int)this.getAlignmentX(),(int)this.getAlignmentY(),this.getWidth(),this.getHeight(), null);
		g.drawImage(images[1],(int)this.getAlignmentX(), floor_cordinate,this.getWidth(),this.getHeight()-floor_cordinate,null);
		//The clouds and the obstacles
		for (int i = 0; i < clouder.getClouds().length; i++) {
			try{clouder.getClouds()[i].draw((Graphics2D) g);}catch(NullPointerException e){}
		}
		for (int i = 0; i < animator.getObstacles().length; i++) {
			try{animator.getObstacles()[i].draw((Graphics2D) g);}catch(NullPointerException e){}
		}
		//The chonometer an the characer
		g.setFont(game_font);
		character.draw((Graphics2D) g);
		chrono.draw((Graphics2D)g);

		//The gameOver final message
		if(gameover.isGameOver()) gameover.draw((Graphics2D)g);
		// g.drawLine(this.character_cordinate,(int) this.getAlignmentY(),this.character_cordinate,(int) this.getAlignmentY()+this.getHeight());
	}


	public void setUpImages(){
		images = new Image[2];
		images[0] = new ImageIcon(getClass().getResource("background.png")).getImage();
		images[1] = new ImageIcon(getClass().getResource("floor.png")).getImage();
	}

	private void updateReferences() {
		this.floor_cordinate = this.getHeight()-this.getHeight()/6;
		this.character_cordinate = this.getWidth()/12;
	}

	/*KeyListener events*/
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(!gameover.isGameOver()){
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_SPACE:
			case KeyEvent.VK_W: 
				this.character.jump();
				break;
			case KeyEvent.VK_D: 
				for (int i = 0; i < 10; i++) 
					this.character.displazeRight();
				break;
			case KeyEvent.VK_A:
				for (int i = 0; i < 10; i++)
					this.character.displazeLeft();
				break;
			case KeyEvent.VK_S: 
				this.character.bend();
				break;
			}
			this.repaint();
		}else{
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_W:
				gameover.changeOption();
				break;
			case KeyEvent.VK_S: 
				gameover.changeOption();
				break;
			case KeyEvent.VK_ENTER: 
				gameover.evaluateOption(this);
				break;
			}
			this.repaint();
		}
	}

	public Character getCharacter(){
		return this.character;
	}

	public Rectangle getCharacterBorder() {
		return this.character.border;
	}

	private Font importFont(String name) {

		Font customFont=null;
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(name)).deriveFont(40f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(name)));
		} catch (IOException|FontFormatException e) {
			return SERIF_FONT;
		}
		return customFont;
	}

	public void collision() {
		try{
			clouder.terminate();
			physics.terminate();
			animator.terminate();
			chrono.terminate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			gameover.doGameOver();	
		}
		this.repaint();
	}
	public void restartGame() {
		panel_singleton = new GamePanel();
		this.repaint();
		this.gameover.noGameOver();
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


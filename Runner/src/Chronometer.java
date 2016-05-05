import java.awt.Graphics2D;

public class Chronometer extends Thread {
	
	
	private int minutes;
	private int seconds;
	private static final int SECOND = 1000;
	private GamePanel g;
	
	
	public Chronometer(GamePanel g){
		this.g = g;
		this.minutes = 0;
		this.seconds = 0;
	}
	
	public void run(){
		while(true){
			try{ Thread.sleep(SECOND);}catch(InterruptedException e){};
			this.seconds++;
			if(this.seconds>=60){
				this.minutes++;
				this.seconds=0;
			}
			g.repaint();
		}
	}
	public void draw(Graphics2D gr){
		gr.drawString(Integer.toString(minutes)+":"+Integer.toString(seconds),g.getAlignmentX()+20, g.getAlignmentY()+20);
	}
}

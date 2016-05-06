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
		String min;
		String sec;
		
		if(minutes<10)  min = Integer.toString(0)+Integer.toString(minutes);
			else  min = Integer.toString(minutes);
		
		if(seconds<10)  sec = Integer.toString(0)+Integer.toString(seconds);
			else sec = Integer.toString(seconds);
		
		gr.drawString(min+"."+sec,g.getAlignmentX()+20, g.getAlignmentY()+50);
	}
	public int getMinutes(){
		return this.minutes;
	}
}

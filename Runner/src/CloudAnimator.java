
public class CloudAnimator extends Thread{
	//Array que va a contener las nubes que esten en pantalla
	private Cloud[] current_clouds;
	private GamePanel g;
	private static int DELAY = 30;

	public CloudAnimator(GamePanel gamepanel){
		g = gamepanel;
		current_clouds = new Cloud[1];
		for (int i = 0; i < current_clouds.length; i++) {
			current_clouds[i] = new Cloud(g.getWidth());
		}
	}
	public void run(){
		while (true){
			for (int i = 0; i < current_clouds.length; i++) {
				current_clouds[i].displazeLeft();
				
				if(current_clouds[i].x + current_clouds[i].images[0].getWidth(null) < g.getAlignmentX())
					current_clouds[i] = new Cloud(g.getWidth());
			}
			try{ Thread.sleep(DELAY); }catch(InterruptedException e){ }
			g.repaint();
		}
	}
	public Cloud[] getClouds(){
		return this.current_clouds;
	}

}

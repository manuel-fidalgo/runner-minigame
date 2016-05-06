import java.util.Random;

public class CloudAnimator extends Thread{
	//Array que va a contener las nubes que esten en pantalla
	private Cloud[] current_clouds;
	private GamePanel g;
	private static int DELAY = 30;
	private static boolean flag = true;
	Random r;

	public CloudAnimator(GamePanel gamepanel){
		g = gamepanel;
		r = new Random(System.currentTimeMillis());
		current_clouds = new Cloud[3];
	}
	public void run(){
		while (flag){
			for (int i = 0; i < current_clouds.length; i++) {
				if(current_clouds[i]!=null){
					current_clouds[i].displazeLeft();
					
				if(current_clouds[i].x + current_clouds[i].images[0].getWidth(null) < g.getAlignmentX())
					current_clouds[i] = null;
				}
			}
			try{ Thread.sleep(DELAY); }catch(InterruptedException e){ }
			if(r.nextInt(1000)<3){
				for (int i = 0; i < current_clouds.length; i++) {
					if(current_clouds[i]==null){
						current_clouds[i]= new Cloud(g.getWidth());
						break;
					}
				}
			}
			g.repaint();
		}
	}
	public Cloud[] getClouds(){
		return this.current_clouds;
	}
	public void terminate() {
		flag = false;

	}

}

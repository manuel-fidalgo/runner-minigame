
public class ObstacleAnimator extends Thread{

	Obstacle[] current_obstacles;
	GamePanel g;
	public static int DELAY = 3;

	public ObstacleAnimator(GamePanel g) {
		this.g = g;
		this.current_obstacles = new Obstacle[1];
		for (int i = 0; i < current_obstacles.length; i++) {
			current_obstacles[i] = new Obstacle(g);
		}
	}
	public void run(){
		while(true){
			for (int i = 0; i < current_obstacles.length; i++) {
				current_obstacles[i].displazeLeft();
				if(current_obstacles[i].x + current_obstacles[i].images[0].getWidth(null) < g.getAlignmentX()){
					current_obstacles[i] = new Obstacle(g);
				}
			}
			try{ Thread.sleep(DELAY); }catch(InterruptedException e){ }
			g.repaint();
		}
	}
	public Obstacle[] getObstacles(){
		return this.current_obstacles;
	}
}

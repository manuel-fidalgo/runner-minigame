import java.util.Random;

public class ObstacleAnimator extends Thread{

	public static final int NUM_MAX_OBSTACLES = 4;
	Obstacle[] current_obstacles;
	GamePanel g;
	public static int DELAY = 3;
	Random r;
	private static boolean flag = true;
	int cout;

	public ObstacleAnimator(GamePanel g) {
		cout = 0;
		this.g = g;
		this.r = new Random(System.currentTimeMillis());
		this.current_obstacles = new Obstacle[NUM_MAX_OBSTACLES];
	}
	public void run(){
		
		while(flag){
			switch(g.chrono.getMinutes()){
			case 2: DELAY = 2; break;
			case 5: DELAY = 1; break;
			}
			
			for (int i = 0; i < NUM_MAX_OBSTACLES; i++) {

				if(current_obstacles[i]!=null){ //Ther is an object
					current_obstacles[i].displazeLeft();

					if(current_obstacles[i].border.intersects((g.getCharacterBorder()))){
						//Los bordes han chocado, miramos a ver si tambien han chocado las imagenes
						//if(imagesIntercestion());{
						/*
							System.out.println("Colision");
							System.out.println("Obstaculo->"+current_obstacles[i].border);
							System.out.println("Player->"+g.getCharacterBorder());
						*/
							g.collision();
						//}
					}
					
					if(current_obstacles[i].x + current_obstacles[i].images[0].getWidth(null) < g.getAlignmentX()){
						current_obstacles[i] = null;
					}
				}

			}
			if(r.nextInt(1000)<2)createNewObstacle();
			try{ Thread.sleep(DELAY); }catch(InterruptedException e){ }
			g.repaint();
		}
	}
	//Crea un obstaculo en la primera posion null que encuentra
	private void createNewObstacle() {
		for (int i = 0; i < NUM_MAX_OBSTACLES; i++) {
			if(this.current_obstacles[i]==null){
				this.current_obstacles[i] = new Obstacle(g);
				break;
			}
		}

	}
	public Obstacle[] getObstacles(){
		return this.current_obstacles;
	}
	public void terminate() {
		flag = false;
		
	}
}

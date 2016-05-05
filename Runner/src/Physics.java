
public class Physics extends Thread{
	Character character;
	GamePanel gamepanel;
	public static int LEG_DELAY = 100;
	public static int FALL_DELAY;
	
	public Physics(Character c,GamePanel g){
		FALL_DELAY=6;
		this.character = c;
		gamepanel = g;
	}
	
	public void run(){
		while(true){
			if(character.getFeetPosition() < gamepanel.floor_cordinate){
				character.moveDown();
				//System.out.println(FALL_DELAY);
				try { Thread.sleep(FALL_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
			}else{
				FALL_DELAY = 5;
				try { Thread.sleep(LEG_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
				character.changeImage();
			}
			gamepanel.repaint();
		}
	}
}

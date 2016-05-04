
public class Physics extends Thread{
	Character character;
	GamePanel gamepanel;
	public static int DELAY = 100;
	public static int FALL_SPEED = 3;
	
	public Physics(Character c,GamePanel g){
		this.character = c;
		gamepanel = g;
	}
	
	public void run(){
		while(true){
			if(character.getFeetPosition() < gamepanel.floor_cordinate){
				character.moveDown();
				try { Thread.sleep(FALL_SPEED); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
			}else{
				try { Thread.sleep(DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
				character.changeImage();
			}
			gamepanel.repaint();
		}
	}
}

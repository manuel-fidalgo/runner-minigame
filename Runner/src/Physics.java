
public class Physics extends Thread{
	Character character;
	GamePanel gamepanel;
	static boolean isJumping;
	public static int LEG_DELAY = 100;
	public static int FALL_DELAY;
	
	public Physics(Character c,GamePanel g){
		FALL_DELAY=3;
		this.character = c;
		gamepanel = g;
	}
	
	public void run(){
		while(true){
			if(isJumping){
				character.moveUp();
				if(character.getFeetPosition() < character.images[0].getHeight(null)*1.5){
					isJumping=false;
				}
				try { Thread.sleep(FALL_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
			}else if(character.getFeetPosition() < gamepanel.floor_cordinate){
				character.moveDown();
				try { Thread.sleep(FALL_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
			}else{
				try { Thread.sleep(LEG_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
				character.changeImage();
			}
			gamepanel.repaint();
		}
	}
	public static void startJumpingAnimation(){
		isJumping = true;
	}
}

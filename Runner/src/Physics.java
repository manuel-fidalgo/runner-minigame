
public class Physics extends Thread{
	Character character;
	GamePanel gamepanel;
	static boolean isJumping;
	static boolean isFalling;
	public static int LEG_DELAY = 100;
	public static int FALL_DELAY;
	private static boolean flag = true;
	
	public Physics(Character c,GamePanel g){
		FALL_DELAY=3;
		this.character = c;
		gamepanel = g;
	}
	
	public void run(){
		while(flag){
			if(isJumping){
				character.moveUp();
				if(character.getFeetPosition() < character.images[0].getHeight(null)*1.5){
					isJumping=false;
				}
				try { Thread.sleep(FALL_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
			}else if(character.getFeetPosition() < gamepanel.floor_cordinate){
				character.moveDown();
				isFalling = true;
				try { Thread.sleep(FALL_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
			}else{
				isFalling = false;
				try { Thread.sleep(LEG_DELAY); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
				character.changeImage();
			}
			gamepanel.repaint();
		}
	}
	public static void startJumpingAnimation(){
		if(!isFalling)isJumping = true;
	}
	public void terminate(){
		flag = false;
	}
}

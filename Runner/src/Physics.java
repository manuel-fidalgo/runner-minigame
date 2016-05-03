
public class Physics extends Thread{
	Character character;
	GamePanel gamepanel;
	
	public Physics(Character c,GamePanel g){
		this.character = c;
		gamepanel = g;
	}
	
	public void run(){
		while(true){
			if(character.getFeetPosition()<gamepanel.floor_cordinate){
				character.moveDown();
				try { Thread.sleep(5); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
			}else{
				try { Thread.sleep(100); } catch (InterruptedException e) { System.err.println("interrupted exception."); }
				character.changeImage();
			}
			gamepanel.repaint();
		}
	}
}

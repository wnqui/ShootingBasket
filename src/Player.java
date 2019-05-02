import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
	
	private int x;
	private int y;
	private int size;
	
	Player(int x ,int y , int size){
		this.setX(x);
		this.setY(y);
		this.size = size;
	}

	public void drawPlayer(Graphics2D g2){
		
		g2.setColor(Color.CYAN);
		g2.fillRect(x, y, size, size*2);
		g2.setColor(Color.black);
		g2.drawRect(x, y, size, size *2);
		
		
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

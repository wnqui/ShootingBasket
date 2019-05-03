import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Hoop {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Hoop(int x ,int y ,int width  ,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void drawHoop(Graphics2D g2) {
		g2.setStroke(new BasicStroke(3));
		
		g2.setColor(Color.yellow);
		g2.fillRect(x, y, width, height);
		
		g2.setColor(Color.black);
		g2.drawRect(x, y, width, height);
			
		
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

	public void setSize(int width , int height) {
		this.width = width;
		this.height = height;
	}

}

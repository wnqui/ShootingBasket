import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
	
	private int x;
	private int y;
	private int size;
	private boolean isShoot;
	private int power;
	private int angle;
	
	Ball(int x ,int y ,int size){
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public void Shoot(int power, int angle,boolean isShoot) {
		this.isShoot = isShoot;
		this.power= power;
		this.angle = angle;
	
	}
	
	public void move() {
		if(isShoot) {

		}
	}
	
	public void darwBall(Graphics2D g2){
		
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.red);
		g2.fillOval(x, y, size, size);
		g2.setColor(Color.black);
		g2.drawOval(x, y, size, size);
	}

}

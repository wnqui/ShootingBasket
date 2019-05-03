import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int maxY;
	private int size;
	private boolean isShoot;
	private int power;
	private int maxPower;
	protected int g =2;
	private double angle;
	
	Ball(int x ,int y ,int size){
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public void Shoot(int power, double angle,boolean isShoot) {
		this.isShoot = isShoot;
		this.angle = angle  ;
		this.power = 0;
		dx = (int) (power/2 * Math.cos(Math.toRadians(this.angle)));
		dy = (int) (power * Math.sin(Math.toRadians(this.angle)));
		this.maxPower= dy;
		
		System.out.println(dx +" "+ dy);
	
	}
	
	public void move() {
		if(isShoot) {
		
			x += dx;				
			y -= dy;		
			dy -= g;
					
			//落邊減速
			if( y > 550-size) {
				y = 549-size;
				maxPower = maxPower *8/10;
				dy = maxPower ;	
				dx = (int)(dx*0.99);
			}		
			//邊界減速
			if(x >750-size) {
				x = 749-size;
				dx = (-1)* (dx *3/4);					
				
			}else if( x <50) {
				x=51;
				dx = (-1)* (dx *3/4);	
			}
		
		}

	}
	
	public void darwBall(Graphics2D g2){
		
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.red);
		g2.fillOval(x, y, size, size);
		g2.setColor(Color.black);
		g2.drawOval(x, y, size, size);
	}
	
	public int getX() {
		return x;
	}
	public int getY(){
		return y;
	}
	public void setXY(int x ,int y) {
		this.x = x;
		this.y = y;
	}
	public void setShoot(boolean isShoot) {
		this.isShoot = isShoot;
	}
}

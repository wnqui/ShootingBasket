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
	protected int g =5;
	private int angle;
	
	Ball(int x ,int y ,int size){
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public void Shoot(int power, int angle,boolean isShoot) {
		this.isShoot = isShoot;
		this.maxPower= power;
		this.angle = angle;
		this.power = 0;
		g = 0;
		dy = (int)(3*power * Math.cos(angle));
		dx = power;
	
	}
	
	public void move() {
		if(isShoot) {
		
				x += dx;				
				y -= dy;
			
			// �̰����
			if(y > maxY) maxY =y;
			//dx �I�� -50�H ���a-10�H
			
			//�p�G�����dy dy����Ady=0 �Ay���̰��B�A�ন�V�U g���W(�̤j10) ���츨�a�A�ϼu
			if( y > 500) {
				y =499;
				maxPower = maxPower *8/10;
				dy = maxPower ;
				g =5;
			}
			if(dy <= 0) {
				//���O�[�t��
				if( g < 16) g +=2;
				y += g;
			
				//���a�ϼu�A�[�t���k0
			}else {
				dy --;				
			}				
			
			if(x >750) {
				x = 749;
				dx = (-1)* (dx /2);					
				
			}
			
			// y ���a dy = maxY -80�H
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

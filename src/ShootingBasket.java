import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.xml.internal.bind.v2.WellKnownNamespace;


public class ShootingBasket implements ActionListener , KeyListener ,MouseListener ,MouseMotionListener{
	//盽计
	public static int WIDTH =800;;
	public static int HEIGHT =600;
	//ン
	public static JFrame JF;
	public static myPanel MP;
	public static ShootingBasket SB;
	Player p = new Player(70,450,50);
	Ball b = new Ball(100,430,35);
	//北籹
	public int mouseX;
	public int mouseY;
	public int power;
	public boolean powerOver;
	public boolean forPower;
	public double forPowerR;
	
	
	public ShootingBasket() {
		JF = new JFrame("Shooting basket");
		MP = new myPanel();
		JF.setBounds(100, 100, WIDTH, HEIGHT);
		JF.setVisible(true);
		JF.setResizable(false);
		JF.setAlwaysOnTop(true);
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.add(MP);
		JF.addKeyListener(this);
		JF.addMouseListener(this);
		JF.addMouseMotionListener(this);
		Timer t = new Timer(20,this);
		t.start();
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		b.move();
		
		if(forPower) {
			
			if(power <=0) {
				powerOver = false;
			}else if(power >= 75) {
				powerOver = true;
			}
			if(powerOver) {
				if(power >0) {
					power -=2;
				}
			}else {
				if(power < 75) {
					power +=2;
				}
			}
			
			forPowerR = (double)power / 75 ;
		}
		MP.repaint();
	}
	
	public void repaint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		//フ┏
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH,HEIGHT);
		//初
		g2.setColor(Color.black);
		g2.drawRect(50, 50, WIDTH-100, HEIGHT-100);
		
		//菲公代Αノ
		g2.setColor(Color.red);
		g2.fillOval(mouseX-5, mouseY-5, 10, 10);
		
		g2.setColor(Color.red);
		g2.setFont(new Font("",1,20));
		g2.drawString("power:"+power, 70, 70);
		g2.setColor(Color.lightGray);
		g2.fillRect(70, 75, 100, 5);
		g2.setColor(Color.yellow);
		g2.fillRect(70, 75, (int)(forPowerR*100) , 5);
		
		p.drawPlayer(g2);
		b.darwBall(g2);
	
	}
	
	public static void main(String[] args) {
		SB = new ShootingBasket();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//щ瞴à
		mouseX = e.getX()-3;
		mouseY = e.getY()-32;
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		//щ瞴籛
		forPower = false;
		double dx = mouseX - b.getX();
		double dy = b.getY() - mouseY;
		double angle = Math.atan2(dy, dx) / Math.PI *180;
		System.out.println(angle);
		b.Shoot(power, angle, true);
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//щ瞴щ
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//翴匡
		power =0;
		b.setShoot(false);
		b.setXY(100, 430);
		forPower =true;
		
		
	
	}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mouseDragged(MouseEvent arg0) {}

	
//end
}

class myPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g) {
		ShootingBasket.SB.repaint(g);
	}
	
}
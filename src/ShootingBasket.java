import java.awt.BasicStroke;
import java.awt.Color;
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

public class ShootingBasket implements ActionListener , KeyListener ,MouseListener ,MouseMotionListener{
	//盽计
	public static int WIDTH =800;;
	public static int HEIGHT =600;
	//ン
	public static JFrame JF;
	public static myPanel MP;
	public static ShootingBasket SB;
	Ball b = new Ball(200,200,35);
	Player p = new Player(100,300,50);
	//北籹
	public int mouseX;
	public int mouseY;
	
	
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
		
		MP.repaint();
	}
	
	public void repaint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		//フ┏
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH,HEIGHT);
		
		//菲公代Αノ
		g2.setColor(Color.red);
		g2.fillOval(mouseX-5, mouseY-5, 10, 10);
		
		b.darwBall(g2);
		p.drawPlayer(g2);
	
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
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//щ瞴щ
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//翴匡
	
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
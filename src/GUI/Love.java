package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Love extends JFrame implements MouseListener{
	Container cn;
	int M = 5, N = 5;
	int pre = 13;
	JButton bt[][] = new JButton[M][N];
	public Love() {
		super("Do You Love Me ?");
		cn = init();
	}
	
	public Container init() {
		Container cn = this.getContentPane();
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(new GridLayout(2, 1));
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(new FlowLayout());
		pn3.setBackground(Color.black);
		
		JLabel lb = new JLabel("Do You Love Me");
		lb.setForeground(Color.magenta);
		lb.setBackground(Color.black);
		lb.setFont(new Font("Algerian", 1, 100));
		
		JLabel lb2 = new JLabel("");
		lb2.setForeground(Color.magenta);
		lb2.setBackground(Color.black);
		lb2.setFont(new Font("Algerian", 1, 10));
		
		pn2.setBackground(Color.black);
		
		pn3.add(lb);
		
		pn2.add(lb2);
		pn2.add(pn3);
		
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(M, N));
		pn.setBackground(Color.black);
		
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++) {
				bt[i][j] = new JButton();
				bt[i][j].setActionCommand((i * N + j) + "");
				bt[i][j].addMouseListener(this);
				pn.add(bt[i][j]);
			}
		
		bt[2][1].setText("YES");
		bt[2][3].setText("NO");
		
		cn.add(pn2, "North");
		cn.add(pn);
		
		this.setVisible(true);
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		setResizable(false);
		
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		return cn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Love();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btt = (JButton) e.getComponent();
		int k = Integer.parseInt(btt.getActionCommand());
		if (k == pre) {
			btt.setBackground(Color.black);
			k = randNumber(pre);
		}
	}
	
	public int randNumber(int N) {
		return 0;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

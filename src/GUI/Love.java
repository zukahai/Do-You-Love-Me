package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Love extends JFrame implements MouseListener, ActionListener{
	Container cn;
	int M = 5, N = 5;
	int pre = 13;
	Timer timer;
	JButton bt[][] = new JButton[M][N];
	public Love() {
		super("Do You Love Me ?");
		cn = init();
	}
	int count = 0;
	
	String s[] = {"Sorry!",
				"I do not love you",
				"Goodbye!",
				"...",
				" "};
	boolean Music = true;
	boolean ok = false;
	Clip clip;
	public Container init() {
		Container cn = this.getContentPane();
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(new GridLayout(2, 1));
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(new FlowLayout());
		pn3.setBackground(Color.black);
		
		JLabel lb = new JLabel("Do You Love Me?");
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
				bt[i][j].setBorder(null);
				bt[i][j].setFont(new Font("Algerian", 1, 50));
				bt[i][j].setForeground(Color.magenta);
				bt[i][j].setBackground(Color.black);
				pn.add(bt[i][j]);
			}
		
		bt[2][1].setText("YES");
		bt[2][1].addActionListener(this);
		bt[2][3].setText("NO");
		
		cn.add(pn2, "North");
		cn.add(pn);
		
		this.setVisible(true);
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		setResizable(false);
		
		timer = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.setText(s[count++]);
				if (count == s.length)
					System.exit(0);
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		return cn;
	}
	
	public void sound(int index) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		try {
			File file = new File("Sound/" + index + ".wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		if (ok)
			return;
		// TODO Auto-generated method stub
		JButton btt = (JButton) e.getComponent();
		int k = Integer.parseInt(btt.getActionCommand());
		if (k == pre) {
			btt.setText("");
			k = pre = randNumber(pre);
			int j = k % N;
			int i = k / N;
			bt[i][j].setText("NO");
			if (Music) {
				try {
					sound(1);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Music = false;
			}
			if (clip.getMicrosecondPosition() == clip.getMicrosecondLength()) 
				Music = true;
		}
	}
	
	public int randNumber(int N) {
		int k = 0;
		do {
			k = (int) (Math.random() * 23 + 1);
		} while (k == 11 || k == N);
		return k;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("11")) {
			timer.start();
			bt[2][1].setText("");
			int j = pre % N;
			int i = pre / N;
			bt[i][j].setText("");
			if (clip != null)
				clip.stop();
			try {
				sound(2);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ok = true;
		}
	}

}

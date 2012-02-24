import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class JTetris extends JComponent {
	
	public JTetris(int pixels) {
		super();
	}
	
	public JComponent createControlPanel() {
		JPanel panel = new JPanel();
		
		return panel; 
	}
	
	public static JFrame createFrame(JTetris tetris) {
		// configure the frame container
		JFrame frame = new JFrame("Stanford Tetris");
		JComponent container = (JComponent)frame.getContentPane();
		container.setLayout(new BorderLayout());
		
		int unitWidth = 150;
		int unitHeight = 100;
		
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(unitWidth,unitHeight));
		center.setBackground(Color.black);
		container.add(center,BorderLayout.CENTER);
		
		JButton button = new JButton("here");
		center.add(button);
		
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(unitWidth,unitHeight));
		west.setBackground(Color.red);
		container.add(west,BorderLayout.WEST);
		
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(unitWidth,unitHeight));
		east.setBackground(Color.green);
		container.add(east,BorderLayout.EAST);
		
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(3*unitWidth,unitHeight/2));
		north.setBackground(Color.blue);
		container.add(north,BorderLayout.NORTH);
		
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(3*unitWidth,unitHeight/2));
		south.setBackground(Color.yellow);
		container.add(south,BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		return frame;
	}
	
	public static void main(String[] args) {
		// configure look and feel of the app
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch ( Exception ignored ) { }
		
		// configure and display the game itself 
		JTetris tetris = new JTetris(16);
		JFrame frame = JTetris.createFrame(tetris);
		frame.setVisible(true);
		
		UIManager.LookAndFeelInfo[] feels = UIManager.getInstalledLookAndFeels();
		for ( UIManager.LookAndFeelInfo feel : feels ) {
			System.out.println(feel);
		}
	}
}

package keisterPouch.GUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.CardLayout;

public class HommieWalletApp {

	private JFrame frameMainApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HommieWalletApp window = new HommieWalletApp();
					window.frameMainApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HommieWalletApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMainApp = new JFrame();
		frameMainApp.setTitle("Hommie Wallet App");
		frameMainApp.getContentPane().setBackground(new Color(153, 153, 153));
		frameMainApp.getContentPane().setForeground(new Color(153, 204, 204));
		frameMainApp.getContentPane().setLayout(new CardLayout(0, 0));
		frameMainApp.setBounds(100, 100, 800, 600);
		frameMainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frameMainApp.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
	}

}

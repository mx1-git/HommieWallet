package keisterPouch.GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import keisterPouch.common.HommieQuotes;

public class HommieLoginWelcome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5007777273191228914L;
	private JPanel contentPane;
	private JButton btnLoginButton;
	private JPasswordField fullPwdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HommieLoginWelcome frame = new HommieLoginWelcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HommieLoginWelcome() {
		setTitle(Messages.getString("HommieLoginWelcome.walletAppTitle")); //$NON-NLS-1$
		setBackground(Color.GRAY);
		
		initComponents();
		createEvents();
		

	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void createEvents() {
		
		//String strMainPrivKey = "Not yet set!";
		btnLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				char[] charArrayMainPrivKey = fullPwdField.getPassword();
				//JOptionPane.showMessageDialog(null, strMainPrivKey);
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Throwable e) {
					e.printStackTrace();
				}
				//Launch HommieWalletApp in new thread
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							HommieWalletApp window = new HommieWalletApp();
							window.getFrameMainApp().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				//TODO: Verify password with the main HommieWalletApp
				Arrays.fill(charArrayMainPrivKey, '0');
				String strMainPrivKey = new String(charArrayMainPrivKey);
				JOptionPane.showMessageDialog(null, strMainPrivKey);
				setVisible(false);
			}
		});
		

	}

	private void initComponents() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(HommieLoginWelcome.class.getResource("/keisterPouch/resources/nxt-icon-32x32.png"))); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu(Messages.getString("HommieLoginWelcome.menuItem_File")); //$NON-NLS-1$
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem(Messages.getString("HommieLoginWelcome.menuItem_Exit")); //$NON-NLS-1$
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int status = 0;
				System.exit(status);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu(Messages.getString("HommieLoginWelcome.menuItem_Help")); //$NON-NLS-1$
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem(Messages.getString("HommieLoginWelcome.menuItem_About")); //$NON-NLS-1$
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, HommieQuotes.strHommieHelpAbout);
			}
		});
		
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 102));
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnLoginButton = new JButton(Messages.getString("HommieLoginWelcome.btnLogin")); //$NON-NLS-1$

		btnLoginButton.setFont(new Font("Droid Sans", Font.BOLD, 14)); //$NON-NLS-1$
		btnLoginButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLoginButton.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblManualPasswordEntry = new JLabel(Messages.getString("HommieLoginWelcome.mainPrivKeyLabel")); //$NON-NLS-1$
		lblManualPasswordEntry.setForeground(Color.BLACK);
		lblManualPasswordEntry.setFont(new Font("Droid Sans", Font.BOLD, 14)); //$NON-NLS-1$
		
		fullPwdField = new JPasswordField();
		fullPwdField.setToolTipText(Messages.getString("HommieLoginWelcome.pwFieldToolTipTxt")); //$NON-NLS-1$
		fullPwdField.setColumns(2);
		fullPwdField.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.background")); //$NON-NLS-1$
		fullPwdField.setEchoChar('#');
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(fullPwdField, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblManualPasswordEntry, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
							.addComponent(btnLoginButton)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(255, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblManualPasswordEntry)
						.addComponent(btnLoginButton))
					.addGap(18)
					.addComponent(fullPwdField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
	}
}

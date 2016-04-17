package baako.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class MainWindow {

	private JFrame frmBaako;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmBaako.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBaako = new JFrame();
		frmBaako.setTitle("Baako");
		frmBaako.setBounds(100, 100, 1000, 650);
		frmBaako.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBaako.getContentPane().setLayout(null);
		
		frameComposing();
		

		
	}
	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void frameComposing(){
	JScrollPane mainPanel = new JScrollPane();
	mainPanel.setBounds(0, 31, 741, 581);
	frmBaako.getContentPane().add(mainPanel);
	
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBackground(new Color(105, 105, 105));
	menuBar.setBounds(0, 0, 741, 33);
	frmBaako.getContentPane().add(menuBar);
	
	JMenu libraryMenu = new JMenu("Library");
	libraryMenu.setForeground(new Color(255, 255, 255));
	libraryMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
	menuBar.add(libraryMenu);
	
	JMenuItem mntmLibraryOption = new JMenuItem("Library option 1");
	libraryMenu.add(mntmLibraryOption);
	
	JMenu mnMarket = new JMenu("Market");
	mnMarket.setForeground(new Color(255, 255, 255));
	mnMarket.setFont(new Font("Segoe UI", Font.BOLD, 14));
	menuBar.add(mnMarket);
	
	JMenuItem mntmAllGames = new JMenuItem("All Games");
	mnMarket.add(mntmAllGames);
	
	JMenu mnGenre = new JMenu("Genre");
	mnMarket.add(mnGenre);
	
	JMenu mnStudio = new JMenu("Studio");
	mnMarket.add(mnStudio);
	
	JMenu mnNews = new JMenu("News");
	mnNews.setForeground(new Color(255, 255, 255));
	mnNews.setFont(new Font("Segoe UI", Font.BOLD, 14));
	menuBar.add(mnNews);
	
	JMenu mnCommunity = new JMenu("Community");
	mnCommunity.setForeground(new Color(255, 255, 255));
	mnCommunity.setFont(new Font("Segoe UI", Font.BOLD, 14));
	menuBar.add(mnCommunity);
	
	JMenuItem mntmSeeFriends = new JMenuItem("See Friends");
	mnCommunity.add(mntmSeeFriends);
	
	JMenuItem mntmFindFriends = new JMenuItem("Find Friends");
	mnCommunity.add(mntmFindFriends);
	
	JPanel optionPanel = new JPanel();
	optionPanel.setBackground(new Color(128, 128, 128));
	optionPanel.setBounds(741, 31, 243, 581);
	frmBaako.getContentPane().add(optionPanel);
	
	JPanel LogPanel = new JPanel();
	LogPanel.setBackground(new Color(105, 105, 105));
	LogPanel.setBounds(741, 0, 243, 33);
	frmBaako.getContentPane().add(LogPanel);
	LogPanel.setLayout(null);
}

	public void logOut(){
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setBounds(10, 0, 102, 27);
	//	LogPanel.add(btnLogin);
		
		JLabel lblLogged = new JLabel("Log Status");
		lblLogged.setForeground(new Color(255, 255, 255));
		lblLogged.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogged.setBounds(124, 0, 119, 27);
	//	LogPanel.add(lblLogged);
	}


}

package baako.client.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import baako.server.database.PlainUser;
import baako.server.database.User;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GUI {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	protected JTextField tfUsername;
	protected JTextField tfEmail;
	protected JPasswordField pfpassField;
	private JTextField nameField;
	private JTextField priceField;
	private String state;


	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.state=null;
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\eclipse\\git\\Baako\\Baako_Server\\src\\main\\images\\bakologo.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setVisible(true);
		mainview();
		//addgameview();
		//mainview();
		//mainview();
	}

	public void mainview(){
		this.state="userfriends";
		frame.setSize(741, 581);
		frame.getContentPane().setLayout(null);

		JPanel mainPanel_1 = new JPanel();
		mainPanel_1.setBounds(0, 0, 725, 542);
		frame.getContentPane().add(mainPanel_1);
		mainPanel_1.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setBounds(0, 0, 574, 50);
		mainPanel_1.add(menuBar);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(105, 105, 105));

		JMenu libraryMenu = new JMenu("Library");
		libraryMenu.setForeground(new Color(255, 255, 255));
		libraryMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
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
		JScrollPane mainPanel = new JScrollPane();
		mainPanel.setBounds(0, 48, 574, 494);
		mainPanel_1.add(mainPanel);

		JPanel logoutPanel = new JPanel();
		logoutPanel.setBounds(573, 0, 152, 49);
		mainPanel_1.add(logoutPanel);
		logoutPanel.setBackground(new Color(105, 105, 105));
		logoutPanel.setLayout(null);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBackground(new Color(255, 51, 0));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBounds(0, 0, 152, 50);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel_1.setVisible(false);
				//loginview();
				frame.repaint();
			}
		});
		logoutPanel.add(btnLogout);

		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(new Color(105, 105, 105));
		optionPanel.setBounds(574, 49, 151, 493);
		mainPanel_1.add(optionPanel);
		GridBagLayout gbl_optionPanel = new GridBagLayout();
		gbl_optionPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_optionPanel.rowHeights = new int[]{117, 42, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_optionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_optionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		optionPanel.setLayout(gbl_optionPanel);
		
		JLabel iconlabel = new JLabel("");
		iconlabel.setIcon(new ImageIcon("C:\\eclipse\\git\\Baako\\Baako_Server\\src\\main\\images\\bakologo.ico"));
		GridBagConstraints gbc_iconlabel = new GridBagConstraints();
		gbc_iconlabel.insets = new Insets(60, 0, 5, 0);
		gbc_iconlabel.gridx = 1;
		gbc_iconlabel.gridy = 10;
		optionPanel.add(iconlabel, gbc_iconlabel);
		
		JButton btninfo = new JButton("+INFO");
		GridBagConstraints gbc_btninfo = new GridBagConstraints();
		
		JButton btnBack = new JButton("BACK");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		
		switch(state){
		case "adminnews":
			JButton btnAddNews = new JButton("ADD NEWS");
			GridBagConstraints gbc_btnAddNews = new GridBagConstraints();
			gbc_btnAddNews.fill = GridBagConstraints.BOTH;
			gbc_btnAddNews.insets = new Insets(0, 25, 5, 0);
			gbc_btnAddNews.gridx = 1;
			gbc_btnAddNews.gridy = 1;
			optionPanel.add(btnAddNews, gbc_btnAddNews);
			
			JButton btnEditNews = new JButton("EDIT NEWS");
			GridBagConstraints gbc_btnEditNews = new GridBagConstraints();
			gbc_btnEditNews.fill = GridBagConstraints.BOTH;
			gbc_btnEditNews.insets = new Insets(0, 25, 5, 0);
			gbc_btnEditNews.gridx = 1;
			gbc_btnEditNews.gridy = 2;
			optionPanel.add(btnEditNews, gbc_btnEditNews);
			

			gbc_btninfo.insets = new Insets(40, 25, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 6;
			optionPanel.add(btninfo, gbc_btninfo);
			
			gbc_btnBack.insets = new Insets(0, 25, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 7;
			optionPanel.add(btnBack, gbc_btnBack);
			break;
		case "usernews":

			gbc_btninfo.fill = GridBagConstraints.BOTH;
			gbc_btninfo.insets = new Insets(0, 45, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 1;
			optionPanel.add(btninfo, gbc_btninfo);
			

			gbc_btnBack.fill = GridBagConstraints.BOTH;
			gbc_btnBack.insets = new Insets(0, 45, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 2;
			optionPanel.add(btnBack, gbc_btnBack);

			break;
		case "admingames":
			JButton btnAddGame = new JButton("ADD GAME");
			GridBagConstraints gbc_btnAddGame = new GridBagConstraints();
			gbc_btnAddGame.fill = GridBagConstraints.BOTH;
			gbc_btnAddGame.insets = new Insets(0, 35, 5, 0);
			gbc_btnAddGame.gridx = 1;
			gbc_btnAddGame.gridy = 1;
			optionPanel.add(btnAddGame, gbc_btnAddGame);
			
			JButton btnEditGame = new JButton("EDIT GAME");
			GridBagConstraints gbc_btnEditGame = new GridBagConstraints();
			gbc_btnEditGame.fill = GridBagConstraints.BOTH;
			gbc_btnEditGame.insets = new Insets(0, 35, 5, 0);
			gbc_btnEditGame.gridx = 1;
			gbc_btnEditGame.gridy = 2;
			optionPanel.add(btnEditGame, gbc_btnEditGame);
			

			gbc_btninfo.insets = new Insets(40, 45, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 6;
			optionPanel.add(btninfo, gbc_btninfo);
			
			gbc_btnBack.insets = new Insets(0, 45, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 7;
			optionPanel.add(btnBack, gbc_btnBack);
			break;
		case "userlibrary":
			JButton btnLaunch = new JButton("LAUNCH");
			GridBagConstraints gbc_btnLaunch = new GridBagConstraints();
			gbc_btnLaunch.fill = GridBagConstraints.BOTH;
			gbc_btnLaunch.insets = new Insets(0, 45, 5, 0);
			gbc_btnLaunch.gridx = 1;
			gbc_btnLaunch.gridy = 1;
			optionPanel.add(btnLaunch, gbc_btnLaunch);

			gbc_btninfo.insets = new Insets(40, 45, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 3;
			optionPanel.add(btninfo, gbc_btninfo);
			
			gbc_btnBack.insets = new Insets(0, 45, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 4;
			optionPanel.add(btnBack, gbc_btnBack);
			break;
		case "usergames":
			JButton btnBuy = new JButton("BUY GAME");
			GridBagConstraints gbc_btnBuy = new GridBagConstraints();
			gbc_btnBuy.fill = GridBagConstraints.BOTH;
			gbc_btnBuy.insets = new Insets(0, 25, 5, 0);
			gbc_btnBuy.gridx = 1;
			gbc_btnBuy.gridy = 1;
			optionPanel.add(btnBuy, gbc_btnBuy);
			
			JButton btnRent = new JButton("RENT GAME");
			GridBagConstraints gbc_btnRent = new GridBagConstraints();
			gbc_btnRent.fill = GridBagConstraints.BOTH;
			gbc_btnRent.insets = new Insets(0, 25, 5, 0);
			gbc_btnRent.gridx = 1;
			gbc_btnRent.gridy = 2;
			optionPanel.add(btnRent, gbc_btnRent);
			

			gbc_btninfo.insets = new Insets(40, 35, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 4;
			optionPanel.add(btninfo, gbc_btninfo);
			
			gbc_btnBack.insets = new Insets(0, 35, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 5;
			optionPanel.add(btnBack, gbc_btnBack);
			break;
		case "userfriends":
			JButton btnAddFriend = new JButton("ADD FRIEND");
			GridBagConstraints gbc_btnAddFriend = new GridBagConstraints();
			gbc_btnAddFriend.fill = GridBagConstraints.BOTH;
			gbc_btnAddFriend.insets = new Insets(0, 20, 5, 0);
			gbc_btnAddFriend.gridx = 1;
			gbc_btnAddFriend.gridy = 1;
			optionPanel.add(btnAddFriend, gbc_btnAddFriend);
			
			JButton btnDeleteFriend = new JButton("DELETE FRIEND");
			GridBagConstraints gbc_btnDeleteFriend = new GridBagConstraints();
			gbc_btnDeleteFriend.fill = GridBagConstraints.BOTH;
			gbc_btnDeleteFriend.insets = new Insets(0, 20, 5, 0);
			gbc_btnDeleteFriend.gridx = 1;
			gbc_btnDeleteFriend.gridy = 2;
			optionPanel.add(btnDeleteFriend, gbc_btnDeleteFriend);
			

			gbc_btninfo.insets = new Insets(40, 30, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 4;
			optionPanel.add(btninfo, gbc_btninfo);
			
			gbc_btnBack.insets = new Insets(0, 30, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 5;
			optionPanel.add(btnBack, gbc_btnBack);
			break;
			
		}
	}

	

	
	private void loginview() {
		frame.setSize(450, 300);
		frame.getContentPane().setLayout(null);

		JPanel logiPanel = new JPanel();
		logiPanel.setBackground(new Color(105, 105, 105));
		logiPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(logiPanel);
		GridBagLayout gbl_logiPanel = new GridBagLayout();
		gbl_logiPanel.columnWidths = new int[]{37, 81, 16, 164, 6, 63, 0};
		gbl_logiPanel.rowHeights = new int[]{60, 47, 68, 65, 0};
		gbl_logiPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_logiPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		logiPanel.setLayout(gbl_logiPanel);


		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		logiPanel.add(lblUsername, gbc_lblUsername);
		lblUsername.setBounds(28, 33, 67, 14);

		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.gridx = 3;
		gbc_usernameField.gridy = 1;
		logiPanel.add(usernameField, gbc_usernameField);
		usernameField.setBounds(127, 30, 155, 20);
		usernameField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		logiPanel.add(lblPassword, gbc_lblPassword);
		lblPassword.setBounds(28, 71, 67, 14);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 2;
		logiPanel.add(passwordField, gbc_passwordField);
		passwordField.setBounds(127, 68, 155, 20);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 3;
		logiPanel.add(panel_2, gbc_panel_2);

		JButton btnRegister = new JButton("Register");
		panel_2.add(btnRegister);
		btnRegister.setBounds(20, 11, 85, 45);

		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logiPanel.setVisible(false);
				registerview();
				
				//				frame.dispose();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 3;
		logiPanel.add(panel_1, gbc_panel_1);

		JButton btnLogIn = new JButton("Log In");
		panel_1.add(btnLogIn);
		btnLogIn.setBounds(54, 11, 95, 43);

		btnLogIn.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(true/**LOGEA**/){
					if(true/**Y EL USER ES ADMIN**/){
					logiPanel.setVisible(false);
					state="admingames";
					mainview();
				}else{//NO ES ADMIN
					logiPanel.setVisible(false);
					state="userlibrary";
					mainview();
				}}else{//NO LOGEA
					System.out.println("NO LOGEAS PRINGUADO");
				}
				}
		});
	}

	
		
	public void registerview(){
		frame.setSize(376, 455);
		frame.getContentPane().setLayout(null);

		JPanel registerPanel = new JPanel();
		registerPanel.setBounds(0, 0, 360, 416);
		frame.getContentPane().add(registerPanel);
		registerPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		registerPanel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{63, 106, 151, 0, 0};
		gbl_panel_1.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		panel_1.add(lblUsername, gbc_lblUsername);
		lblUsername.setBounds(23, 30, 83, 16);

		tfUsername = new JTextField();
		GridBagConstraints gbc_tfUsername = new GridBagConstraints();
		gbc_tfUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsername.anchor = GridBagConstraints.NORTH;
		gbc_tfUsername.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsername.gridx = 2;
		gbc_tfUsername.gridy = 1;
		panel_1.add(tfUsername, gbc_tfUsername);
		tfUsername.setBounds(128, 24, 208, 28);
		tfUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		panel_1.add(lblPassword, gbc_lblPassword);
		lblPassword.setBounds(23, 83, 72, 16);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		panel_1.add(passwordField, gbc_passwordField);
		passwordField.setBounds(128, 77, 208, 28);

		JLabel lblEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		panel_1.add(lblEmail, gbc_lblEmail);
		lblEmail.setBounds(23, 151, 55, 16);

		tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmail.anchor = GridBagConstraints.NORTH;
		gbc_tfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_tfEmail.gridx = 2;
		gbc_tfEmail.gridy = 3;
		panel_1.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);
		tfEmail.setBounds(128, 145, 208, 28);

		JPanel panel_2 = new JPanel();
		registerPanel.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{27, 72, 56, 37, 37, 49, 19, 0};
		gbl_panel_2.rowHeights = new int[]{34, 34, 38, 31, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		JLabel lblDate = new JLabel("Birthdate:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 0;
		panel_2.add(lblDate, gbc_lblDate);
		lblDate.setBounds(23, 197, 72, 16);

		JLabel lblDay = new JLabel("Day");
		GridBagConstraints gbc_lblDay = new GridBagConstraints();
		gbc_lblDay.anchor = GridBagConstraints.WEST;
		gbc_lblDay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay.gridx = 2;
		gbc_lblDay.gridy = 1;
		panel_2.add(lblDay, gbc_lblDay);
		lblDay.setBounds(91, 302, 55, 16);

		JComboBox comboDay = new JComboBox();
		GridBagConstraints gbc_comboDay = new GridBagConstraints();
		gbc_comboDay.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboDay.insets = new Insets(0, 0, 5, 5);
		gbc_comboDay.gridx = 3;
		gbc_comboDay.gridy = 1;
		panel_2.add(comboDay, gbc_comboDay);
		comboDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDay.setBounds(231, 297, 62, 26);

		JLabel lblMonth = new JLabel("Month");
		GridBagConstraints gbc_lblMonth = new GridBagConstraints();
		gbc_lblMonth.anchor = GridBagConstraints.WEST;
		gbc_lblMonth.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonth.gridx = 2;
		gbc_lblMonth.gridy = 2;
		panel_2.add(lblMonth, gbc_lblMonth);
		lblMonth.setBounds(91, 263, 55, 16);

		JComboBox comboYear = new JComboBox();
		GridBagConstraints gbc_comboYear = new GridBagConstraints();
		gbc_comboYear.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboYear.insets = new Insets(0, 0, 5, 5);
		gbc_comboYear.gridx = 3;
		gbc_comboYear.gridy = 2;
		panel_2.add(comboYear, gbc_comboYear);
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900"}));
		comboYear.setBounds(210, 219, 83, 26);

		JLabel lblYear = new JLabel("Year");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.anchor = GridBagConstraints.WEST;
		gbc_lblYear.insets = new Insets(0, 0, 0, 5);
		gbc_lblYear.gridx = 2;
		gbc_lblYear.gridy = 3;
		panel_2.add(lblYear, gbc_lblYear);
		lblYear.setBounds(91, 224, 55, 16);

		JComboBox comboMonth = new JComboBox();
		GridBagConstraints gbc_comboMonth = new GridBagConstraints();
		gbc_comboMonth.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboMonth.insets = new Insets(0, 0, 0, 5);
		gbc_comboMonth.gridx = 3;
		gbc_comboMonth.gridy = 3;
		panel_2.add(comboMonth, gbc_comboMonth);
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboMonth.setBounds(188, 258, 105, 26);

		JPanel panel_3 = new JPanel();
		registerPanel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{57, 135, 133, 0};
		gbl_panel_3.rowHeights = new int[]{0, 97, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 1;
		panel_3.add(btnCancel, gbc_btnCancel);
		btnCancel.setBounds(62, 366, 95, 28);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerPanel.setVisible(false);
				loginview();
			}
		});


		JButton btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 1;
		panel_3.add(btnSend, gbc_btnSend);
		btnSend.setBounds(198, 366, 95, 28);

		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int year = Integer.valueOf((String)comboYear.getSelectedItem()) - 1900; 
				int month = Integer.valueOf((String)comboMonth.getSelectedItem()) - 1;
				int day = Integer.valueOf((String)comboDay.getSelectedItem());
				//	register(new Date(year, month, day));
			}
		});

	}

	
	public void addgameview(){
		frame.setSize(450, 600);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, 0, 434, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(93, 23, 46, 14);
		panel.add(lblName);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrice.setBounds(93, 75, 46, 14);
		panel.add(lblPrice);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(39, 123, 100, 14);
		panel.add(lblDescription);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setForeground(new Color(255, 255, 255));
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategory.setBounds(62, 255, 77, 14);
		panel.add(lblCategory);
		
		JLabel lblDesigner = new JLabel("DESIGNER");
		lblDesigner.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesigner.setForeground(new Color(255, 255, 255));
		lblDesigner.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDesigner.setBounds(62, 363, 77, 22);
		panel.add(lblDesigner);
		
		nameField = new JTextField();
		nameField.setBounds(164, 22, 134, 17);
		panel.add(nameField);
		nameField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setBounds(164, 73, 134, 20);
		panel.add(priceField);
		priceField.setColumns(10);
		
		JComboBox categoryCBox = new JComboBox();
		categoryCBox.setBounds(164, 252, 100, 20);
		panel.add(categoryCBox);
		
		JComboBox designerCBox = new JComboBox();
		designerCBox.setBounds(164, 364, 100, 20);
		panel.add(designerCBox);
		
		JComboBox categoryCBoxOpt1 = new JComboBox();
		categoryCBoxOpt1.setBounds(294, 316, 100, 20);
		panel.add(categoryCBoxOpt1);
		
		JComboBox categoryCBoxOpt2 = new JComboBox();
		categoryCBoxOpt2.setBounds(164, 281, 100, 22);
		panel.add(categoryCBoxOpt2);
		
		JComboBox categoryCBoxOpt3 = new JComboBox();
		categoryCBoxOpt3.setBounds(164, 314, 100, 24);
		panel.add(categoryCBoxOpt3);
		
		JComboBox categoryCBoxOpt4 = new JComboBox();
		categoryCBoxOpt4.setBounds(294, 252, 100, 22);
		panel.add(categoryCBoxOpt4);
		
		JComboBox categoryCBoxOpt5 = new JComboBox();
		categoryCBoxOpt5.setBounds(294, 282, 100, 20);
		panel.add(categoryCBoxOpt5);
		
		JComboBox designerCBoxOpt1 = new JComboBox();
		designerCBoxOpt1.setBounds(294, 364, 100, 20);
		panel.add(designerCBoxOpt1);
		
		JComboBox designerCBoxOpt2 = new JComboBox();
		designerCBoxOpt2.setBounds(164, 395, 100, 20);
		panel.add(designerCBoxOpt2);
		
		JComboBox designerCBoxOpt3 = new JComboBox();
		designerCBoxOpt3.setBounds(294, 395, 100, 20);
		panel.add(designerCBoxOpt3);
		
		JTextArea descTArea = new JTextArea();
		descTArea.setBounds(164, 119, 230, 122);
		panel.add(descTArea);
	}


	public void register(PlainUser u){
	}
	public boolean logIn(String username, String password){
		return true;
	}
	public void newRegister(){

	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

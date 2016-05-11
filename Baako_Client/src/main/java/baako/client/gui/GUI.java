package baako.client.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import baako.server.dto.PlainUserDTO;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 



public class GUI {

	protected Logger logger = LoggerFactory.getLogger(GUI.class);
	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	protected JTextField tfUsername;
	protected JTextField tfEmail;
	protected JPasswordField pfpassField;
	private JTextField nameField;
	private JTextField priceField;
	protected JButton btnLogOut;
	protected String user;

	private int state;
	/*0 = adminNews 
	1 = userNews 
	2 = adminGames
	3 = userLibrary 
	4 = userGames 
	5 = userFriends*/
	protected JComboBox<String> categoryCBox;
	protected JComboBox<String> categoryCBoxOpt1;
	protected JComboBox<String> categoryCBoxOpt2;
	protected JComboBox<String> categoryCBoxOpt3;
	protected JComboBox<String> categoryCBoxOpt4;
	protected JComboBox<String> categoryCBoxOpt5;
	protected JComboBox<String> designerCBox; 
	protected JComboBox<String> designerCBoxOpt1; 
	protected JComboBox<String> designerCBoxOpt2; 
	protected JComboBox<String> designerCBoxOpt3; 


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
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\virum\\git\\Baako\\Baako_Server\\src\\main\\images\\bakologo.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		loginview();
		frame.repaint();
		frame.revalidate();
	}

	public void mainview() {
		//		this.state="userfriends";
		frame.setSize(741, 581);
		frame.getContentPane().setLayout(null);

		final JPanel mainPanel_1 = new JPanel();
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
		
		// TODO Add the name of the username to the GUI
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogOut.setBackground(new Color(255, 51, 0));
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 0, 152, 70);
		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainPanel_1.setVisible(false);
				loginview();
			}
		});
		logoutPanel.add(btnLogOut);

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
		case 0:
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
		case 1:

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
		case 2:
			JButton btnAddGame = new JButton("ADD GAME");
			GridBagConstraints gbc_btnAddGame = new GridBagConstraints();
			gbc_btnAddGame.fill = GridBagConstraints.BOTH;
			gbc_btnAddGame.insets = new Insets(0, 35, 5, 0);
			gbc_btnAddGame.gridx = 1;
			gbc_btnAddGame.gridy = 1;
			optionPanel.add(btnAddGame, gbc_btnAddGame);

			btnAddGame.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					mainPanel_1.setVisible(false);
					addgameview();
				}
			});

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
		case 3:
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
		case 4:
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
		case 5:
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

	/**
	 * Changes to login view.
	 */
	private void loginview() {
		frame.setSize(450, 300);
		frame.getContentPane().setLayout(null);

		final JPanel logiPanel = new JPanel();
		logiPanel.setBackground(new Color(105, 105, 105));
		logiPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(logiPanel);
		GridBagLayout gbl_logiPanel = new GridBagLayout();
		gbl_logiPanel.columnWidths = new int[] { 37, 81, 16, 164, 6, 63, 0 };
		gbl_logiPanel.rowHeights = new int[] { 60, 47, 68, 65, 0 };
		gbl_logiPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_logiPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

			public void actionPerformed(ActionEvent e) {
				logiPanel.setVisible(false);
				registerview();
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

			public void actionPerformed(ActionEvent e) {
				if (usernameField.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "The field 'Username' cannot be empty.");
					usernameField.requestFocus();
				} else if (passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(frame, "The field 'password' cannot be empty.");
					passwordField.requestFocus();
				} else if (!logIn(usernameField.getText(), new String(passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(frame, "The login credentials are incorrect. Please, revise them");
				} else {
					logiPanel.setVisible(false);
					state=2;
					mainview();
				}
			}
		});
		frame.repaint();
		frame.revalidate();
	}

	public void registerview() {
		frame.setSize(376, 455);
		frame.getContentPane().setLayout(null);

		final JPanel registerPanel = new JPanel();
		registerPanel.setBounds(0, 0, 360, 416);
		frame.getContentPane().add(registerPanel);
		registerPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		registerPanel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 63, 106, 151, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 20, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
		gbl_panel_2.columnWidths = new int[] { 27, 72, 56, 37, 37, 49, 19, 0 };
		gbl_panel_2.rowHeights = new int[] { 34, 34, 38, 31, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblDate = new JLabel("Birthdate:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 0;
		panel_2.add(lblDate, gbc_lblDate);
		lblDate.setBounds(23, 197, 72, 16);

		final UtilCalendarModel model = new UtilCalendarModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePanel.setBounds(128, 107, 208, 28);
		panel_2.add(datePicker);

		JPanel panel_3 = new JPanel();
		registerPanel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 57, 135, 133, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 97, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
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

			public void actionPerformed(ActionEvent e) {

				//	Validations for the input of text in the registration
				//				if(tfUsername.getText().equals("")){
				//					JOptionPane.showMessageDialog(frame, "The field 'Username' cannot be empty.");
				//					tfUsername.requestFocus();
				//				} else if(tfUsername.getText().length() < 3){
				//					JOptionPane.showMessageDialog(frame, "The username has to be at least 3 characters long.");
				//					tfUsername.requestFocus();
				//				} else if(passwordField.getPassword().length == 0){
				//					JOptionPane.showMessageDialog(frame, "The field 'password' cannot be empty.");
				//					passwordField.requestFocus();
				//				} else if(passwordField.getPassword().length < 6){
				//					JOptionPane.showMessageDialog(frame, "The password has to be at least 6 characters long.");
				//					passwordField.requestFocus();
				//				} else if(tfEmail.getText().equals("")){
				//					JOptionPane.showMessageDialog(frame, "The field 'email' cannot be empty.");
				//					tfEmail.requestFocus();
				//				} else if(!tfEmail.getText().contains("@") || !tfEmail.getText().contains(".") || tfEmail.getText().length() < 5){
				//					JOptionPane.showMessageDialog(frame, "Insert a valid email.");
				//					tfEmail.requestFocus();
				//				} else if(datePicker.getModel().getValue() == null){
				//					JOptionPane.showMessageDialog(frame, "The field 'Birthdate' cannot be empty.");
				//				} else {
				if(register(tfEmail.getText(), tfUsername.getText(), passwordField.getText(), model.getValue().getTime())){
					registerPanel.setVisible(false);
					loginview();
				}
			}
		});
		frame.repaint();
		frame.revalidate();
	}
	
	public void addgameview(){
		frame.setSize(450, 600);
		frame.getContentPane().setLayout(null);
		final JPanel panel = new JPanel();
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

		JLabel lblPEGI = new JLabel("PEGI");
		lblPEGI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPEGI.setForeground(new Color(255, 255, 255));
		lblPEGI.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPEGI.setBounds(93, 120, 46, 14);
		panel.add(lblPEGI);

		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(39, 150, 100, 14);
		panel.add(lblDescription);

		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setForeground(new Color(255, 255, 255));
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategory.setBounds(62, 285, 77, 14);
		panel.add(lblCategory);

		JLabel lblDesigner = new JLabel("DESIGNER");
		lblDesigner.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesigner.setForeground(new Color(255, 255, 255));
		lblDesigner.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDesigner.setBounds(62, 393, 77, 22);
		panel.add(lblDesigner);

		nameField = new JTextField();
		nameField.setBounds(164, 22, 134, 17);
		panel.add(nameField);
		nameField.setColumns(10);

		priceField = new JTextField();
		priceField.setBounds(164, 73, 134, 20);
		panel.add(priceField);
		priceField.setColumns(10);

		final JComboBox<String> pegiCBox = new JComboBox<String>();
		pegiCBox.addItem("3");
		pegiCBox.addItem("7");
		pegiCBox.addItem("12");
		pegiCBox.addItem("16");
		pegiCBox.addItem("18");
		pegiCBox.setBounds(164, 120, 100, 20);
		panel.add(pegiCBox);

		categoryCBox = new JComboBox<String>();
		categoryCBox.insertItemAt("", 0);
		categoryCBox.setBounds(164, 285, 100, 20);
		panel.add(categoryCBox);

		designerCBox = new JComboBox<String>();
		designerCBox.insertItemAt("", 0);
		designerCBox.setBounds(164, 393, 100, 20);
		panel.add(designerCBox);

		categoryCBoxOpt1 = new JComboBox<String>();
		categoryCBoxOpt1.insertItemAt("", 0);
		categoryCBoxOpt1.setBounds(294, 320, 100, 20);
		panel.add(categoryCBoxOpt1);

		categoryCBoxOpt2 = new JComboBox<String>();
		categoryCBoxOpt2.insertItemAt("", 0);
		categoryCBoxOpt2.setBounds(164, 320, 100, 22);
		panel.add(categoryCBoxOpt2);

		categoryCBoxOpt3 = new JComboBox<String>();
		categoryCBoxOpt3.insertItemAt("", 0);
		categoryCBoxOpt3.setBounds(164, 355, 100, 24);
		panel.add(categoryCBoxOpt3);

		categoryCBoxOpt4 = new JComboBox<String>();
		categoryCBoxOpt4.insertItemAt("", 0);
		categoryCBoxOpt4.setBounds(294, 285, 100, 22);
		panel.add(categoryCBoxOpt4);

		categoryCBoxOpt5 = new JComboBox<String>();
		categoryCBoxOpt5.insertItemAt("", 0);
		categoryCBoxOpt5.setBounds(294, 355, 100, 20);
		panel.add(categoryCBoxOpt5);

		designerCBoxOpt1 = new JComboBox<String>();
		designerCBoxOpt1.insertItemAt("", 0);
		designerCBoxOpt1.setBounds(294, 393, 100, 20);
		panel.add(designerCBoxOpt1);

		designerCBoxOpt2 = new JComboBox<String>();
		designerCBoxOpt2.insertItemAt("", 0);
		designerCBoxOpt2.setBounds(164, 420, 100, 20);
		panel.add(designerCBoxOpt2);

		designerCBoxOpt3 = new JComboBox<String>();
		designerCBoxOpt3.insertItemAt("", 0);
		designerCBoxOpt3.setBounds(294, 420, 100, 20);
		panel.add(designerCBoxOpt3);

		final JTextArea descTArea = new JTextArea();
		descTArea.setBounds(164, 150, 230, 122);
		panel.add(descTArea);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(100, 520, 95, 28);
		panel.add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				mainview();
			}
		});

		JButton btnSend = new JButton("Send");
		btnSend.setBounds(300, 520, 95, 28);
		panel.add(btnSend);

		btnSend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int price = Integer.parseInt(priceField.getText());
				logger.info(pegiCBox.getSelectedItem().toString());
				int pegi = Integer.parseInt(pegiCBox.getSelectedItem().toString());
				if(addGame(nameField.getText(), price, descTArea.getText(), pegi)){
					panel.setVisible(false);
					mainview();
				}
			}
		});
		fill();
		frame.repaint();
		frame.revalidate();
	}


	public boolean  register(String email, String username, String password, Date date){
		return true;
	}

	public boolean logIn(String username, String password) {
		return true;
	}
	
	public boolean addGame(String name, int price, String description, int pegi){
		return true;
	}
	
	public void fill(){

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

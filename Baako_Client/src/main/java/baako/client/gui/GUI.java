package baako.client.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import baako.server.database.PlainUser;
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class GUI {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	protected JTextField tfUsername;
	protected JTextField tfEmail;
	protected JPasswordField pfpassField;


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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		loginview();
		frame.repaint();
		frame.revalidate();
	}

	public void mainview(){

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

		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(255, 51, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 0, 152, 50);
		logoutPanel.add(btnNewButton);

		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(new Color(105, 105, 105));
		optionPanel.setBounds(574, 49, 151, 493);
		mainPanel_1.add(optionPanel);
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

			public void actionPerformed(ActionEvent e) {
				logiPanel.setVisible(false);
				registerview();
				//				newRegister();
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

			public void actionPerformed(ActionEvent e) {
				if(usernameField.getText().equals("")){
					JOptionPane.showMessageDialog(frame, "The field 'Username' cannot be empty.");
					usernameField.requestFocus();
				} else if(passwordField.getPassword().length == 0){
					JOptionPane.showMessageDialog(frame, "The field 'password' cannot be empty.");
					passwordField.requestFocus();
				}else if(!logIn(usernameField.getText(), new String(passwordField.getPassword()))){
					JOptionPane.showMessageDialog(frame, "The login credentials are incorrect. Please, revise them");
				} else {
					//					System.out.println("GO");
					frame.dispose();
				}
			}			
		});
		frame.repaint();
	}

	public void registerview(){
		frame.setSize(376, 455);
		frame.getContentPane().setLayout(null);

		final JPanel registerPanel = new JPanel();
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
		
		final UtilCalendarModel model = new UtilCalendarModel();
		net.sourceforge.jdatepicker.impl.JDatePanelImpl datePanel = new net.sourceforge.jdatepicker.impl.JDatePanelImpl(model);
		final net.sourceforge.jdatepicker.impl.JDatePickerImpl datePicker = new net.sourceforge.jdatepicker.impl.JDatePickerImpl(datePanel);
		datePanel.setBounds(128, 107, 208, 28);
		panel_2.add(datePicker);

		
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

			public void actionPerformed(ActionEvent e) {

				//	Validations for the input of text in the registration
				if(tfUsername.getText().equals("")){
					JOptionPane.showMessageDialog(frame, "The field 'Username' cannot be empty.");
					tfUsername.requestFocus();
				} else if(tfUsername.getText().length() < 3){
					JOptionPane.showMessageDialog(frame, "The username has to be at least 3 characters long.");
					tfUsername.requestFocus();
				} else if(passwordField.getPassword().length == 0){
					JOptionPane.showMessageDialog(frame, "The field 'password' cannot be empty.");
					passwordField.requestFocus();
				} else if(passwordField.getPassword().length < 6){
					JOptionPane.showMessageDialog(frame, "The password has to be at least 6 characters long.");
					passwordField.requestFocus();
				} else if(tfEmail.getText().equals("")){
					JOptionPane.showMessageDialog(frame, "The field 'email' cannot be empty.");
					tfEmail.requestFocus();
				} else if(!tfEmail.getText().contains("@") || !tfEmail.getText().contains(".") || tfEmail.getText().length() < 5){
					JOptionPane.showMessageDialog(frame, "Insert a valid email.");
					tfEmail.requestFocus();
				} else if(datePicker.getModel().getValue() == null){
					JOptionPane.showMessageDialog(frame, "The field 'Birthdate' cannot be empty.");
				} else {
					PlainUser user = new PlainUser(tfEmail.getText(), tfUsername.getText(), pfpassField.getPassword().toString(), model.getValue().getTime());
					register(user);
					frame.dispose();
				}

					
			}
		});
		frame.repaint();
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

//class DateLabelFormatter extends AbstractFormatter {
//
//	private static final long serialVersionUID = 1L;
//	private String datePattern = "yyyy-MM-dd";
//	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
//
//	@Override
//	public Object stringToValue(String text) throws ParseException {
//		return dateFormatter.parseObject(text);
//	}
//
//	@Override
//	public String valueToString(Object value) throws ParseException {
//		if (value != null) {
//			Calendar cal = (Calendar) value;
//			return dateFormatter.format(cal.getTime());
//		}
//
//		return "";
//	}
//}
//

package baako.client.gui;

import java.awt.EventQueue;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import baako.server.database.PlainUser;
import javax.swing.JPasswordField;
import javax.swing.JButton;
/**
 * @author Baako-Team
 *
 */
public class LoginWindow {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Baako");
		frame.setBounds(100, 100, 349, 228);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(28, 33, 67, 14);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 71, 67, 14);
		frame.getContentPane().add(lblPassword);

		usernameField = new JTextField();
		usernameField.setBounds(127, 30, 155, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(127, 68, 155, 20);
		frame.getContentPane().add(passwordField);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(61, 131, 89, 23);
		frame.getContentPane().add(btnRegister);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(183, 131, 89, 23);
		frame.getContentPane().add(btnLogIn);

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

		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				newRegister();
				frame.dispose();
			}
		});


	}
	public void register(PlainUser u){
	}
	public boolean logIn(String username, String password){
		return (username.equals("susan"));
	}
	public void newRegister(){

	}
}

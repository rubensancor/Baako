/**
 * 
 */
package baako.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import baako.server.database.PlainUser;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import java.util.Date;

/**
 * @author gusy
 *
 */
public class RegisterWindow {

	protected JFrame frame;
	protected JTextField tfUsername;
	protected JTextField tfEmail;
	protected JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 376, 455);
		frame.setTitle("Baako");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(62, 366, 95, 28);
		frame.getContentPane().add(btnCancel);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(198, 366, 95, 28);
		frame.getContentPane().add(btnSend);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 30, 83, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 83, 72, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(23, 151, 55, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDate = new JLabel("Birthdate:");
		lblDate.setBounds(23, 197, 72, 16);
		frame.getContentPane().add(lblDate);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(128, 24, 208, 28);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(128, 145, 208, 28);
		frame.getContentPane().add(tfEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 77, 208, 28);
		frame.getContentPane().add(passwordField);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(91, 224, 55, 16);
		frame.getContentPane().add(lblYear);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(91, 263, 55, 16);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(91, 302, 55, 16);
		frame.getContentPane().add(lblDay);
		
		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900"}));
		comboYear.setBounds(210, 219, 83, 26);
		frame.getContentPane().add(comboYear);
		
		JComboBox comboMonth = new JComboBox();
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboMonth.setBounds(188, 258, 105, 26);
		frame.getContentPane().add(comboMonth);
		
		JComboBox comboDay = new JComboBox();
		comboDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDay.setBounds(231, 297, 62, 26);
		frame.getContentPane().add(comboDay);
		
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
			}
		});
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int year = Integer.valueOf((String)comboYear.getSelectedItem()) - 1900; 
				int month = Integer.valueOf((String)comboMonth.getSelectedItem()) - 1;
				int day = Integer.valueOf((String)comboDay.getSelectedItem());
				register(new Date(year, month, day));
				frame.dispose();
			}
		});
	}
	public void register(Date birthdate){
	}
}

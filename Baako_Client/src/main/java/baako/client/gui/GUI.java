package baako.client.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import baako.client.controller.BaakoController;
import baako.server.database.CardType;
import baako.server.dto.GameDTO;
import baako.server.dto.NewsDTO;
import baako.server.dto.PlainUserDTO;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import javax.swing.SpringLayout; 

/**
 * @author Baako-Team
 *
 */

public class GUI {

	protected Logger logger = LoggerFactory.getLogger(GUI.class);
	protected BaakoController controller;

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	protected JTextField tfUsername;
	protected JTextField tfEmail;
	protected JPasswordField pfpassField;
	private JTextField nameField;
	private JTextField priceField;
	protected JButton btnLogOut;
	protected PlainUserDTO user;
	protected JLabel thumb;
	protected JTextField searchfield;
	protected boolean admin;
	protected ArrayList<NewsDTO> news;
	protected ArrayList<GameDTO> games;
	protected ArrayList<GameDTO> owned;
	protected ArrayList<PlainUserDTO> people;
	boolean filled;

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
	protected JList<NewsDTO> listNews;
	protected JList<GameDTO> listGames;
	protected JList<GameDTO> listOwned;
	protected JList<PlainUserDTO> listPeople;


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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(200, 100);
		filled = false;
		//frame.setBounds(100, 100, 450, 300);
		//frame.setResizable(false);
		loginview();
		frame.repaint();
		frame.revalidate();
	}

	private void mainview() {

		frame.setSize(741, 581);
		frame.getContentPane().setLayout(null);

		//CREATING MAIN PANEL
		final JPanel mainPanel_1 = new JPanel();
		mainPanel_1.setBounds(0, 0, 725, 542);
		frame.getContentPane().add(mainPanel_1);
		mainPanel_1.setLayout(null);
		//

		//CREATING INITIAL OPTION PANEL (JUST BAAKO ICON)
		final JPanel optionPanel = new JPanel();
		optionPanel.setBackground(new Color(105, 105, 105));
		optionPanel.setBounds(574, 49, 151, 493);
		mainPanel_1.add(optionPanel);

		GridBagLayout gbl_optionPanel = new GridBagLayout();
		gbl_optionPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_optionPanel.rowHeights = new int[]{117, 42, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_optionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_optionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		optionPanel.setLayout(gbl_optionPanel);

		///BAAKO ICON
		JLabel iconlabel = new JLabel("");
		iconlabel.setIcon(new ImageIcon(this.getClass().getResource("/images/bakologo.png")));

		GridBagConstraints gbc_iconlabel = new GridBagConstraints();
		gbc_iconlabel.insets = new Insets(60, 38, 5, 0);
		gbc_iconlabel.gridx = 1;
		gbc_iconlabel.gridy = 10;
		optionPanel.add(iconlabel, gbc_iconlabel);
		///
		//
		
		//CREATING THE MENU BAR
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setBounds(0, 0, 573, 50);
		mainPanel_1.add(menuBar);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(105, 105, 105));

		///MENU ITEM FOR LIBRARY (CHANGES STATE TO 3 IN USER VIEW)
		JMenu libraryMenu = new JMenu("Library");
		libraryMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//If the user is admin he can't have a game library
				//If the user is plain window state will change to 3 
				///and he will access to his videogame library
				if(!admin){
					state=3;
					mainPanel_1.remove(mainPanel_1.findComponentAt(574, 49));
					menuchange(state, mainPanel_1);
				}else{
					JOptionPane.showMessageDialog(frame, "As administrator you can't acces this view, since you cannot own a game library");
				}
				frame.repaint();
				frame.revalidate();
				mainPanel_1.findComponentAt(574, 49).repaint();

			}
		});
		libraryMenu.setForeground(new Color(255, 255, 255));
		libraryMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(libraryMenu);

		///MENU ITEM FOR MARKET (CHANGES STATE TO 2 OR 4)
		JMenu mnMarket = new JMenu("Market");
		mnMarket.setForeground(new Color(255, 255, 255));
		mnMarket.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnMarket);
		mnMarket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//If user is admin the window will change to the market; 
				///The list of all market games in which he/she will be able:
				////Add and edit game entries in the database 
				////Viewing each game's details	
				
				//If the user is plain he will see the same list as admins 
				///but he will have the following options:
				////Buy a game or rent a game
				////Viewing each game's details	
				mainPanel_1.remove(mainPanel_1.findComponentAt(574, 49));
				if(admin){
					state=2;
					menuchange(state, mainPanel_1);
					}else{
						state=4;
						menuchange(state, mainPanel_1);
						}
				frame.repaint();
				frame.revalidate();
				mainPanel_1.findComponentAt(574, 49).repaint();
			}
		});
		
		////SUBMENU OF MARKET THAT ALLOWS US TO SEARCH DESIRED GAMES
		JMenu mnSearchGames = new JMenu("Search Games");
		mnMarket.add(mnSearchGames);

		/////SUBMENU TO SEARCH BY DESIRED CATEGORY
		JMenu mnByCategory = new JMenu("By Category");
		mnByCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainPanel_1.remove(mainPanel_1.findComponentAt(574, 49));
				state=6;
				if(admin){
					searchviews(state, mainPanel_1);
					}else{
						searchviews(state, mainPanel_1);
						}
				frame.repaint();
				frame.revalidate();
				mainPanel_1.findComponentAt(574, 49).repaint();				
			}
		});
		mnSearchGames.add(mnByCategory);
		/////
		
		/////SUBMENU TO SEARCH BY DESIRED DESIGNER
		JMenu mnByDesigner = new JMenu("By Designer");
		mnByDesigner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel_1.remove(mainPanel_1.findComponentAt(574, 49));
				state=7;
				if(admin){
					searchviews(state, mainPanel_1);
					}else{
						searchviews(state, mainPanel_1);
						}
				frame.repaint();
				frame.revalidate();
				mainPanel_1.findComponentAt(574, 49).repaint();

			}
		});
		mnSearchGames.add(mnByDesigner);
		/////
		////

		///MENU ITEM FOR NEWS (CHANGES STATE TO 0 OR 1)
		final JMenu mnNews = new JMenu("News");
		mnNews.setForeground(new Color(255, 255, 255));
		mnNews.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNews);
		mnNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//If user is admin the window will change to the news feed; 
				///The list of all news about games in which he/she will be able:
				////Add and edit pieces of news in the database 
				/////Viewing each entry in detail	
				
				//If the user is plain he will see the same list as admins 
				///but he will have the following options:
				////View each entry ion detail
				
				mainPanel_1.remove(mainPanel_1.findComponentAt(574, 49));
				if(admin){
					state=0;
					menuchange(state, mainPanel_1);
					}else{
						state=1;
						menuchange(state, mainPanel_1);
						}
				frame.repaint();
				frame.revalidate();
				mainPanel_1.findComponentAt(574, 49).repaint();
			}
		});

		///MENU ITEM FOR COMMUNITY (CHANGES STATE TO 5)
		JMenu mnCommunity = new JMenu("Community");
		mnCommunity.setForeground(new Color(255, 255, 255));
		mnCommunity.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnCommunity);
		mnCommunity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//If user is admin he can't access to the community 
				///since member add themselves when they register
				
				//If the user is plain he will see the list of users 
				///and he will have the following options:
				////Add a friend to his friendlist
				/////Delte a friend from gis friendlist
				if(!admin){
					state=5;
					mainPanel_1.remove(mainPanel_1.findComponentAt(574, 49));
					menuchange(state, mainPanel_1);
				}else{
					JOptionPane.showMessageDialog(frame, "View reserved to final users, administrators don't have acces to friend community");
				}
				frame.repaint();
				frame.revalidate();
				mainPanel_1.findComponentAt(574, 49).repaint();
			}
		});
		///
		//


		//CREATING THE LOGOUT PANEL
		JPanel logoutPanel = new JPanel();
		logoutPanel.setBounds(573, 0, 152, 49);
		mainPanel_1.add(logoutPanel);
		logoutPanel.setBackground(new Color(105, 105, 105));
		logoutPanel.setLayout(null);

		btnLogOut = new JButton("LOGOUT");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogOut.setBackground(new Color(255, 51, 0));
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBounds(0, 0, 152, 49);
		btnLogOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
							//Hides the panel and changes the view to the initial login.

				mainPanel_1.setVisible(false);
				loginview();
			}
		});
		logoutPanel.add(btnLogOut);
		if (!filled) {
			fillGames();
			fillNews();
			fillPeople();
			filled = true;
		}
		if (!admin)	fillOwned();
		frame.repaint();
		//
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void menuchange(int state, final JPanel p){

		//LIST OF ELEMENTS IN MAINVIEW
		
		//This is the JList that has to be updated 
		///everytime we need to show a list of something.
		
		switch (state) {
		///NEWS LIST CASES
		case 0:case 1:
			listNews = new JList(news.toArray());
			listNews.setBackground(Color.LIGHT_GRAY);
			listNews.setVisibleRowCount(20);
			listNews.setFont(new Font("Tahoma", Font.PLAIN, 32));
			break;
		///
		
		///GAMES LIST CASES
		case 2:case 4:
			listGames = new JList(games.toArray());
			listGames.setBackground(Color.LIGHT_GRAY);
			listGames.setVisibleRowCount(20);
			listGames.setFont(new Font("Tahoma", Font.PLAIN, 32));
			break;
		///
		
		///OWNEDGAMES LIST CASES
		case 3: 
			listOwned = new JList(owned.toArray());
			listOwned.setBackground(Color.LIGHT_GRAY);
			listOwned.setVisibleRowCount(20);
			listOwned.setFont(new Font("Tahoma", Font.PLAIN, 32));
			break;
		///
		
		case 5:
			listPeople = new JList(people.toArray());
			listPeople.setBackground(Color.LIGHT_GRAY);
			listPeople.setVisibleRowCount(20);
			listPeople.setFont(new Font("Tahoma", Font.PLAIN, 32));
			break;
		default:
			break;
		}
		//
		
		//DECLARING OPTIONPANEL THIS PANEL WILL SHOW 
		//DIFFERENT OPTIONS FOR USER AND ADMINS DEPENDING OF WHAT MAINVIEW THEY'RE IN
		final JPanel optionPanel = new JPanel();
		optionPanel.setBackground(new Color(105, 105, 105));
		optionPanel.setBounds(574, 49, 151, 493);
		p.add(optionPanel);

		GridBagLayout gbl_optionPanel = new GridBagLayout();
		gbl_optionPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_optionPanel.rowHeights = new int[]{117, 42, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_optionPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_optionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		optionPanel.setLayout(gbl_optionPanel);
		//

		//AS BTNINFO AND BTNBACK WILL BE USED IN DIFFERENT OPTIONPANELS
		//WE INITIALIZE THEM HERE AND THEN WE CHANGE THEM DEPENDING ON THE VIEW
		
		//+INFO BUTTON
		final JButton btninfo = new JButton("+INFO");
		btninfo.setBackground(new Color(153, 204, 204));
		GridBagConstraints gbc_btninfo = new GridBagConstraints();
		//
		//BACK BUTTON
		final JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 51, 0));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		//
		
		//CASES FOR THE OPTIONPANEL
		switch(state){

		//ADMINISTRATOR NEWS OPTIONPANEL
		case 0:
		
			//ADDNEWS BUTTON AND HIS ACTION
			final JButton btnAddNews = new JButton("ADD NEWS");
			btnAddNews.setBackground(new Color(50, 205, 50));
			GridBagConstraints gbc_btnAddNews = new GridBagConstraints();
			gbc_btnAddNews.fill = GridBagConstraints.BOTH;
			gbc_btnAddNews.insets = new Insets(0, 25, 5, 0);
			gbc_btnAddNews.gridx = 1;
			gbc_btnAddNews.gridy = 1;
			optionPanel.add(btnAddNews, gbc_btnAddNews);
			btnAddNews.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					p.setVisible(false);
					addnewsview();
				}
			});
			//

			//EDIT NEWS BUTTON AND HIS ACTION
			final JButton btnEditNews = new JButton("EDIT ENTRY");
			btnEditNews.setBackground(new Color(255, 204, 51));
			GridBagConstraints gbc_btnEditNews = new GridBagConstraints();
			gbc_btnEditNews.fill = GridBagConstraints.BOTH;
			gbc_btnEditNews.insets = new Insets(0, 25, 5, 0);
			gbc_btnEditNews.gridx = 1;
			gbc_btnEditNews.gridy = 2;
			optionPanel.add(btnEditNews, gbc_btnEditNews);
			btnEditNews.setEnabled(false);
			btnEditNews.setBackground(new Color(204, 204, 204));

			btnEditNews.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					p.setVisible(false);
					editnewsview();
				}
			});
			//
			
			//INFO BUTTON AND HIS ACTION
			gbc_btninfo.insets = new Insets(40, 25, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 6;
			optionPanel.add(btninfo, gbc_btninfo);
			btninfo.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnEditNews.setEnabled(true);
					btnEditNews.setBackground(new Color(255, 204, 51));
					btnAddNews.setEnabled(false);
					btnAddNews.setBackground(new Color(204, 204, 204));
					btninfo.setEnabled(false);
					btninfo.setBackground(new Color(204, 204, 204));
					btnBack.setEnabled(true);
					btnBack.setBackground(new Color(255, 51, 0));

					p.remove(p.findComponentAt(0,50));

					//HERE WE DECLARE THE BODY OF THE ARTICLE
					JTextArea txtbody = new JTextArea();
					txtbody.setText(listNews.getSelectedValue().getBody());

					final JScrollPane mainPanel = new JScrollPane(txtbody);
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);	

					//HERE WE DECLARE THE TITLE OF THE ARTICLE
					JLabel lblEntryTitle = new JLabel(listNews.getSelectedValue().getTitle());
					lblEntryTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblEntryTitle.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setColumnHeaderView(lblEntryTitle);
					//
					
					//WE REPAINT THE WINDOW
					frame.revalidate();
					p.repaint();
					frame.repaint();
					//
				}
			});
			//
			
			//BACK BUTTON AND HIS ACTION	
			gbc_btnBack.insets = new Insets(0, 25, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 7;
			optionPanel.add(btnBack, gbc_btnBack);
			btnBack.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnEditNews.setEnabled(false);
					btnEditNews.setBackground(new Color(204, 204, 204));
					btnAddNews.setEnabled(true);
					btnAddNews.setBackground(new Color(50, 205, 50));
					btninfo.setEnabled(true);
					btninfo.setBackground(new Color(153, 204, 204));
					btnBack.setEnabled(false);
					btnBack.setBackground(new Color(204, 204, 204));


					p.remove(p.findComponentAt(0,50));

					//HERE WE ADD THE MAINPANEL GOING BACK TO THE LIST
					final JScrollPane mainPanel = new JScrollPane();
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);

					DefaultListCellRenderer renderer = (DefaultListCellRenderer) listNews.getCellRenderer();
					renderer.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setViewportView(listNews);
					//
					
					//WE REPAINT THE FRAME
					frame.revalidate();
					p.repaint();
					frame.repaint();
					//
				}
			});
			btnBack.setEnabled(false);
			btnBack.setBackground(new Color(204, 204, 204));
			//

			//AS DEFALUT WE WANT TO SHOW THE LIST OF NEWS, SO WE DECLARE IT 
			p.remove(p.findComponentAt(0,50));
			//
			
			//ADDING THE CURRENT MAINPANEL
			final JScrollPane mainPanel = new JScrollPane();
			mainPanel.setBounds(0, 48, 574, 494);
			p.add(mainPanel);
			//
			
			//WE ADD THE LIST TO THE MAINPANEL
			DefaultListCellRenderer renderer = (DefaultListCellRenderer) listNews.getCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanel.setViewportView(listNews);
			//
			//
			
			//WE REPAINT THE FRAME
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			break;
			//

			//USER NEWS OPTIONPANEL
		case 1:
		
			//INFO BUTTON AND HIS ACTION
			gbc_btninfo.fill = GridBagConstraints.BOTH;
			gbc_btninfo.insets = new Insets(0, 45, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 1;
			optionPanel.add(btninfo, gbc_btninfo);
			btninfo.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnBack.setEnabled(true);
					btnBack.setBackground(new Color(255, 51, 0));
					btninfo.setEnabled(false);
					btninfo.setBackground(new Color(204, 204, 204));

					p.remove(p.findComponentAt(0,50));

					//HERE WE DECLARE THE BODY OF THE ARTICLE
					JTextArea txtbody = new JTextArea();
					txtbody.setText(listNews.getSelectedValue().getBody());

					final JScrollPane mainPanel = new JScrollPane(txtbody);
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);	
					//

					//HERE WE DECLARE THE TITLE OF THE ARTICLE
					JLabel lblEntryTitle = new JLabel(listNews.getSelectedValue().getTitle());
					lblEntryTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblEntryTitle.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setColumnHeaderView(lblEntryTitle);
					//
					
					//WE REPAINT THE FRAME
					frame.revalidate();
					p.repaint();
					frame.repaint();
					//
				}
			});
			//
			
			//BACK BUTTON AND HIS ACTION
			gbc_btnBack.fill = GridBagConstraints.BOTH;
			gbc_btnBack.insets = new Insets(0, 45, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 2;
			optionPanel.add(btnBack, gbc_btnBack);
			btnBack.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnBack.setEnabled(false);
					btnBack.setBackground(new Color(204, 204, 204));
					btninfo.setEnabled(true);
					btninfo.setBackground(new Color(153, 204, 204));

					p.remove(p.findComponentAt(0,50));

					//HERE WE ADD THE MAINPANEL GOING BACK TO THE LIST
					final JScrollPane mainPanel = new JScrollPane();
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);

					DefaultListCellRenderer renderer = (DefaultListCellRenderer) listNews.getCellRenderer();
					renderer.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setViewportView(listNews);
					//
					
					//REPAINT THE FRAME
					frame.revalidate();
					p.repaint();
					frame.repaint();
					//
				}
			});
			btnBack.setEnabled(false);
			btnBack.setBackground(new Color(204, 204, 204));
			//

			//AS DEFALUT WE WANT TO SHOW THE LIST OF NEWS, SO WE DECLARE IT 
			p.remove(p.findComponentAt(0,50));

			//ADDING THE CURRENT MAINPANEL
			final JScrollPane mainPanel6 = new JScrollPane();
			mainPanel6.setBounds(0, 48, 574, 494);
			p.add(mainPanel6);
			//

			//WE ADD THE LIST TO THE MAINPANEL
			DefaultListCellRenderer renderer6 = (DefaultListCellRenderer) listNews.getCellRenderer();
			renderer6.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanel6.setViewportView(listNews);
			//

			//WE REPAINT THE WINDOW
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			break;
			//

			//ADMINISTRATOR GAME OPTIONPANEL
		case 2:

			//ADDGAME BUTTON AND HIS ACTION
			final JButton btnAddGame = new JButton("ADD GAME");
			btnAddGame.setBackground(new Color(50, 205, 50));
			GridBagConstraints gbc_btnAddGame = new GridBagConstraints();
			gbc_btnAddGame.fill = GridBagConstraints.BOTH;
			gbc_btnAddGame.insets = new Insets(0, 35, 5, 0);
			gbc_btnAddGame.gridx = 1;
			gbc_btnAddGame.gridy = 1;
			optionPanel.add(btnAddGame, gbc_btnAddGame);

			btnAddGame.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					p.setVisible(false);
					addgameview();
				}
			});
			//
			
			//EDITGAME BUTTON AND HIS ACTION
			final JButton btnEditGame = new JButton("EDIT GAME");
			btnEditGame.setBackground(new Color(255, 204, 51));
			GridBagConstraints gbc_btnEditGame = new GridBagConstraints();
			gbc_btnEditGame.fill = GridBagConstraints.BOTH;
			gbc_btnEditGame.insets = new Insets(0, 35, 5, 0);
			gbc_btnEditGame.gridx = 1;
			gbc_btnEditGame.gridy = 2;
			optionPanel.add(btnEditGame, gbc_btnEditGame);
			btnEditGame.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					p.setVisible(false);
					editgameview();
				}
			});
			btnEditGame.setEnabled(false);
			btnEditGame.setBackground(new Color(204, 204, 204));
			//
			
			//INFO BUTTON AND HIS ACTION
			gbc_btninfo.insets = new Insets(40, 45, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 6;
			optionPanel.add(btninfo, gbc_btninfo);
			btninfo.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnEditGame.setEnabled(true);
					btnEditGame.setBackground(new Color(255, 204, 51));
					btnAddGame.setEnabled(false);
					btnAddGame.setBackground(new Color(204, 204, 204));
					btninfo.setEnabled(false);
					btninfo.setBackground(new Color(204, 204, 204));
					btnBack.setEnabled(true);
					btnBack.setBackground(new Color(255, 51, 0));

					p.remove(p.findComponentAt(0,50));

					//HERE WE DECLARE THE BODY OF THE ARTICLE
					JTextArea txtbody = new JTextArea();
					txtbody.setText(listGames.getSelectedValue().getDescription());

					final JScrollPane mainPanel = new JScrollPane(txtbody);
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);	
					//

					//HERE WE DECLARE THE TITLE OF THE ARTICLE
					JLabel lblEntryTitle = new JLabel(listGames.getSelectedValue().getName());
					lblEntryTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblEntryTitle.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setColumnHeaderView(lblEntryTitle);
					//

					//WE REPAINT THE FRAME
					frame.revalidate();
					p.repaint();
					frame.repaint();
					//
				}
			});
			//

			//BACK BUTTON AND HIS ACTION
			gbc_btnBack.insets = new Insets(0, 45, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 7;
			optionPanel.add(btnBack, gbc_btnBack);
			btnBack.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnEditGame.setEnabled(false);	
					btnEditGame.setBackground(new Color(204, 204, 204));
					btnAddGame.setEnabled(true);
					btnAddGame.setBackground(new Color(50, 205, 50));
					btninfo.setEnabled(true);
					btninfo.setBackground(new Color(153, 204, 204));
					btnBack.setEnabled(false);
					btnBack.setBackground(new Color(204, 204, 204));

					p.remove(p.findComponentAt(0,50));

					//HERE WE ADD THE MAINPANEL GOING BACK TO THE LIST
					final JScrollPane mainPanel = new JScrollPane();
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);

					DefaultListCellRenderer renderer = (DefaultListCellRenderer) listGames.getCellRenderer();
					renderer.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setViewportView(listGames);
					//
					
					//WE REPAINT THE FRAME
					frame.revalidate();
					p.repaint();
					frame.repaint();
					//
				}
			});
			btnBack.setEnabled(false);
			btnBack.setBackground(new Color(204, 204, 204));
			//

			//AS DEFALUT WE WANT TO SHOW THE LIST OF NEWS, SO WE DECLARE IT 
			p.remove(p.findComponentAt(0,50));

			//ADDING THE CURRENT MAINPANEL
			final JScrollPane mainPanel5 = new JScrollPane();
			mainPanel5.setBounds(0, 48, 574, 494);
			p.add(mainPanel5);
			//
			
			//WE ADD THE LIST TO THE MAINPANEL
			DefaultListCellRenderer renderer5 = (DefaultListCellRenderer) listGames.getCellRenderer();
			renderer5.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanel5.setViewportView(listGames);
			//
			
			//REPAINTING THE FRAME
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			//
			break;
			//
			
			//USER'S GAME LIBRARY OPTIONPANEL
		case 3:
		
			//LAUNCH BUTTON AND HIS ACTION
			JButton btnLaunch = new JButton("LAUNCH");
			btnLaunch.setBackground(new Color(50, 205, 50));
			GridBagConstraints gbc_btnLaunch = new GridBagConstraints();
			gbc_btnLaunch.fill = GridBagConstraints.BOTH;
			gbc_btnLaunch.insets = new Insets(0, 45, 5, 0);
			gbc_btnLaunch.gridx = 1;
			gbc_btnLaunch.gridy = 1;
			optionPanel.add(btnLaunch, gbc_btnLaunch);
			btnLaunch.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					try {
						Desktop.getDesktop().browse(new java.net.URI(/*"http://www.google.com/search?q="+*/listOwned.getSelectedValue().getUrl()));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}	
				}
			});
			//
			
			//AS DEFALUT WE WANT TO SHOW THE LIST OF NEWS, SO WE DECLARE IT 
			p.remove(p.findComponentAt(0,50));

			//ADDING THE CURRENT MAINPANEL
			final JScrollPane mainPanel4 = new JScrollPane();
			mainPanel4.setBounds(0, 48, 574, 494);
			p.add(mainPanel4);
			//

			//WE ADD THE LIST TO THE MAINPANEL
			DefaultListCellRenderer renderer4 = (DefaultListCellRenderer) listOwned.getCellRenderer();
			renderer4.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanel4.setViewportView(listOwned);
			//

			//REPAINTING THE FRAME
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			//
			break;
			//

			//USER GAMESTORE OPTIONPANEL
		case 4:
		
			//BUY BUTTON AND HIS ACTION
			final JButton btnBuy = new JButton("BUY GAME");
			GridBagConstraints gbc_btnBuy = new GridBagConstraints();
			gbc_btnBuy.fill = GridBagConstraints.BOTH;
			gbc_btnBuy.insets = new Insets(0, 25, 5, 0);
			gbc_btnBuy.gridx = 1;
			gbc_btnBuy.gridy = 1;
			optionPanel.add(btnBuy, gbc_btnBuy);
			btnBuy.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					buy();
				}
			});
			btnBuy.setEnabled(false);
			btnBuy.setBackground(new Color(204, 204, 204));
			
			//+INFO BUTTON AND HIS ACTION
			gbc_btninfo.insets = new Insets(40, 35, 5, 0);
			gbc_btninfo.gridx = 1;
			gbc_btninfo.gridy = 4;
			optionPanel.add(btninfo, gbc_btninfo);
			btninfo.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnBuy.setEnabled(true);
//					btnRent.setEnabled(true);
					btninfo.setEnabled(false);
					btninfo.setBackground(new Color(204, 204, 204));
					btnBack.setEnabled(true);
					btnBack.setBackground(new Color(255, 51, 0));

					p.remove(p.findComponentAt(0,50));

					//HERE WE SET BODY OF THE GAME
					JTextArea txtbody = new JTextArea();
					txtbody.setText(listGames.getSelectedValue().getDescription()+"\nPEGI: +"+listGames.getSelectedValue().getPEGI());

					final JScrollPane mainPanel = new JScrollPane(txtbody);
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);	
					//

					//HERE WE SET THE TITLE OF THE GAME
					JLabel lblEntryTitle = new JLabel(listGames.getSelectedValue().getName());
					lblEntryTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblEntryTitle.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setColumnHeaderView(lblEntryTitle);
					//
					
					//REPAINTING THE FRAME
					frame.revalidate();
					p.repaint();
					frame.repaint();
					//
				}
			});
			//
			
			//BACK BUTTON AND HIS ACTION
			gbc_btnBack.insets = new Insets(0, 35, 5, 0);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 5;
			optionPanel.add(btnBack, gbc_btnBack);
			btnBack.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					btnBuy.setEnabled(false);
					btnBuy.setBackground(new Color(204, 204, 204));
//					btnRent.setEnabled(false);
//					btnRent.setBackground(new Color(204, 204, 204));
					btninfo.setEnabled(true);
					btninfo.setBackground(new Color(153, 204, 204));
					btnBack.setEnabled(false);
					btnBack.setBackground(new Color(204, 204, 204));

					p.remove(p.findComponentAt(0,50));

					//HERE WE DECLARE THE NEW MAINPANEL RETURNING BACK TO THE GAMELIST
					final JScrollPane mainPanel = new JScrollPane();
					mainPanel.setBounds(0, 48, 574, 494);
					p.add(mainPanel);

					DefaultListCellRenderer renderer = (DefaultListCellRenderer) listGames.getCellRenderer();
					renderer.setHorizontalAlignment(SwingConstants.CENTER);
					mainPanel.setViewportView(listGames);
					//
				}
			});
			btnBack.setEnabled(false);
			btnBack.setBackground(new Color(204, 204, 204));
			//
			
			//AS DEFALUT WE WANT TO SHOW THE LIST OF NEWS, SO WE DECLARE IT 
			p.remove(p.findComponentAt(0,50));

			//ADDING THE CURRENT MAINPANEL
			final JScrollPane mainPanel2 = new JScrollPane();
			mainPanel2.setBounds(0, 48, 574, 494);
			p.add(mainPanel2);
			//

			//WE ADD THE LIST TO THE MAINPANEL
			DefaultListCellRenderer renderer2 = (DefaultListCellRenderer) listGames.getCellRenderer();
			renderer2.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanel2.setViewportView(listGames);
			//
			
			//REPAINTING THE FRAME
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			//
			break;
			//
			
			//USER FRIEND OPTIONPANEL
		case 5:
		
			//ADDFRIEND BUTTON AND HIS ACTION
			JButton btnAddFriend = new JButton("ADD FRIEND");
			btnAddFriend.setBackground(new Color(50, 205, 50));
			GridBagConstraints gbc_btnAddFriend = new GridBagConstraints();
			gbc_btnAddFriend.fill = GridBagConstraints.BOTH;
			gbc_btnAddFriend.insets = new Insets(0, 20, 5, 0);
			gbc_btnAddFriend.gridx = 1;
			gbc_btnAddFriend.gridy = 1;
			optionPanel.add(btnAddFriend, gbc_btnAddFriend);
			btnAddFriend.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					//ACTION TO PERFORM
					addFriend(listPeople.getSelectedValue());
					//				
				}
			});
			//
			
			//DELETEFRIEND BUTTON AND HIS ACTION
			JButton btnDeleteFriend = new JButton("DELETE FRIEND");
			btnDeleteFriend.setBackground(new Color(255, 51, 0));
			GridBagConstraints gbc_btnDeleteFriend = new GridBagConstraints();
			gbc_btnDeleteFriend.fill = GridBagConstraints.BOTH;
			gbc_btnDeleteFriend.insets = new Insets(0, 20, 5, 0);
			gbc_btnDeleteFriend.gridx = 1;
			gbc_btnDeleteFriend.gridy = 2;
			optionPanel.add(btnDeleteFriend, gbc_btnDeleteFriend);
			btnDeleteFriend.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
				
					//ACTION TO PERFORM
					deleteFriend(listPeople.getSelectedValue());
					//
				}
			});
			//
			
			//AS DEFALUT WE WANT TO SHOW THE LIST OF NEWS, SO WE DECLARE IT 
			p.remove(p.findComponentAt(0,50));

			//ADDING THE CURRENT MAINPANEL
			final JScrollPane mainPanel3 = new JScrollPane();
			mainPanel3.setBounds(0, 48, 574, 494);
			p.add(mainPanel3);
			//
			
			//WE ADD THE LIST TO THE MAINPANEL
			DefaultListCellRenderer renderer3 = (DefaultListCellRenderer) listNews.getCellRenderer();
			renderer3.setHorizontalAlignment(SwingConstants.CENTER);
			mainPanel3.setViewportView(listNews);
			//
			
			//REPAINTING THE FRAME
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			//
			break;
			//
		}
		frame.revalidate();
		p.repaint();
		frame.repaint();
		}

	private void searchviews( final int state,final JPanel p){
		
		//TWO STATES FOR SEARCH VIEW
		
		switch(state){
		//SEARCH BY CATEGORY MAINPANEL
		case 6:	

			p.remove(p.findComponentAt(0,50));

			//MAKING A NEW MAINPANEL TO ADD OUR SEARCH VIEW
			final JScrollPane mainPanel7 = new JScrollPane();
			mainPanel7.setBounds(0, 48, 574, 494);
			p.add(mainPanel7);
			//
			
			//ADDING OUR SEARCHPANEL
			JPanel searchpanel = new JPanel();
			mainPanel7.setViewportView(searchpanel);
			searchpanel.setLayout(null);

			//TEXTFIELD TO WRITE THE CATEGORY
			searchfield = new JTextField();
			searchfield.setBounds(51, 172, 353, 61);
			searchfield.setFont(new Font("Tahoma", Font.PLAIN, 24));
			searchpanel.add(searchfield);
			searchfield.setColumns(10);
			//

			//TITLE IN THE MAINVIEW
			JLabel lblSearch = new JLabel("SEARCH BY CATEGORY");
			lblSearch.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearch.setBounds(62, 77, 367, 44);
			searchpanel.add(lblSearch);
			//

			//SEARCH BUTTON AND HIS ACTION
			JButton searchButton = new JButton("");
			searchButton.setIcon(new ImageIcon(this.getClass().getResource("/images/lup.png")));
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Code to search games by category
					try {
						controller.searchGamesByCategory(searchfield.getText());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					menuchange(4, p);
				}
			});
			searchButton.setBounds(438, 172, 89, 61);
			searchpanel.add(searchButton);
			//
			
			//REPAINTING THE FRAME
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			break;
			//

			//SEARCH BY DESIGNER MAINPANEL
		case 7:	

			p.remove(p.findComponentAt(0,50));

			//MAKING A NEW MAINPANEL TO ADD OUR SEARCH VIEW
			final JScrollPane mainPanel8 = new JScrollPane();
			mainPanel8.setBounds(0, 48, 574, 494);
			p.add(mainPanel8);

			//ADDING OUR SEARCHPANEL
			JPanel searchpanel2 = new JPanel();
			mainPanel8.setViewportView(searchpanel2);
			searchpanel2.setLayout(null);
			//
			
			//TEXTFIELD TO WRITE THE CATEGORY
			searchfield = new JTextField();
			searchfield.setBounds(51, 172, 353, 61);
			searchfield.setFont(new Font("Tahoma", Font.PLAIN, 24));
			searchpanel2.add(searchfield);
			searchfield.setColumns(10);
			//
			
			//TITLE IN THE MAINVIEW
			JLabel lblSearch2 = new JLabel("SEARCH BY DESIGNER");
			lblSearch2.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblSearch2.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearch2.setBounds(62, 77, 367, 44);
			searchpanel2.add(lblSearch2);
			//
			
			//SEARCH BUTTON AND HIS ACTION
			JButton searchButton2 = new JButton("");
			searchButton2.setIcon(new ImageIcon(this.getClass().getResource("/images/lup.png")));
			searchButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Code to search games by designer
					try {
						controller.searchGamesByCategory(searchfield.getText());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					menuchange(4, p);	
				}
			});
			searchButton2.setBounds(438, 172, 89, 61);
			searchpanel2.add(searchButton2);
			//
			
			//REPAINTING THE MAINPANEL
			frame.revalidate();
			p.repaint();
			frame.repaint();
			//
			break;
			//
		}
	}

	private void loginview() {
		frame.setSize(450, 300);
		frame.getContentPane().setLayout(null);

		thumb = new JLabel();
		thumb.setLocation(0, 0);
		thumb.setSize(434, 261);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/images/logback.jpg"));

		final JPanel logiPanel = new JPanel();
		logiPanel.setBackground(new Color(105, 105, 105, 100));
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
		panel_2.setBackground(new Color(105, 105, 105,0));
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 3;
		logiPanel.add(panel_2, gbc_panel_2);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 204, 51));
		panel_2.add(btnRegister);
		btnRegister.setBounds(20, 11, 85, 45);

		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				logiPanel.setVisible(false);
				frame.remove(thumb);
				registerview();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105,0));
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 3;
		logiPanel.add(panel_1, gbc_panel_1);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBackground(new Color(50, 205, 50));
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
					frame.remove(thumb);
					mainview();
				}
			}
		});
		thumb.setIcon(image);
		frame.getContentPane().add(thumb);
		frame.repaint();
		frame.revalidate();
	}

	private void registerview() {
		frame.setSize(376, 455);
		frame.getContentPane().setLayout(null);

		final JPanel registerPanel = new JPanel();
		registerPanel.setBounds(0, 0, 360, 416);
		frame.getContentPane().add(registerPanel);
		registerPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		registerPanel.add(panel_1);
		panel_1.setBackground(new Color(105, 105, 105));
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 63, 106, 151, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 20, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
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
		lblPassword.setForeground(new Color(255, 255, 255));
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
		lblEmail.setForeground(new Color(255, 255, 255));
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
		panel_2.setBackground(new Color(105, 105, 105));
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 27, 72, 56, 37, 37, 49, 19, 0 };
		gbl_panel_2.rowHeights = new int[] { 34, 34, 38, 31, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblDate = new JLabel("Birthdate:");
		lblDate.setForeground(new Color(255, 255, 255));
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
		panel_3.setBackground(new Color(105, 105, 105));
		gbl_panel_3.columnWidths = new int[] { 57, 135, 133, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 97, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 51, 0));
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
		btnSend.setBackground(new Color(50, 205, 50));
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 1;
		panel_3.add(btnSend, gbc_btnSend);
		btnSend.setBounds(198, 366, 95, 28);

		btnSend.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
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

	private void addgameview(){
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
		btnCancel.setBackground(new Color(255, 51, 0));
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
//				logger.info(pegiCBox.getSelectedItem().toString());
				int pegi = Integer.parseInt(pegiCBox.getSelectedItem().toString());
				if (categoryCBox.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(frame, "The first category field cannot be empty.");
					categoryCBox.requestFocus();
				}else if(designerCBox.getSelectedItem() == null){
					JOptionPane.showMessageDialog(frame, "The first designer field cannot be empty.");
					designerCBox.requestFocus();
				}else if(addGame(nameField.getText(), price, descTArea.getText(), pegi)){
					panel.setVisible(false);
					mainview();
				}
			}
		});
		fill();
		frame.repaint();
		frame.revalidate();
	}

	private void editgameview(){
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
		btnCancel.setBackground(new Color(255, 51, 0));
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

	@SuppressWarnings("unused")
	private void addwalletview(){
		frame.setSize(350, 200);
		final JPanel walletpanel = new JPanel();
		walletpanel.setBackground(new Color(105, 105, 105));
		walletpanel.setSize(350, 200);
		frame.getContentPane().add(walletpanel);
		GridBagLayout gbl_walletpanel = new GridBagLayout();
		gbl_walletpanel.columnWidths = new int[]{0, 0, 20, 142, 0};
		gbl_walletpanel.rowHeights = new int[]{0, 0, 19, 0, 0, 0, 0, 0, 0, 0};
		gbl_walletpanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_walletpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		walletpanel.setLayout(gbl_walletpanel);

		JLabel lblUser = new JLabel("USER: ");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 1;
		walletpanel.add(lblUser, gbc_lblUser);

		JLabel lblUservalue = new JLabel("");
		lblUservalue.setForeground(new Color(220, 220, 220));
		lblUservalue.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblUservalue = new GridBagConstraints();
		gbc_lblUservalue.insets = new Insets(0, 0, 5, 0);
		gbc_lblUservalue.gridx = 3;
		gbc_lblUservalue.gridy = 1;
		walletpanel.add(lblUservalue, gbc_lblUservalue);

		JLabel lblCardType = new JLabel("CARD TYPE: ");
		lblCardType.setForeground(new Color(255, 255, 255));
		lblCardType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCardType.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCardType = new GridBagConstraints();
		gbc_lblCardType.anchor = GridBagConstraints.WEST;
		gbc_lblCardType.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardType.gridx = 1;
		gbc_lblCardType.gridy = 3;
		walletpanel.add(lblCardType, gbc_lblCardType);

		JComboBox<CardType> comboBox = new JComboBox<CardType>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 3;
		walletpanel.add(comboBox, gbc_comboBox);
		comboBox.addItem(CardType.MASTERCARD);
		comboBox.addItem(CardType.VISA);

		JLabel lblCardNumber = new JLabel("CARD NUMBER: ");
		lblCardNumber.setForeground(new Color(255, 255, 255));
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCardNumber.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCardNumber = new GridBagConstraints();
		gbc_lblCardNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardNumber.anchor = GridBagConstraints.EAST;
		gbc_lblCardNumber.gridx = 1;
		gbc_lblCardNumber.gridy = 5;
		walletpanel.add(lblCardNumber, gbc_lblCardNumber);

		JTextField cardNfield = new JTextField();
		GridBagConstraints gbc_cardNfield = new GridBagConstraints();
		gbc_cardNfield.insets = new Insets(0, 0, 5, 0);
		gbc_cardNfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_cardNfield.gridx = 3;
		gbc_cardNfield.gridy = 5;
		walletpanel.add(cardNfield, gbc_cardNfield);
		cardNfield.setColumns(10);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(255, 51, 0));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 7;
		walletpanel.add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				walletpanel.setVisible(false);
				mainview();
			}
		});

		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.setBackground(new Color(50, 205, 50));
		GridBagConstraints gbc_btnAccept = new GridBagConstraints();
		gbc_btnAccept.insets = new Insets(0, 0, 5, 0);
		gbc_btnAccept.gridx = 3;
		gbc_btnAccept.gridy = 7;
		walletpanel.add(btnAccept, gbc_btnAccept);
		btnAccept.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				walletpanel.setVisible(false);
				mainview();
			}
		});
	}

	private void addnewsview(){
		frame.setSize(471, 556);
		frame.getContentPane().setLayout(null);

		final JPanel mainp = new JPanel();
		mainp.setBounds(0, 0, 455, 517);
		frame.getContentPane().add(mainp);
		mainp.setLayout(null);

		JPanel newsfieldspanel = new JPanel();
		newsfieldspanel.setBounds(0, 0, 455, 289);
		mainp.add(newsfieldspanel);
		newsfieldspanel.setBackground(new Color(105, 105, 105));
		GridBagLayout gbl_newsfieldspanel = new GridBagLayout();
		gbl_newsfieldspanel.columnWidths = new int[]{0, 94, 15, 273, 0};
		gbl_newsfieldspanel.rowHeights = new int[]{0, 0, 19, 183, 0};
		gbl_newsfieldspanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_newsfieldspanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		newsfieldspanel.setLayout(gbl_newsfieldspanel);

		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		newsfieldspanel.add(lblTitle, gbc_lblTitle);

		final JTextField titleField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		newsfieldspanel.add(titleField, gbc_textField);
		titleField.setColumns(10);

		JLabel lblBody = new JLabel("BODY");
		lblBody.setForeground(new Color(255, 255, 255));
		lblBody.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBody.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblBody = new GridBagConstraints();
		gbc_lblBody.anchor = GridBagConstraints.EAST;
		gbc_lblBody.insets = new Insets(0, 0, 0, 5);
		gbc_lblBody.gridx = 1;
		gbc_lblBody.gridy = 3;
		newsfieldspanel.add(lblBody, gbc_lblBody);

		final JTextArea bodyArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 3;
		newsfieldspanel.add(bodyArea, gbc_textArea);

		final UtilCalendarModel model = new UtilCalendarModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), 0, SpringLayout.NORTH, datePicker);
		datePicker.setBackground(new Color(105, 105, 105));
		datePicker.setSize(455, 133);
		datePicker.setLocation(0, 422);
		datePanel.setBounds(10, 2, 208, 28);
		mainp.add(datePicker);

		JPanel buttonspanel = new JPanel();
		buttonspanel.setBounds(0, 417, 455, 100);
		mainp.add(buttonspanel);
		buttonspanel.setBackground(new Color(105, 105, 105));
		buttonspanel.setLayout(null);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(255, 51, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(135, 43, 102, 25);
		buttonspanel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				mainp.setVisible(false);
				mainview();
			}
		});

		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.setBackground(new Color(50, 205, 50));

		btnAccept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAccept.setBounds(306, 43, 102, 25);
		buttonspanel.add(btnAccept);
		btnAccept.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				addNews(titleField.getText(), bodyArea.getText(), new Date(2016-1900, 04, 12));
				mainp.setVisible(false);
				mainview();
			}
		});

		frame.repaint();
		frame.revalidate();
	}

	private void editnewsview(){
		frame.setSize(471, 556);
		frame.getContentPane().setLayout(null);

		final JPanel mainp = new JPanel();
		mainp.setBounds(0, 0, 455, 517);
		frame.getContentPane().add(mainp);
		mainp.setLayout(null);

		JPanel newsfieldspanel = new JPanel();
		newsfieldspanel.setBounds(0, 0, 455, 289);
		mainp.add(newsfieldspanel);
		newsfieldspanel.setBackground(new Color(105, 105, 105));
		GridBagLayout gbl_newsfieldspanel = new GridBagLayout();
		gbl_newsfieldspanel.columnWidths = new int[]{0, 94, 15, 273, 0};
		gbl_newsfieldspanel.rowHeights = new int[]{0, 0, 19, 183, 0};
		gbl_newsfieldspanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_newsfieldspanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		newsfieldspanel.setLayout(gbl_newsfieldspanel);

		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		newsfieldspanel.add(lblTitle, gbc_lblTitle);

		JTextField textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		newsfieldspanel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblBody = new JLabel("BODY");
		lblBody.setForeground(new Color(255, 255, 255));
		lblBody.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBody.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblBody = new GridBagConstraints();
		gbc_lblBody.anchor = GridBagConstraints.EAST;
		gbc_lblBody.insets = new Insets(0, 0, 0, 5);
		gbc_lblBody.gridx = 1;
		gbc_lblBody.gridy = 3;
		newsfieldspanel.add(lblBody, gbc_lblBody);

		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 3;
		newsfieldspanel.add(textArea, gbc_textArea);

		final UtilCalendarModel model = new UtilCalendarModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), 0, SpringLayout.NORTH, datePicker);
		datePicker.setBackground(new Color(105, 105, 105));
		datePicker.setSize(455, -133);
		datePicker.setLocation(0, 422);
		datePanel.setBounds(10, 2, 208, 28);
		mainp.add(datePicker);

		JPanel buttonspanel = new JPanel();
		buttonspanel.setBounds(0, 417, 455, 100);
		mainp.add(buttonspanel);
		buttonspanel.setBackground(new Color(105, 105, 105));
		buttonspanel.setLayout(null);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(255, 51, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(135, 43, 102, 25);
		buttonspanel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				mainp.setVisible(false);
				mainview();
			}
		});

		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.setBackground(new Color(50, 205, 50));

		btnAccept.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAccept.setBounds(306, 43, 102, 25);
		buttonspanel.add(btnAccept);
		btnAccept.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				mainp.setVisible(false);
				mainview();
			}
		});

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

	public boolean addNews(String title, String body, Date date){
		return true;
	}

	public void fillNews(){
	}

	public void fillGames(){
	}
	public void fillOwned(){
	}
	
	public void fillPeople(){ }

	public void addFriend(PlainUserDTO newFriend){}
	
	public void deleteFriend(PlainUserDTO oldFriend){}
	
	public boolean buy(){
		return true;}



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

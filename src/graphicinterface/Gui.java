package graphicinterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import database.Adress;
import database.Phone;
import datagestion.VDataGestion;
import datagestion.IDataGestion;
import exceptions.NotSupportedFileException;
import virtualobjects.Calendar;
import virtualobjects.Card;

/**
 * @author Javadoc CHOLLET Alexis
 * @author Class CHOLLET Alexis
 * @author Javadoc CHENET Dorian
 * @author Class CHENET Dorian
 *
 */

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Graphic containers
	 */
	private JPanel contentpane = new JPanel();
	private JPanel searchpanel = new JPanel();
	private JPanel infopanel = new JPanel();
	private JScrollPane databasescrollpane = new JScrollPane(searchpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	/**
	 * File explorer
	 */
	private JFileChooser filechooser = new JFileChooser();

	/**
	 * Databases
	 */
	private VDataGestion datavcf = new VDataGestion();
	private IDataGestion dataics = new IDataGestion();

	/**
	 * Visual components
	 */
	private static final Font TEXT_FIELD_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 16);
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);

	private final String FILEPATH = "src/images";
	
	private Icon searchicon = new ImageIcon(FILEPATH+"/searchicon.png");
	private Icon exporttxticon = new ImageIcon(FILEPATH+"/exporttxticon.png");
	private Icon exporthtmlicon = new ImageIcon(FILEPATH+"/exporthtmlicon.png");
	private Icon exportsericon = new ImageIcon(FILEPATH+"/exportsericon.png");
	private Icon loadfileicon = new ImageIcon(FILEPATH+"/loadfileicon.png");
	private Icon loadfoldericon = new ImageIcon(FILEPATH+"/loadfoldericon.png");
	private Icon newfileicon = new ImageIcon(FILEPATH+"/newfileicon.png");
	private Icon savefileicon = new ImageIcon(FILEPATH+"/savefileicon.png");

	/**
	 * Command panel components
	 */
	private JButton searchbutton = new JButton(searchicon);
	private JButton exporthtmlbutton = new JButton(exporthtmlicon);
	private JButton exportobjectbutton = new JButton(exporttxticon);
	private JButton exportserbutton = new JButton(exportsericon);
	private JButton loadfolderbutton = new JButton(loadfoldericon);
	private JButton loadfilebutton = new JButton(loadfileicon);
	private JButton newfilebutton = new JButton(newfileicon);
	private JButton savefilebutton = new JButton(savefileicon);

	private JComboBox<String> searchbox = new JComboBox<String>();

	private JTextField searchbar = new JTextField(20);

	/**
	 * Information panel text field components
	 */

	private JTextField tcardfirstname = new JTextField(20);
	private JTextField tcardlastname = new JTextField(20);
	private JTextField tcardemail = new JTextField(20);
	private JTextField tcardphonetype = new JTextField(20);
	private JTextField tcardphonenumber = new JTextField(20);
	private JTextField tcardadresstype = new JTextField(20);
	private JTextField tcardadressstreet = new JTextField(20);
	private JTextField tcardadresscity = new JTextField(20);
	private JTextField tcardadressstate = new JTextField(20);
	private JTextField tcardadresspostal = new JTextField(20);
	private JTextField tcardadresscountry = new JTextField(20);
	private JTextField tcardtitle = new JTextField(20);
	private JTextField tcardcivility = new JTextField(20);
	private JTextField tcardcompany = new JTextField(20);

	private JTextField tcalendarname = new JTextField(20);
	private JTextField tcalendarcountry = new JTextField(20);
	private JTextField tcalendarurl = new JTextField(20);
	private JTextField tcalendarsdate1 = new JTextField(20);
	private JTextField tcalendarsdate2 = new JTextField(20);
	private JTextField tcalendarsdate3 = new JTextField(20);
	private JTextField tcalendarfdate1 = new JTextField(20);
	private JTextField tcalendarfdate2 = new JTextField(20);
	private JTextField tcalendarfdate3 = new JTextField(20);
	private JTextField tcalendarplace = new JTextField(20);
	private JTextField tcalendarcity = new JTextField(20);
	private JTextField tcalendarstate = new JTextField(20);
	private JTextArea tcalendarsummary = new JTextArea(5, 50);

	/**
	 * Information panel label components
	 */
	private JLabel cardfirstname = new JLabel();
	private JLabel cardlastname = new JLabel();
	private JLabel cardemail = new JLabel();

	private JLabel cardphone = new JLabel();
	private JLabel cardphonelabel = new JLabel();
	private JLabel cardphonenumber = new JLabel();

	private JLabel cardadress = new JLabel();
	private JLabel cardadresslabel = new JLabel();
	private JLabel cardadressstreet = new JLabel();
	private JLabel cardadresscity = new JLabel();
	private JLabel cardadressstate = new JLabel();
	private JLabel cardadresspostal = new JLabel();
	private JLabel cardadresscountry = new JLabel();
	private JLabel cardtitle = new JLabel();
	private JLabel cardcivility = new JLabel();
	private JLabel cardcompany = new JLabel();

	private JLabel calendarname = new JLabel();
	private JLabel calendarcountry = new JLabel();
	private JLabel calendarurl = new JLabel();
	private JLabel calendarsdate = new JLabel();
	private JLabel calendarfdate = new JLabel();
	private JLabel calendarsummary = new JLabel();
	private JLabel calendarplace = new JLabel();
	private JLabel calendarcity = new JLabel();
	private JLabel calendarstate = new JLabel();

	/**
	 * Label used to debug
	 */
	private JLabel debuglabel = new JLabel();

	/**
	 * GUI constructor Initialize Style first the Layout
	 */
	public Gui() {
		initStyle();

		initLayout();

		initDataBase();

	}

	/**
	 * Initialize the graphic and visual components
	 */
	protected void initStyle() {

		// Panneau de recherche
		searchbar.setFont(TEXT_FIELD_FONT);
		searchbar.setBounds(660, 10, 450, 40);
		searchbar.addActionListener(new SearchAction());
		contentpane.add(searchbar);
		searchpanel.setLayout(new GridLayout(0, 1));

		searchbutton.setFont(font);
		searchbutton.setBounds(620, 10, 40, 40);
		searchbutton.addActionListener(new SearchAction());
		contentpane.add(searchbutton);

		// Selection du format
		searchbox.setFont(font);
		searchbox.addItem("Card");
		searchbox.addItem("Calendar");
		searchbox.addActionListener(new SelectFormatAction());
		searchbox.setBounds(500, 10, 120, 40);
		contentpane.add(searchbox);

		// Panneau de commandes
		exporthtmlbutton.setBounds(120, 10, 40, 40);
		exporthtmlbutton.addActionListener(new ExportHtmlAction());
		contentpane.add(exporthtmlbutton);

		exportobjectbutton.setBounds(160, 10, 40, 40);
		exportobjectbutton.addActionListener(new ExportObjectAction());
		contentpane.add(exportobjectbutton);

		exportserbutton.setBounds(200, 10, 40, 40);
		exportserbutton.addActionListener(new ExportSerAction());
		contentpane.add(exportserbutton);

		loadfilebutton.addActionListener(new LoadFileAction());
		loadfilebutton.setBounds(20, 10, 40, 40);
		contentpane.add(loadfilebutton);

		loadfolderbutton.addActionListener(new LoadDirectoryAction());
		loadfolderbutton.setBounds(60, 10, 40, 40);
		contentpane.add(loadfolderbutton);

		newfilebutton.setBounds(260, 10, 40, 40);
		newfilebutton.addActionListener(new CreateNewObjectAction());
		contentpane.add(newfilebutton);

		savefilebutton.setBounds(300, 10, 40, 40);
		savefilebutton.addActionListener(new SaveModificationsAction());
		contentpane.add(savefilebutton);

		// Champs d'informations
		infopanel.setBounds(20, 110, 600, 420);
		infopanel.setLayout(null);
		contentpane.add(infopanel);

		databasescrollpane.setBounds(660, 110, 450, 420);
		contentpane.add(databasescrollpane);

		debuglabel.setBounds(10, 60, 500, 20);
		contentpane.add(debuglabel);

		displayInfo();
	}

	/**
	 * Initialize the Card information field
	 */
	public void initCardInfo() {
		cardfirstname.setBounds(10, 0, 80, 20);
		cardfirstname.setText("First Name ");
		infopanel.add(cardfirstname);

		cardlastname.setBounds(310, 0, 80, 20);
		cardlastname.setText("Last Name ");
		infopanel.add(cardlastname);

		cardtitle.setBounds(10, 40, 80, 20);
		cardtitle.setText("Title ");
		infopanel.add(cardtitle);

		cardcivility.setBounds(310, 40, 80, 20);
		cardcivility.setText("Civility ");
		infopanel.add(cardcivility);

		cardemail.setBounds(10, 80, 80, 20);
		cardemail.setText("Email ");
		infopanel.add(cardemail);

		cardcompany.setBounds(310, 80, 80, 20);
		cardcompany.setText("Company ");
		infopanel.add(cardcompany);

		cardphone.setBounds(10, 160, 80, 20);
		cardphone.setText("Phone");
		infopanel.add(cardphone);

		cardphonelabel.setBounds(90, 160, 80, 20);
		cardphonelabel.setText("Label");
		infopanel.add(cardphonelabel);

		cardphonenumber.setBounds(90, 200, 80, 20);
		cardphonenumber.setText("Number ");
		infopanel.add(cardphonenumber);

		cardadress.setBounds(10, 280, 80, 20);
		cardadress.setText("Adress");
		infopanel.add(cardadress);

		cardadresslabel.setBounds(90, 280, 80, 20);
		cardadresslabel.setText("Label");
		infopanel.add(cardadresslabel);

		cardadressstreet.setBounds(90, 320, 80, 20);
		cardadressstreet.setText("Street ");
		infopanel.add(cardadressstreet);

		cardadresspostal.setBounds(90, 360, 80, 20);
		cardadresspostal.setText("Postal ");
		infopanel.add(cardadresspostal);

		cardadresscity.setBounds(310, 360, 80, 20);
		cardadresscity.setText("City ");
		infopanel.add(cardadresscity);

		cardadressstate.setBounds(90, 400, 80, 20);
		cardadressstate.setText("State ");
		infopanel.add(cardadressstate);

		cardadresscountry.setBounds(310, 400, 80, 20);
		cardadresscountry.setText("Country ");
		infopanel.add(cardadresscountry);

		// Affichage zone de texte
		tcardfirstname.setFont(TEXT_FIELD_FONT);
		tcardfirstname.setBounds(90, 0, 180, 20);
		infopanel.add(tcardfirstname);

		tcardlastname.setFont(TEXT_FIELD_FONT);
		tcardlastname.setBounds(390, 0, 180, 20);
		infopanel.add(tcardlastname);

		tcardcivility.setFont(TEXT_FIELD_FONT);
		tcardcivility.setBounds(90, 40, 180, 20);
		infopanel.add(tcardcivility);

		tcardtitle.setFont(TEXT_FIELD_FONT);
		tcardtitle.setBounds(390, 40, 180, 20);
		infopanel.add(tcardtitle);

		tcardemail.setFont(TEXT_FIELD_FONT);
		tcardemail.setBounds(90, 80, 180, 20);
		infopanel.add(tcardemail);

		tcardcompany.setFont(TEXT_FIELD_FONT);
		tcardcompany.setBounds(390, 80, 180, 20);
		infopanel.add(tcardcompany);

		tcardphonetype.setFont(TEXT_FIELD_FONT);
		tcardphonetype.setBounds(160, 160, 410, 20);
		infopanel.add(tcardphonetype);

		tcardphonenumber.setFont(TEXT_FIELD_FONT);
		tcardphonenumber.setBounds(160, 200, 410, 20);
		infopanel.add(tcardphonenumber);

		tcardadresstype.setFont(TEXT_FIELD_FONT);
		tcardadresstype.setBounds(160, 280, 410, 20);
		infopanel.add(tcardadresstype);

		tcardadressstreet.setFont(TEXT_FIELD_FONT);
		tcardadressstreet.setBounds(160, 320, 410, 20);
		infopanel.add(tcardadressstreet);

		tcardadresspostal.setFont(TEXT_FIELD_FONT);
		tcardadresspostal.setBounds(160, 360, 120, 20);
		infopanel.add(tcardadresspostal);

		tcardadresscity.setFont(TEXT_FIELD_FONT);
		tcardadresscity.setBounds(390, 360, 180, 20);
		infopanel.add(tcardadresscity);

		tcardadressstate.setFont(TEXT_FIELD_FONT);
		tcardadressstate.setBounds(160, 400, 120, 20);
		infopanel.add(tcardadressstate);

		tcardadresscountry.setFont(TEXT_FIELD_FONT);
		tcardadresscountry.setBounds(390, 400, 180, 20);
		infopanel.add(tcardadresscountry);

	}

	/**
	 * Initialize the Calendar information field
	 */
	public void initCalendarInfo() {
		// Affichage Calendar

		calendarsdate.setBounds(10, 0, 400, 20);
		calendarsdate.setText("From the");
		infopanel.add(calendarsdate);

		calendarfdate.setBounds(270, 0, 400, 20);
		calendarfdate.setText("to the");
		infopanel.add(calendarfdate);

		calendarname.setBounds(10, 40, 80, 20);
		calendarname.setText("With");
		infopanel.add(calendarname);

		calendarplace.setBounds(310, 80, 80, 20);
		calendarplace.setText("Place");
		infopanel.add(calendarplace);

		calendarcity.setBounds(10, 80, 80, 20);
		calendarcity.setText("City");
		infopanel.add(calendarcity);

		calendarcountry.setBounds(10, 120, 80, 20);
		calendarcountry.setText("Country");
		infopanel.add(calendarcountry);

		calendarstate.setBounds(310, 120, 80, 20);
		calendarstate.setText("State");
		infopanel.add(calendarstate);

		calendarurl.setBounds(10, 180, 80, 20);
		calendarurl.setText("URL");
		infopanel.add(calendarurl);

		calendarsummary.setBounds(10, 220, 80, 20);
		calendarsummary.setText("Summary");
		infopanel.add(calendarsummary);

		// TextField
		tcalendarsdate1.setFont(TEXT_FIELD_FONT);
		tcalendarsdate1.setBounds(100, 0, 35, 20);
		infopanel.add(tcalendarsdate1);

		tcalendarsdate2.setFont(TEXT_FIELD_FONT);
		tcalendarsdate2.setBounds(150, 0, 35, 20);
		infopanel.add(tcalendarsdate2);

		tcalendarsdate3.setFont(TEXT_FIELD_FONT);
		tcalendarsdate3.setBounds(200, 0, 35, 20);
		infopanel.add(tcalendarsdate3);

		tcalendarfdate1.setFont(TEXT_FIELD_FONT);
		tcalendarfdate1.setBounds(350, 0, 35, 20);
		infopanel.add(tcalendarfdate1);

		tcalendarfdate2.setFont(TEXT_FIELD_FONT);
		tcalendarfdate2.setBounds(400, 0, 35, 20);
		infopanel.add(tcalendarfdate2);

		tcalendarfdate3.setFont(TEXT_FIELD_FONT);
		tcalendarfdate3.setBounds(450, 0, 35, 20);
		infopanel.add(tcalendarfdate3);

		tcalendarname.setFont(TEXT_FIELD_FONT);
		tcalendarname.setBounds(90, 40, 460, 20);
		infopanel.add(tcalendarname);

		tcalendarplace.setFont(TEXT_FIELD_FONT);
		tcalendarplace.setBounds(90, 80, 180, 20);
		infopanel.add(tcalendarplace);

		tcalendarcity.setFont(TEXT_FIELD_FONT);
		tcalendarcity.setBounds(370, 80, 180, 20);
		infopanel.add(tcalendarcity);

		tcalendarstate.setFont(TEXT_FIELD_FONT);
		tcalendarstate.setBounds(90, 120, 180, 20);
		infopanel.add(tcalendarstate);

		tcalendarcountry.setFont(TEXT_FIELD_FONT);
		tcalendarcountry.setBounds(370, 120, 180, 20);
		infopanel.add(tcalendarcountry);

		tcalendarurl.setFont(TEXT_FIELD_FONT);
		tcalendarurl.setBounds(90, 180, 460, 20);
		infopanel.add(tcalendarurl);

		tcalendarsummary.setFont(TEXT_FIELD_FONT);
		tcalendarsummary.setBounds(10, 250, 540, 280);
		infopanel.add(tcalendarsummary);
	}

	/**
	 * Initialize the databases
	 */
	protected void initDataBase() {
		datavcf.setSelectedCard(new Card());
		dataics.setSelectedCalendar(new Calendar());
	}

	/**
	 * Initialize the layout and window
	 */
	protected void initLayout() {
		JFrame frame = new JFrame();
		frame.setTitle("Utilitaire ics/vcf");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setSize(1200, 600);
		frame.setContentPane(contentpane);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Action performed by clicking the "New File" button (newfilebutton).
	 * Resets the text fields of the information panel
	 */
	private class CreateNewObjectAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (searchbox.getSelectedItem().equals("Card")) {

				Card card = new Card();
				datavcf.setSelectedCard(card);

				tcardfirstname.setText("");
				tcardlastname.setText("");
				tcardtitle.setText("");
				tcardcivility.setText("");
				tcardemail.setText("");
				tcardcompany.setText("");

				tcardphonetype.setText("");
				tcardphonenumber.setText("");

				tcardadresscity.setText("");
				tcardadressstate.setText("");
				tcardadressstreet.setText("");
				tcardadresscountry.setText("");
				tcardadresspostal.setText("");
				tcardadresstype.setText("");

			}

			else if (searchbox.getSelectedItem().equals("Calendar")) {

				Calendar calendar = new Calendar();
				dataics.setSelectedCalendar(calendar);

				tcalendarname.setText("");
				tcalendarcountry.setText("");
				tcalendarurl.setText("");
				tcalendarsdate1.setText("");
				tcalendarsdate2.setText("");
				tcalendarsdate3.setText("");
				tcalendarfdate1.setText("");
				tcalendarfdate2.setText("");
				tcalendarfdate3.setText("");
				tcalendarplace.setText("");
				tcalendarcity.setText("");
				tcalendarstate.setText("");
				tcalendarsummary.setText("");
			}

		}
	}

	/**
	 * Action performed by clicking the "Save Modifications" button
	 * (savefilebutton). Sets the attributes of the selected file with the text
	 * fields entries. Redisplays the files stocked in the database.
	 */
	private class SaveModificationsAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (searchbox.getSelectedItem().equals("Card")) {

				datavcf.modifyFirstNameSelectedCard(tcardfirstname.getText());
				datavcf.modifyLastNameSelectedCard(tcardlastname.getText());
				datavcf.modifyEmailSelectedCard(tcardemail.getText());
				datavcf.modifyCivilitySelectedCard(tcardcivility.getText());
				datavcf.modifyCompanySelectedCard(tcardcompany.getText());
				datavcf.modifyTitleSelectedCard(tcardtitle.getText());
				datavcf.modifyPhoneSelectedCard(new Phone(tcardphonetype.getText(), tcardphonenumber.getText()));
				datavcf.modifyAdressSelectedCard(
						new Adress(tcardadresstype.getText(), tcardadressstreet.getText(), tcardadresscity.getText(),
								tcardadressstate.getText(), tcardadresspostal.getText(), tcardadresscountry.getText()));

				datavcf.add(datavcf.getSelectedCard());

				displayDataBase();

			}

			else if (searchbox.getSelectedItem().equals("Calendar")) {

				dataics.modifyNameSelectedCalendar(tcalendarname.getText());
				dataics.modifyCountrySelectedCalendar(tcalendarcountry.getText());
				dataics.modifyStateSelectedCalendar(tcalendarstate.getText());
				dataics.modifyCitySelectedCalendar(tcalendarcity.getText());
				dataics.modifyPlaceSelectedCalendar(tcalendarplace.getText());
				dataics.modifySummarySelectedCalendar(tcalendarsummary.getText());
				dataics.modifyUrlSelectedCalendar(tcalendarurl.getText());
				dataics.modifySDateSelectedCalendar(tcalendarsdate1.getText(), tcalendarsdate2.getText(),
						tcalendarsdate3.getText());
				dataics.modifyFDateSelectedCalendar(tcalendarfdate1.getText(), tcalendarfdate2.getText(),
						tcalendarfdate3.getText());

				dataics.add(dataics.getSelectedCalendar());

				displayDataBase();
			}

		}

	}

	/**
	 * Action performed by clicking a "File" (filebutton) in the "Database"
	 * panel (databasescrollpane). Takes index from filebutton Displays the
	 * informations of the corresponding object in the text fields.
	 */
	private class SelectObjectAction implements ActionListener {

		int index;

		public SelectObjectAction(int index) {
			this.index = index;
		}

		public void actionPerformed(ActionEvent e) {

			if (searchbox.getSelectedItem().equals("Card")) {

				ArrayList<Card> data = new ArrayList<Card>();

				if (datavcf.getSearchResults().size() > 0) {
					data = datavcf.getSearchResults();
					datavcf.setSelectedCard(datavcf.getSearchResults().get(index));
				}

				else {
					data = datavcf.getDataBase();
					datavcf.setSelectedCard(index);
				}

				tcardfirstname.setText(data.get(index).getContact().getFirstName());
				tcardlastname.setText(data.get(index).getContact().getLastName());
				tcardtitle.setText(data.get(index).getContact().getTitle());
				tcardcivility.setText(data.get(index).getContact().getCivility());
				tcardemail.setText(data.get(index).getContact().geteMail());
				tcardcompany.setText(data.get(index).getContact().getCompany());

				tcardphonetype.setText(data.get(index).getContact().getPhone().getPlace());
				tcardphonenumber.setText(data.get(index).getContact().getPhone().getNumber());

				tcardadresstype.setText(data.get(index).getContact().getAdress().getType());
				tcardadressstreet.setText(data.get(index).getContact().getAdress().getStreet());
				tcardadresscity.setText(data.get(index).getContact().getAdress().getCity());
				tcardadresscountry.setText(data.get(index).getContact().getAdress().getCountry());
				tcardadresspostal.setText(data.get(index).getContact().getAdress().getPostal());
				tcardadressstate.setText(data.get(index).getContact().getAdress().getState());
			}

			else if (searchbox.getSelectedItem().equals("Calendar")) {

				ArrayList<Calendar> data = new ArrayList<Calendar>();

				if (dataics.getSearchResults().size() > 0) {
					data = dataics.getSearchResults();
					dataics.setSelectedCalendar(dataics.getSearchResults().get(index));
				}

				else {
					data = dataics.getDataBase();
					dataics.setSelectedCalendar(index);
				}

				tcalendarname.setText(data.get(index).getProdid().getName());
				tcalendarcountry.setText(data.get(index).getProdid().getCountry());
				tcalendarurl.setText(data.get(index).getVevent().getUrl());
				tcalendarsdate1.setText(data.get(index).getVevent().getSdate().getDay());
				tcalendarsdate2.setText(data.get(index).getVevent().getSdate().getMonth());
				tcalendarsdate3.setText(data.get(index).getVevent().getSdate().getYear());
				tcalendarfdate1.setText(data.get(index).getVevent().getFdate().getDay());
				tcalendarfdate2.setText(data.get(index).getVevent().getFdate().getMonth());
				tcalendarfdate3.setText(data.get(index).getVevent().getFdate().getYear());
				tcalendarplace.setText(data.get(index).getVevent().getLocation().getPlace());
				tcalendarcity.setText(data.get(index).getVevent().getLocation().getCity());
				tcalendarstate.setText(data.get(index).getVevent().getLocation().getState());
				tcalendarsummary.setText(data.get(index).getVevent().getSummary());
			}
		}
	}

	/**
	 * Action performed by selecting the desired object type to display in the
	 * "Format box" (formatbox). Repaints the database field and information
	 * field.
	 */
	private class SelectFormatAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			displayDataBase();
			displayInfo();
		}
	}

	/**
	 * Action performed by clicking the "Export file as html fragment" button
	 * (exporthtmlbutton). Exports the selected object to the desired folder as
	 * an html text file.
	 */
	private class ExportHtmlAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			filechooser.resetChoosableFileFilters();

			FileFilter htmlfilter = new FileNameExtensionFilter("Digital Document", ".html");
			filechooser.setFileFilter(htmlfilter);

			if (searchbox.getSelectedItem().equals("Card")) {
				Card card = datavcf.getSelectedCard();

				if (card != null) {

					File defaultfile = new File(
							card.getContact().getFirstName() + "_" + card.getContact().getLastName() + ".html");
					filechooser.setSelectedFile(defaultfile);

					int option = filechooser.showSaveDialog(exporthtmlbutton);

					if (option == JFileChooser.APPROVE_OPTION) {

						String directory = filechooser.getSelectedFile().getAbsolutePath();

						directory = validateExtension(directory, ".html");

						card.exportTextFile(card.getHtmlFragment(), directory);
						debuglabel.setText("Exported at " + directory);
					}
				}

			}

			else if (searchbox.getSelectedItem().equals("Calendar")) {
				Calendar calendar = dataics.getSelectedCalendar();

				if (calendar != null) {

					File defaultfile = new File(calendar.getProdid().getName() + "_"
							+ calendar.getVevent().getSdate().getFullDate() + ".html");
					filechooser.setSelectedFile(defaultfile);

					int option = filechooser.showSaveDialog(exporthtmlbutton);

					if (option == JFileChooser.APPROVE_OPTION) {

						String directory = filechooser.getSelectedFile().getAbsolutePath();

						directory = validateExtension(directory, ".html");

						calendar.exportTextFile(calendar.getHtmlFragment(), directory);
						debuglabel.setText("Exported at " + directory);
					}

				}
			}

		}
	}

	/**
	 * Action performed by clicking the "Export as vcf/ics" button
	 * (exportobjectbutton). Exports the selected object into a .vcf/.ics text
	 * file.
	 */
	private class ExportObjectAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			if (searchbox.getSelectedItem().equals("Card")) {
				Card card = datavcf.getSelectedCard();

				filechooser.resetChoosableFileFilters();

				FileFilter cardfilter = new FileNameExtensionFilter("VCard", ".vcf");
				filechooser.setFileFilter(cardfilter);

				if (card != null) {

					File defaultfile = new File(
							card.getContact().getFirstName() + "_" + card.getContact().getLastName() + ".vcf");
					filechooser.setSelectedFile(defaultfile);

					int option = filechooser.showSaveDialog(exporthtmlbutton);

					if (option == JFileChooser.APPROVE_OPTION) {

						String directory = filechooser.getSelectedFile().getAbsolutePath();

						directory = validateExtension(directory, ".vcf");

						card.exportTextFile(card.toString(), directory);
						debuglabel.setText("Exported at " + directory);
					}
				}

			}

			else if (searchbox.getSelectedItem().equals("Calendar")) {
				Calendar calendar = dataics.getSelectedCalendar();

				filechooser.resetChoosableFileFilters();

				FileFilter calendarfilter = new FileNameExtensionFilter("ICalendar", ".ics");
				filechooser.setFileFilter(calendarfilter);

				if (calendar != null) {

					File defaultfile = new File(calendar.getProdid().getName() + "_"
							+ calendar.getVevent().getSdate().getFullDate() + ".ics");
					filechooser.setSelectedFile(defaultfile);

					int option = filechooser.showSaveDialog(exporthtmlbutton);

					if (option == JFileChooser.APPROVE_OPTION) {

						String directory = filechooser.getSelectedFile().getAbsolutePath();

						directory = validateExtension(directory, ".ics");

						calendar.exportTextFile(calendar.toString(), directory);
						debuglabel.setText("Exported at " + directory);
					}

				}
			}

		}
	}

	/*
	 * Action performed by clicking the "Export as binary file" button
	 * (exportserbutton). Exports the selected object into a binary .ser file.
	 */
	private class ExportSerAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			filechooser.resetChoosableFileFilters();

			FileFilter binaryfilter = new FileNameExtensionFilter("Binary File", ".ser");
			filechooser.setFileFilter(binaryfilter);

			if (searchbox.getSelectedItem().equals("Card")) {
				Card card = datavcf.getSelectedCard();

				if (card != null) {

					File defaultfile = new File(
							card.getContact().getFirstName() + "_" + card.getContact().getLastName() + ".ser");
					filechooser.setSelectedFile(defaultfile);

					int option = filechooser.showSaveDialog(exporthtmlbutton);

					if (option == JFileChooser.APPROVE_OPTION) {

						String directory = filechooser.getSelectedFile().getAbsolutePath();

						directory = validateExtension(directory, ".ser");

						card.exportSerFile(directory);
						debuglabel.setText("Exported at " + directory);
					}
				}

			}

			else if (searchbox.getSelectedItem().equals("Calendar")) {
				Calendar calendar = dataics.getSelectedCalendar();

				if (calendar != null) {

					File defaultfile = new File(calendar.getProdid().getName() + "_"
							+ calendar.getVevent().getSdate().getFullDate() + ".ser");
					filechooser.setSelectedFile(defaultfile);

					int option = filechooser.showSaveDialog(exporthtmlbutton);

					if (option == JFileChooser.APPROVE_OPTION) {

						String directory = filechooser.getSelectedFile().getAbsolutePath();

						directory = validateExtension(directory, ".ser");

						calendar.exportSerFile(directory);
						debuglabel.setText("Exported at " + directory);
					}

				}
			}

		}
	}

	/**
	 * Action performed by clicking the "Load file from directory" button
	 * (loadfilebutton). Imports the chosen .vcf/.ics file into the database.
	 */
	private class LoadFileAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			filechooser.resetChoosableFileFilters();

			FileFilter htmlfilter = new FileNameExtensionFilter("Digital Document", ".html");
			filechooser.addChoosableFileFilter(htmlfilter);
			FileFilter cardfilter = new FileNameExtensionFilter("VCard", ".vcf");
			filechooser.addChoosableFileFilter(cardfilter);
			FileFilter calendarfilter = new FileNameExtensionFilter("ICalendar", ".ics");
			filechooser.addChoosableFileFilter(calendarfilter);
			FileFilter binaryfilter = new FileNameExtensionFilter("Binary File", ".ser");
			filechooser.addChoosableFileFilter(binaryfilter);

			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int option = filechooser.showOpenDialog(loadfilebutton);
			loadFile(option);
		}
	}

	/**
	 * Action performed by clicking the "Load directory" button
	 * (loaddirectorybutton). Imports every .vcf/.ics files into the database
	 * from the selected folder.
	 */
	private class LoadDirectoryAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int option = filechooser.showOpenDialog(loadfolderbutton);
			loadDirectory(option);
		}
	}

	/**
	 * Action performed by clicking the "Search" button (searchbutton) and by
	 * pressing the Enter key in the "Search bar" (searchbar). Searches the
	 * objects matching with the search query in the database. Displays the
	 * results in the "Database" panel (databasescrollpane).If no search query
	 * is entered, displays all the objects in the database of the selected
	 * type.
	 */
	private class SearchAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String searchquery = searchbar.getText();
			if (searchquery.equals("")) {

				displayDataBase();
				datavcf.clearSearchResults();
				dataics.clearSearchResults();

			} else {

				if (searchbox.getSelectedItem().equals("Card")) {

					int index = 0;
					datavcf.search(searchquery);
					searchpanel.removeAll();

					for (Card card : datavcf.getSearchResults()) {
						JButton resultbutton = new JButton(
								card.getContact().getFirstName() + " " + card.getContact().getLastName());
						resultbutton.addActionListener(new SelectObjectAction(index));
						searchpanel.add(resultbutton);
						index++;
					}
				}

				else if (searchbox.getSelectedItem().equals("Calendar")) {

					int index = 0;
					dataics.search(searchquery);
					searchpanel.removeAll();

					for (Calendar calendar : dataics.getSearchResults()) {
						JButton resultbutton = new JButton(
								calendar.getProdid().getName() + " " + calendar.getVevent().getSdate().getYear() + "/"
										+ calendar.getVevent().getSdate().getMonth() + "/"
										+ calendar.getVevent().getSdate().getDay());
						resultbutton.addActionListener(new SelectObjectAction(index));
						searchpanel.add(resultbutton);
						index++;
					}
				}

				searchbar.revalidate();
				searchbar.repaint();
				searchpanel.revalidate();
				searchpanel.repaint();
			}
		}
	}

	/**
	 * Procedure loading the selected .ser/.vcf/.ics file into the database.
	 * 
	 * @catch NotSupportedFile exception
	 * @param option
	 */
	public void loadFile(int option) {

		if (option == JFileChooser.APPROVE_OPTION) {

			String directory = filechooser.getSelectedFile().getAbsolutePath();
			debuglabel.setText("Imported " + directory);
			File file = new File(directory);

			try {

				if (searchbox.getSelectedItem().equals("Card")) {
					if (file.getName().endsWith(".ser")) {
						datavcf.loadSerFile(directory);
					}
				}

				else if (searchbox.getSelectedItem().equals("Calendar")) {
					if (file.getName().endsWith(".ser")) {
						dataics.loadSerFile(directory);
					}
				}

				if (file.getName().endsWith(".vcf")) {
					datavcf.loadFile(file);
				}

				if (file.getName().endsWith(".ics")) {
					dataics.loadFile(file);
				}

				displayDataBase();
			} catch (NotSupportedFileException e1) {
				// TODO Auto-generated catch block
				debuglabel.setText(e1.getMessage());
			}
		}
	}

	/**
	 * Procedure loading every .vcf/.ics files contained into a folder.
	 * 
	 * @param option
	 */
	public void loadDirectory(int option) {

		if (option == JFileChooser.APPROVE_OPTION) {

			String directory = filechooser.getSelectedFile().getAbsolutePath();
			File file = new File(directory);

			try {
				datavcf.loadDirectory(file);
				dataics.loadDirectory(file);

				displayDataBase();

				debuglabel.setText("Imported from " + file.getAbsolutePath());
			} catch (NotSupportedFileException e) {
				// TODO Auto-generated catch block
				debuglabel.setText(e.getMessage());
			}
		}
	}

	/**
	 * Procedure repainting the "Database" panel (databasescrollpane).
	 */
	public void displayDataBase() {

		int index = 0;
		searchpanel.removeAll();

		if (searchbox.getSelectedItem().equals("Card")) {

			for (Card card : datavcf.getDataBase()) {
				JButton filebutton = new JButton(
						card.getContact().getFirstName() + " " + card.getContact().getLastName());
				filebutton.addActionListener(new SelectObjectAction(index));
				filebutton.setSize(databasescrollpane.getWidth(), 50);
				searchpanel.add(filebutton);
				index += 1;
			}
		}

		else if (searchbox.getSelectedItem().equals("Calendar")) {

			for (Calendar calendar : dataics.getDataBase()) {
				JButton filebutton = new JButton(calendar.getProdid().getName() + " "
						+ calendar.getVevent().getSdate().getYear() + "/" + calendar.getVevent().getSdate().getMonth()
						+ "/" + calendar.getVevent().getSdate().getDay());
				filebutton.addActionListener(new SelectObjectAction(index));
				filebutton.setSize(databasescrollpane.getWidth(), 50);
				searchpanel.add(filebutton);
				index += 1;
			}
		}

		searchpanel.revalidate();
		searchpanel.repaint();
	}

	/**
	 * Procedure repainting the "Informations" panel (infopanel)
	 */
	public void displayInfo() {

		if (searchbox.getSelectedItem().equals("Card")) {

			infopanel.removeAll();
			initCardInfo();

			infopanel.revalidate();
			infopanel.repaint();
		}

		if (searchbox.getSelectedItem().equals("Calendar")) {

			infopanel.removeAll();
			initCalendarInfo();

			infopanel.revalidate();
			infopanel.repaint();
		}
	}

	/**
	 * Verifies if the extension of the file is correct, if not returns a
	 * corrected file name.
	 * 
	 * @param file
	 * @param extension
	 * @return file
	 */
	public String validateExtension(String file, String extension) {

		if (!file.endsWith(extension)) {
			file += extension;
		}

		return file;
	}
}

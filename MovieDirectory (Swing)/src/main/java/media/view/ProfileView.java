package media.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProfileView {
	
	//swing components
	JFrame frame;	
	JButton switchProfile, addNew, listByYear, listByGenre;
	JLabel movie1, movie2, movie3, movie4, movie5;
	JLabel year1, year2, year3, year4, year5;
	JLabel genre1, genre2, genre3, genre4, genre5;
	JLabel user;
	
	//constructor opens the frame and sets the format details
	public ProfileView() {
		
		frame = new JFrame("Video Catalogue");
		frame.setLayout(new GridLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 520);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//call method to display information
		formatButtons();
		displayPreferences();
		displayYears();
		displayGenres();
		
	}
	
	public void formatButtons() {
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,1));

		//adds button for switch profile
		switchProfile = new JButton("Switch Profile");
		buttonPanel.add(switchProfile);
		
		//adds button for Add new
		addNew = new JButton("Add New");
		buttonPanel.add(addNew);
		
		//adds button for list by year
		listByYear = new JButton ("List By Year");
		buttonPanel.add(listByYear);
		
		//adds button for list by genre
		listByGenre = new JButton ("List By Genre");
		buttonPanel.add(listByGenre);

		frame.add(buttonPanel);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayPreferences() {
		
		JPanel preferencesPanel = new JPanel();
		preferencesPanel.setLayout(new GridLayout(6,1));

		
		JLabel blankLabel = new JLabel();
		preferencesPanel.add(blankLabel);
		
		//add a label to display a media item - color blue and underlined to indicate it can be clicked
		movie1 = new JLabel();
		movie1.setForeground(Color.blue);
		Font font = movie1.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		movie1.setFont(font.deriveFont(attributes));	
		preferencesPanel.add(movie1);
		
		//add a label to display a media item - color blue and underlined to indicate it can be clicked
		movie2 = new JLabel();
		movie2.setForeground(Color.blue);
		movie2.setFont(font.deriveFont(attributes));
		preferencesPanel.add(movie2);
		
		//add a label to display a media item - color blue and underlined to indicate it can be clicked
		movie3 = new JLabel();
		movie3.setForeground(Color.blue);
		movie3.setFont(font.deriveFont(attributes));
		preferencesPanel.add(movie3);
		
		//add a label to display a media item - color blue and underlined to indicate it can be clicked
		movie4 = new JLabel();
		movie4.setForeground(Color.blue);
		movie4.setFont(font.deriveFont(attributes));
		preferencesPanel.add(movie4);
		
		//add a label to display a media item - color blue and underlined to indicate it can be clicked
		movie5 = new JLabel();
		movie5.setForeground(Color.blue);
		movie5.setFont(font.deriveFont(attributes));
		preferencesPanel.add(movie5);
		
		//add to frame
		frame.add(preferencesPanel);
		
	}
	
	public void displayYears() {
		
		JPanel yearsPanel = new JPanel(new GridLayout(6,1));
		
		JLabel blankLabel = new JLabel();
		yearsPanel.add(blankLabel);
		
		//create a label for each of the 5 media items for displaying the year
		year1 = new JLabel();
		yearsPanel.add(year1);

		year2 = new JLabel();
		yearsPanel.add(year2);
		
		year3 = new JLabel();
		yearsPanel.add(year3);
		
		year4 = new JLabel();
		yearsPanel.add(year4);
		
		year5 = new JLabel();
		yearsPanel.add(year5);
		
		frame.add(yearsPanel);
		
	}
	
	public void displayGenres() {
		
		JPanel genrePanel = new JPanel(new GridLayout(6,1));
		
		//create a label that will display the profile name
		user = new JLabel();
		Font font = new Font("Calibri", Font.BOLD,12);
		user.setFont(font);
		genrePanel.add(user);
		
		//create a label for each of the 5 media items for displaying the genre
		genre1 = new JLabel();
		genrePanel.add(genre1);
		
		genre2 = new JLabel();
		genrePanel.add(genre2);
		
		genre3 = new JLabel();
		genrePanel.add(genre3);
		
		genre4 = new JLabel();
		genrePanel.add(genre4);
		
		genre5 = new JLabel();
		genrePanel.add(genre5);
		
		frame.add(genrePanel);
		
	}
	
	//getters and setters
	public JFrame getVideoCatalogueFrame() {
		return frame;
	}

	public void setVideoCatalogueFrame(JFrame videoCatalogueFrame) {
		this.frame = videoCatalogueFrame;
	}

	public JButton getSwitchProfile() {
		return switchProfile;
	}

	public void setSwitchProfile(JButton switchProfile) {
		this.switchProfile = switchProfile;
	}

	public JButton getAddNew() {
		return addNew;
	}

	public void setAddNew(JButton addNew) {
		this.addNew = addNew;
	}

	public JButton getListByYear() {
		return listByYear;
	}

	public void setListByYear(JButton listByYear) {
		this.listByYear = listByYear;
	}

	public JButton getListByGenre() {
		return listByGenre;
	}

	public void setListByGenre(JButton listByGenre) {
		this.listByGenre = listByGenre;
	}

	public JLabel getMovie1() {
		return movie1;
	}

	public void setMovie1(JLabel movie1) {
		this.movie1 = movie1;
	}

	public JLabel getMovie2() {
		return movie2;
	}

	public void setMovie2(JLabel movie2) {
		this.movie2 = movie2;
	}

	public JLabel getMovie3() {
		return movie3;
	}

	public void setMovie3(JLabel movie3) {
		this.movie3 = movie3;
	}

	public JLabel getMovie4() {
		return movie4;
	}

	public void setMovie4(JLabel movie4) {
		this.movie4 = movie4;
	}

	public JLabel getMovie5() {
		return movie5;
	}

	public void setMovie5(JLabel movie5) {
		this.movie5 = movie5;
	}

	public JLabel getYear1() {
		return year1;
	}

	public void setYear1(JLabel year1) {
		this.year1 = year1;
	}

	public JLabel getYear2() {
		return year2;
	}

	public void setYear2(JLabel year2) {
		this.year2 = year2;
	}

	public JLabel getYear3() {
		return year3;
	}

	public void setYear3(JLabel year3) {
		this.year3 = year3;
	}

	public JLabel getYear4() {
		return year4;
	}

	public void setYear4(JLabel year4) {
		this.year4 = year4;
	}

	public JLabel getYear5() {
		return year5;
	}

	public void setYear5(JLabel year5) {
		this.year5 = year5;
	}

	public JLabel getGenre1() {
		return genre1;
	}

	public void setGenre1(JLabel genre1) {
		this.genre1 = genre1;
	}

	public JLabel getGenre2() {
		return genre2;
	}

	public void setGenre2(JLabel genre2) {
		this.genre2 = genre2;
	}

	public JLabel getGenre3() {
		return genre3;
	}

	public void setGenre3(JLabel genre3) {
		this.genre3 = genre3;
	}

	public JLabel getGenre4() {
		return genre4;
	}

	public void setGenre4(JLabel genre4) {
		this.genre4 = genre4;
	}

	public JLabel getGenre5() {
		return genre5;
	}

	public void setGenre5(JLabel genre5) {
		this.genre5 = genre5;
	}

	public JLabel getUser() {
		return user;
	}

	public void setUser(JLabel user) {
		this.user = user;
	}
	

}

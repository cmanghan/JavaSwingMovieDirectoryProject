package media.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ItemDetailsView {
	
	//swing components
	JFrame frame =  new JFrame();
	JLabel title, description, year, genre, creative, cast;
	JPanel detailsPanel = new JPanel();
	JButton backButton = new JButton("Back");
	JTextArea descriptionField, titleField, yearField, genreField, creativeField, castField;
	
	//constructor opens the frame and sets the layout
	public ItemDetailsView(String heading) {
		
		frame = new JFrame(heading);
		frame.setLayout(new GridLayout());
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		//call the format details method 
		formatDetails();
	}
	
	public void formatDetails() {
		
	detailsPanel.setLayout(new GridLayout(7,1));
	
	//create new title labels and text area and add to panel
	title = new JLabel("Title:");
	titleField =  new JTextArea();
	detailsPanel.add(title);
	detailsPanel.add(titleField);
	
	//create new description labels and text area and add to panel
	description = new JLabel("Description:");
	descriptionField = new JTextArea();
	detailsPanel.add(description);
	detailsPanel.add(descriptionField);
	descriptionField.setLineWrap(true);
    descriptionField.setWrapStyleWord(true);
	
    //create new year labels and text area and add to panel
	year = new JLabel("Year:");
	yearField =  new JTextArea();
	detailsPanel.add(year);
	detailsPanel.add(yearField);
	
	//create new genre labels and text area and add to panel
	genre = new JLabel("Genre:");
	genreField = new JTextArea();
	detailsPanel.add(genre);
	detailsPanel.add(genreField);
	
	//create new creative labels and text area and add to panel
	//The "creative" is either a director or creator dependent on the media type
	creative = new JLabel();
	creativeField = new JTextArea();
	detailsPanel.add(creative);
	detailsPanel.add(creativeField);
	
	//create new cast labels and text area and add to panel
	cast = new JLabel("Cast:");
	castField = new JTextArea();
	detailsPanel.add(cast);
	detailsPanel.add(castField);
	
	//add back button
	detailsPanel.add(backButton);
	
	//add pabel to frame
	frame.add(detailsPanel);
	}

	
	//getters and setters
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JLabel getDescription() {
		return description;
	}

	public void setDescription(JLabel description) {
		this.description = description;
	}

	public JLabel getYear() {
		return year;
	}

	public void setYear(JLabel year) {
		this.year = year;
	}

	public JLabel getGenre() {
		return genre;
	}

	public void setGenre(JLabel genre) {
		this.genre = genre;
	}

	public JLabel getCreative() {
		return creative;
	}

	public void setCreative(JLabel creative) {
		this.creative = creative;
	}

	public JTextArea getCreativeField() {
		return creativeField;
	}

	public void setCreativeField(JTextArea  creativeField) {
		this.creativeField = creativeField;
	}

	public JLabel getCast() {
		return cast;
	}

	public void setCast(JLabel cast) {
		this.cast = cast;
	}

	public JPanel getDetailsPanel() {
		return detailsPanel;
	}

	public void setDetailsPanel(JPanel detailsPanel) {
		this.detailsPanel = detailsPanel;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JTextArea  getTitleField() {
		return titleField;
	}

	public void setTitleField(JTextArea  titleField) {
		this.titleField = titleField;
	}

	public JTextArea getDescriptionField() {
		return descriptionField;
	}

	public void setDescriptionField(JTextArea descriptionField) {
		this.descriptionField = descriptionField;
	}

	public JTextArea  getYearField() {
		return yearField;
	}

	public void setYearField(JTextArea  yearField) {
		this.yearField = yearField;
	}

	public JTextArea  getGenreField() {
		return genreField;
	}

	public void setGenreField(JTextArea  genreField) {
		this.genreField = genreField;
	}

	public JTextArea  getDirectorField() {
		return creativeField;
	}

	public void setDirectorField(JTextArea  directorField) {
		this.creativeField = directorField;
	}

	public JTextArea  getCastField() {
		return castField;
	}

	public void setCastField(JTextArea  castField) {
		this.castField = castField;
	}

}

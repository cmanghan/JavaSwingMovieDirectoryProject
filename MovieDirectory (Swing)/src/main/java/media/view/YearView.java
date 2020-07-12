package media.view;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class YearView {
	
	//swing components
	JFrame frame = new JFrame();
	JPanel yearPanel;
	JLabel emptyLabel, yearLabel, genreLabel, titleLabel;
	
	//constructor opens frame and sets layout
	public YearView() {
	
	frame = new JFrame("List By Year");
	frame.setLayout(new GridLayout());
	frame.setSize(600, 600);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	
	//call method to format the list
	formatList();
	
	}
	
	public void formatList() {
	//create a new panel
	yearPanel = new JPanel();
	yearPanel.setLayout(new GridLayout(25,2));	
	
	//add panel to frame
	frame.add(yearPanel);
	
	}
	
	//create labels that will hold the year and an empty space
	public void createLabels() {		
		emptyLabel = new JLabel();	
		yearLabel = new JLabel();
				
	}
	
	//add the year and empty labels to the panel
	public void addToPanel() {
		yearPanel.add(yearLabel);
		yearPanel.add(emptyLabel);
	}
	
	//create labels that will hold the genre and title
	public void createMediaLabels() {
		genreLabel = new JLabel();	
		titleLabel = new JLabel();
	}
	
	//add genre and year labels to the panel
	public void addMediaToPanel() {
		yearPanel.add(titleLabel);
		yearPanel.add(genreLabel);
	}

	//getters and setters
	public JLabel getGenreLabel() {
		return genreLabel;
	}

	public void setGenreLabel(JLabel genreLabel) {
		this.genreLabel = genreLabel;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JLabel getEmptyLabel() {
		return emptyLabel;
	}

	public void setEmptyLabel(JLabel emptyLabel) {
		this.emptyLabel = emptyLabel;
	}

	public JLabel getYearLabel() {
		return yearLabel;
	}

	public void setYearLabel(JLabel yearLabel) {
		this.yearLabel = yearLabel;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JPanel getYearPanel() {
		return yearPanel;
	}

	public void setYearPanel(JPanel yearPanel) {
		this.yearPanel = yearPanel;
	}

}

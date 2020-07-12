package media.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GenreView {

	//swing components
	JFrame frame = new JFrame();
	JPanel genrePanel;	
	JLabel emptyLabel, gLabel, titleLabel, yLabel;

	//constructor opens the frame
	public GenreView() {
		//initialize frame and set layout
		frame = new JFrame("List By Genre");
		frame.setLayout(new GridLayout());
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//call format list method
		formatList();
	
	}
	
	public void formatList() {
	
	//initialize panel and set laout
	genrePanel = new JPanel();
	genrePanel.setLayout(new GridLayout(25,2));	
	
	//add panel to frame
	frame.add(genrePanel);
	
	}
	
	//called when needing a label that will be set as the genre and empty
	public void createLabel() {
		emptyLabel = new JLabel();	
		gLabel = new JLabel();
	}
	
	//called when needing a label that will be set as the year and title
	public void createMediaLabels() {
		
		yLabel = new JLabel();	
		titleLabel = new JLabel();
		
	}
	//adds the genre and empty label to panel
	public void addToPanel() {
		genrePanel.add(emptyLabel);
		genrePanel.add(gLabel);
	}
	//adds the title and year label to panel
	public void addMediaToPanel() {
		genrePanel.add(titleLabel);
		genrePanel.add(yLabel);
	}
	
	//getters and setters
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JLabel getyLabel() {
		return yLabel;
	}

	public void setyLabel(JLabel yLabel) {
		this.yLabel = yLabel;
	}

	public JLabel getEmptyLabel() {
		return emptyLabel;
	}

	public void setEmptyLabel(JLabel emptyLabel) {
		this.emptyLabel = emptyLabel;
	}

	public JLabel getgLabel() {
		return gLabel;
	}

	public void setgLabel(JLabel gLabel) {
		this.gLabel = gLabel;
	}

	public JPanel getGenrePanel() {
		return genrePanel;
	}

	public void setGenrePanel(JPanel genrePanel) {
		this.genrePanel = genrePanel;
	}

}

package media.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectUserView {
	
	//swing components
	JFrame frame;	
	JButton profile1, profile2, profile3, profile4;
	
	
	//constructor opens the view and sets the layout details
	public SelectUserView() {
		
		frame = new JFrame("Select User");
		frame.setLayout(new GridLayout());
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//call method to format the buttons
		formatProfileButtons();
	}
	
	public void formatProfileButtons() {
		
		JPanel profileButtonPanel = new JPanel();
		profileButtonPanel.setLayout(new GridLayout(4,1));
		
		//add 4 buttons - one for each profile. Max of 4 profiles is assumed
		profile1 = new JButton();
		profileButtonPanel.add(profile1);
		
		profile2 = new JButton();
		profileButtonPanel.add(profile2);
		
		profile3 = new JButton();
		profileButtonPanel.add(profile3);
		
		profile4 = new JButton();
		profileButtonPanel.add(profile4);
		
		//add to frame
		frame.add(profileButtonPanel);
	}
	
	//getters and setters
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getProfile1() {
		return profile1;
	}

	public void setProfile1(JButton profile1) {
		this.profile1 = profile1;
	}

	public JButton getProfile2() {
		return profile2;
	}

	public void setProfile2(JButton profile2) {
		this.profile2 = profile2;
	}

	public JButton getProfile3() {
		return profile3;
	}

	public void setProfile3(JButton profile3) {
		this.profile3 = profile3;
	}

	public JButton getProfile4() {
		return profile4;
	}

	public void setProfile4(JButton profile4) {
		this.profile4 = profile4;
	}


}

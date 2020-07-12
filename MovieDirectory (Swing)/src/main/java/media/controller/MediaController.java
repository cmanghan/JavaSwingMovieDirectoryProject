package media.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import media.model.*;
import media.view.*;

public class MediaController {
	
	//define variables
	 private MediaContainer model;
	 private ProfileView view;
	 private int fid, tid, pid, gid;
	 People inputtedPerson;
	 private SortingStrategy strategy;
	 
	 //instantiate array list of media items that will hold a profiles preffered media items
	ArrayList <MediaItem> preferredList = new ArrayList <MediaItem> ();
	
	//getter and setter for the Array List
	public ArrayList<MediaItem> getPreferredList() {
		return preferredList;
	}

	public void setPreferredList(ArrayList<MediaItem> preferredList) {
		this.preferredList = preferredList;
	}

	//default constructor
	public  MediaController() {
		
	}
	
	//parameterized constructor
	public MediaController(MediaContainer m, ProfileView v) {
		  this.model = m;
		  this.view = v;

		 }
	
	//start method kicks of the program - accepts a profile
	public void start(media.model.Profiles profile) {
		
		  //call methods to load the ProfileView
		  generatePreferences(profile);
		  displayYears();
		  displayGenre();
		  displayUser(profile);
		  
		  //add an action listener to each button to call the correct method depending on the button pushed
		  view.getSwitchProfile().addActionListener(e -> switchProfile());
		  view.getListByYear().addActionListener(e -> listByYear(new SortByYear()));
		  view.getListByGenre().addActionListener(e -> listByGenre(new SortByGenres()));
		  view.getAddNew().addActionListener(e -> addNew(profile));
	}
	
	//mouse listener
	MouseListener listener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        	//when mouse clicked will call the itemDetails method and pass through the label that called it
        	JLabel label = (JLabel)e.getSource();
            itemDetails(label);
            }
          };
	
	public void generatePreferences(media.model.Profiles profile) {
		//temporary array to hold media items 
		ArrayList <MediaItem> tempArray = new ArrayList <MediaItem>();
		
		//set the preferred genre to a variable
		int preferredGenre = profile.getPreferredGenre();
		
		//search all MediaItems in the catalogue
		for (MediaItem mI : model.getMediaArray()) {
			//search all genres within each media item
			for (Genres g : mI.getGenre()) {
				//if the genre Id within a media item = user's preferred genre, add to list
				if (g.getGid() == preferredGenre) {
					preferredList.add(mI);
				}
			}
		}
		//if there are less than 5 movies in the user's preferred genre - additional movies will be added
			//add all mediaitems to a temporary array and shuffle it to randomize
			tempArray.addAll(model.getMediaArray());
			Collections.shuffle(tempArray);
			while (preferredList.size()<5) {			
				for (MediaItem t : tempArray) {;
						//if the mediaItem does not already exist in the preferredList
						if (!preferredList.contains(t)) {
							preferredList.add(t);
						}
				}			
			}	
		
		//set the movie Labels text as the title from the preferred genre
	    view.getMovie1().setText(preferredList.get(0).getTitle());
	    //add an action listener if the user clicks on the text
		view.getMovie1().addMouseListener(listener);
		//add the media item as a property
		view.getMovie1().putClientProperty("MediaItem", preferredList.get(0));
		
		//set the movie Labels text as the title from the preferred genre
		view.getMovie2().setText(preferredList.get(1).getTitle());
		//add an action listener if the user clicks on the text
		view.getMovie2().addMouseListener(listener);
		//add the media item as a property
		view.getMovie2().putClientProperty("MediaItem", preferredList.get(1));
		
		//set the movie Labels text as the title from the preferred genre
		view.getMovie3().setText(preferredList.get(2).getTitle());
		//add an action listener if the user clicks on the text
		view.getMovie3().addMouseListener(listener);
		//add the media item as a property
		view.getMovie3().putClientProperty("MediaItem", preferredList.get(2));
		
		//set the movie Labels text as the title from the preferred genre
		view.getMovie4().setText(preferredList.get(3).getTitle());
		//add an action listener if the user clicks on the text
		view.getMovie4().addMouseListener(listener);
		//add the media item as a property
		view.getMovie4().putClientProperty("MediaItem", preferredList.get(3));
		
		//set the movie Labels text as the title from the preferred genre
		view.getMovie5().setText(preferredList.get(4).getTitle());
		//add an action listener if the user clicks on the text
		view.getMovie5().addMouseListener(listener);
		//add the media item as a property
		view.getMovie5().putClientProperty("MediaItem", preferredList.get(4));

		

	}
	//method to display the years of the media item
	public void displayYears() {
		//set the text as the year from the preferred list in order
		view.getYear1().setText(preferredList.get(0).getYear());
		view.getYear2().setText(preferredList.get(1).getYear());
		view.getYear3().setText(preferredList.get(2).getYear());
		view.getYear4().setText(preferredList.get(3).getYear());
		view.getYear5().setText(preferredList.get(4).getYear());
	
	}
	
	//method to display the genre of the media item
	public void displayGenre() {
		//set the text for the genre as the array of genres from the preferred list
		view.getGenre1().setText(preferredList.get(0).getGenre().toString());
		view.getGenre2().setText(preferredList.get(1).getGenre().toString());
		view.getGenre3().setText(preferredList.get(2).getGenre().toString());
		view.getGenre4().setText(preferredList.get(3).getGenre().toString());
		view.getGenre5().setText(preferredList.get(4).getGenre().toString());
		
		//clear out the preferred list so the next time it is called it doesn't contain preferences for other profiles
		preferredList.clear();
	}
	
	//method to display the name of the current user
	public void displayUser(media.model.Profiles profile) {
		//set text of jlabel to the name of the current user
		view.getUser().setText("User Profile: " + profile.getName());
	}
	
	//method to switch profiles
	public void switchProfile() {
		//open the switch profile view
		SelectUserView suv = new SelectUserView();
		
		//add the name of profile to the button
		suv.getProfile1().setText(model.getProfiles().get(0).getName());
		//call method for profile one if clicked
		suv.getProfile1().addActionListener(e -> newProfileOne());
		
		//add the name of profile to the button
		suv.getProfile2().setText(model.getProfiles().get(1).getName());
		//call method for profile two if clicked
		suv.getProfile2().addActionListener(e -> newProfileTwo());
		
		//add the name of profile to the button
		suv.getProfile3().setText(model.getProfiles().get(2).getName());
		//call method for profile three if clicked
		suv.getProfile3().addActionListener(e -> newProfileThree());
		
		//add the name of profile to the button
		suv.getProfile4().setText(model.getProfiles().get(3).getName());
		//call method for profile four if clicked
		suv.getProfile4().addActionListener(e -> newProfileFour());
		
	}
	
	public void newProfileOne() {
		//call the start method to display the profile view using profile 1 (array spot 0)
		start(model.getProfiles().get(0));
	}
	
	public void newProfileTwo() {
		//call the start method to display the profile view using profile 2
		start(model.getProfiles().get(1));
	}
	
	public void newProfileThree() {
		//call the start method to display the profile view using profile 3
		start(model.getProfiles().get(2));
	}
	
	public void newProfileFour() {
		//call the start method to display the profile view using profile 1
		start(model.getProfiles().get(3));
	}

	@SuppressWarnings("unchecked")
	//list by year accepts the sorting strategy you wish to use
	public void listByYear(SortingStrategy strategy) {
		//create a new year view
		YearView yearView = new YearView();
		
		//set the strategy to the one passed through
		this.strategy=strategy;
		
		//hashmap is equal to the one returned from using the desired sorting strategy
		TreeMap<String, HashSet<MediaItem>> sortedMedia = this.strategy.sort(model.getMediaArray());
		
		//for loop to loop through entries
		for (Map.Entry<String, HashSet<MediaItem>> entry : sortedMedia.entrySet()) {
			
			//call method in yearView to create the necessary labels
			yearView.createLabels();
			
			//set the text as the year
			yearView.getYearLabel().setText(entry.getKey());
			//set text as empty to create a blank space
			yearView.getEmptyLabel().setText("");
			
			//call method in yearView to add to label
			yearView.addToPanel();
			
			//loop through each entry within that year
			for (MediaItem m: entry.getValue()) {
			
				//call method to create label
				yearView.createMediaLabels();
				
				//set the color to blue to indicate it can be clicked
				yearView.getTitleLabel().setForeground(Color.blue);
				Font font = yearView.getTitleLabel().getFont();
				@SuppressWarnings("rawtypes")
				Map attributes = font.getAttributes();
				//set font as underlined
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				yearView.getTitleLabel().setFont(font.deriveFont(attributes));	
				
				//add title to label
				String title = m.getTitle();
				yearView.getTitleLabel().setText(title);
				//add a listener for if the user clicks on it
				yearView.getTitleLabel().addMouseListener(listener);
				//add the media item as s property
				yearView.getTitleLabel().putClientProperty("MediaItem", m);

				//set the label as the genre
				String genre = m.getGenre().toString();
				yearView.getGenreLabel().setText(genre);

				//call method to add labels to panel in yearView
				yearView.addMediaToPanel();
			
			}		
		}		
	}
	//list by genre accepts a desired sorting strategy
	public void listByGenre(SortingStrategy strategy) {
		//open the genre view
		GenreView gv = new GenreView();
		
		//set strategy equal to strategy passed through
		this.strategy=strategy;
		
		//set treemap equal to map returned by desired sorting strategy 
		TreeMap<String, HashSet<MediaItem>> sortedMedia = this.strategy.sort(model.getMediaArray());
		
		//loop through each entery
		for (Map.Entry<String, HashSet<MediaItem>> genreEntry : sortedMedia.entrySet()) {

			//call method to create the label in the view
			gv.createLabel();
			
			//set the text of the label as the Genre
			gv.getEmptyLabel().setText(genreEntry.getKey());
			//set the label as blank for a blank space
			gv.getgLabel().setText("");
			
			//call method in view to add to panel
			gv.addToPanel();
			
			//loop through each media item within that genre
			for (MediaItem m: genreEntry.getValue()) {

				//call method to create new media
				gv.createMediaLabels();
				
				//set font color to blue and underlined to make it clear it is clickable
				gv.getTitleLabel().setForeground(Color.blue);
				Font font = gv.getTitleLabel().getFont();
				@SuppressWarnings("rawtypes")
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				gv.getTitleLabel().setFont(font.deriveFont(attributes));	
				
				//set title to label
				String title = m.getTitle();
				gv.getTitleLabel().setText(title);
				//add a listener to listen for a lick
				gv.getTitleLabel().addMouseListener(listener);
				gv.getTitleLabel().putClientProperty("MediaItem", m);

				//set year to label
				String year = m.getYear();
				gv.getyLabel().setText(year);
				
				//call method to add to panel
				gv.addMediaToPanel();
				
			
			}		
		}		
	}
		
		
	
	public void itemDetails(JLabel label) {
		//create new instance of item details
		ItemDetailsView idv = new ItemDetailsView("Item Details");
		
		//set as not editable
		idv.getTitleField().setEditable(false);
		//set the text
		idv.getTitleField().setText(label.getText());
		
		//mediaItem is the mediaItem being displayed - created as a local variable for convenience and clear code
		MediaItem mediaItem = (MediaItem) label.getClientProperty("MediaItem");
		
		//set the description
		idv.getDescriptionField().setEditable(false);
		idv.getDescriptionField().setText(mediaItem.getDescription());
		
		//set the year
		idv.getYearField().setEditable(false);
		idv.getYearField().setText(mediaItem.getYear());
		
		//set teh genres
		idv.getGenreField().setEditable(false);
		idv.getGenreField().setText(mediaItem.getGenre().toString());
		
		//if the media item is a film set the label to say director and set as directors name
		if (mediaItem instanceof Films) {
			idv.getCreative().setText("Director");
			People director = ((Films)mediaItem).getDirector();
			
			idv.getCreativeField().setEditable(false);
			idv.getCreativeField().setText(director.getName());
			
		}
		//if the media item is a tv series set the label to say creator and set as creators name
		else {
			idv.getCreative().setText("Creator");
			People creator = ((TVSeries)mediaItem).getCreator();
			
			idv.getCreativeField().setEditable(false);
			idv.getCreativeField().setText(creator.getName());
			
		}
		//set cast
		idv.getCastField().setEditable(false);
		idv.getCastField().setText(mediaItem.getCast().toString());
		
		//add listener to the back button
		idv.getBackButton().addActionListener(e -> closeFrame(idv.getFrame()));
	}
	
	//method will close the frame
	public void closeFrame(JFrame frame) {
		frame.dispose();
	}
	
	public void addNew(media.model.Profiles profile) {
		//create new add item view
		AddItemView aiv = new AddItemView();
		//add text to the checkbox that can be checked if item is a tv series
		aiv.getCheckbox().setText("TV Series:");

		//fid & tid represent the greatest id already taken by imported media items
		fid = model.getFilms().size();
		tid = model.getTvseries().size();
		
		//add listener that will save any entered info
		aiv.getSaveButton().addActionListener(e -> saveInfo(aiv, profile));
	
	}
	
	public void saveInfo(AddItemView aiv, media.model.Profiles profile) {
		
		//save entered info to variables
		String title = aiv.getTitleField().getText();
		String description = aiv.getDescriptionField().getText();
		String year = aiv.getYearField().getText();
		//multiple genres can be entered - saved first as String and changed to arrayList
		String genreString = aiv.getGenreField().getText();
			String[] elements = genreString.split(",");
			List <String> tmpList = Arrays.asList(elements);
			ArrayList<Genres> genreArray = new ArrayList <Genres>();
			gid = model.getGenres().size();
			//loop through each existing genre
			for(Genres g: model.getGenres()) {
				for (String s: tmpList) {
					//if entered matches existing - add to array
					if(g.getGenre() == s) {
						genreArray.add(g);
					}
					//else create a new genre with gid one higher than previous
					else {
						gid++;
						Genres newGenre = new Genres(gid,s);
						genreArray.add(newGenre);
					}
				}
			}
		
			String creativeString = aiv.getCreativeField().getText();
			//call check people to see if the entered person already exists or needs to be created
			checkPeople(creativeString);	
			
			//loop through all existing people
			for(People p : model.getPeople()) {
				//once a name is matched, set that instance to the inputtedPerson
				if (p.getName() == creativeString) {
					inputtedPerson = p;
				}
			}
		
		//multiple cast members can be added - accept as string and transfer to array list
		String castString = aiv.getCastField().getText();
			String[] castElements = castString.split(",");
			List <String> tmpCastList = Arrays.asList(castElements);
			ArrayList <String> castStringList = new ArrayList<String> (tmpCastList);
			for (String s: castStringList) {
				//check if people are existing or need to be added
				checkPeople(s);
			}
			ArrayList <People> castList = new ArrayList<People>();
			//loop through all existing people
			for (People p : model.getPeople()) {
				//once a name is matched, add to cast list
				for (String s: castStringList) {
					if (p.getName() == s) {
						castList.add(p);
					}
				}
			}
		//set local variables to fid and tid, incremented by one
		int localFid = fid + 1;
		int localTid = tid +1 ;
		
		//create a new instance of media factory
		MediaFactory mf = new MediaFactory(model);
		
		//if new item is a tv series call media factory method for tv series
		if(aiv.getCheckbox().isSelected()) {
			
			mf.createTVSeries(localTid, title, description, year, genreArray, inputtedPerson, castList);
		}
		//else call media factory method for film
		else {
			mf.createFilm(localFid, title, description, year, genreArray, inputtedPerson, castList);
		}
		
		//close frame
		aiv.getFrame().dispatchEvent(new WindowEvent(aiv.getFrame(), WindowEvent.WINDOW_CLOSING));
		
		//refresh other frames to include the new item
		SortByGenres sbg = new SortByGenres();
		sbg.sort(model.getMediaArray());
		
		SortByYear sby = new SortByYear();
		sby.sort(model.getMediaArray());
		
		start(profile);
	}
	
	
	public void checkPeople(String creativeString) {
		
		//the highest id used is equal to how many people exist, as ids start at 1
		pid = model.getPeople().size();
		
		//add all existing names to a list
		ArrayList <String> nameList = new ArrayList <String>();
		for (People p: model.getPeople()) {
			nameList.add(p.getName());
		}
		
		//if the name list does not contain the entered name, a new person needs to be created
		if(!nameList.contains(creativeString)) {
			pid = pid +1;
			People newPerson = new People(pid, creativeString);
			model.getPeople().add(newPerson);
		}
		
	}
	

}

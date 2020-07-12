package media.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

//implements Sorting Strategy interface
public class SortByYear implements SortingStrategy{
	
	//TreeMap prevents dublicates - uses an inner hashset as multiple media may have the same year
	protected TreeMap<String,HashSet<MediaItem>> mediaMap = new TreeMap<String,HashSet<MediaItem>>();

	@Override
	public TreeMap<String, HashSet<MediaItem>> sort(ArrayList<MediaItem> mediaArray) {
		
		//clear anything already in the map
		mediaMap.clear();
		//alphabetize array list
		alphabetizeList(mediaArray);
		
		//loop through the array list
		for (MediaItem m: mediaArray) {
			
			//set year and title
			String year = m.getYear();
			String title = m.getTitle();
			
			//add to hashset
			HashSet <MediaItem> temp = new HashSet<MediaItem>();
			temp.add(m);
			
			//for loop to search for media in the same year
			for (MediaItem i: mediaArray) {
				if(year.compareTo(i.getYear()) ==0 && title != i.getTitle()) {
					temp.add(i);
				}
					
			}
		//add the year and all media items in that year to the map
		mediaMap.put(year, temp);
		}
		return mediaMap;
	}
	
	public void alphabetizeList(ArrayList <MediaItem> mediaArray) {
		//sort in aphatbetical order
		Comparator<MediaItem> compareByTitle = (MediaItem m1,MediaItem m2) -> m1.getTitle().compareTo( m2.getTitle() );
		Collections.sort(mediaArray, compareByTitle);
	}
	
	//getter and setter
	public TreeMap<String, HashSet<MediaItem>> getMediaMap() {
		return mediaMap;
	}

	public void setMediaMap(TreeMap<String, HashSet<MediaItem>> mediaMap) {
		this.mediaMap = mediaMap;
	}

}

package media.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

//implments Sorting Strategy interface
public class SortByGenres implements SortingStrategy {

//TreeMap prevents dublicates - uses an inner hashset as multiple media may have the same genre
 protected TreeMap<String,HashSet<MediaItem>> genreMap = new TreeMap<String,HashSet<MediaItem>>();
	
	@Override
	public TreeMap<String,HashSet<MediaItem>> sort (ArrayList <MediaItem> mediaArray) {
	
			//clears anything already in the map
			genreMap.clear();
			//alphabetize the media array
			alphabetizeList(mediaArray);
			
			//lop through the media array
			for (MediaItem m: mediaArray) {
				
				//set genre and string
				String genre = m.getGenre().get(0).getGenre();
				String title = m.getTitle();
				
				//add to hashmap
				HashSet <MediaItem> temp = new HashSet<MediaItem>();
				temp.add(m);
				
				//for loop to search for media in the same genre
				for (MediaItem i: mediaArray) {
					if(genre.compareTo(i.getGenre().get(0).getGenre()) ==0 && title != i.getTitle()) {
						temp.add(i);
					}
						
				}
			//add the genre and hashset of media items in the genre to that tree map
			genreMap.put(genre, temp);
			}
			return genreMap;
		
		
	}
	
	public void alphabetizeList(ArrayList <MediaItem> mediaArray) {
		//arrange the array in alphabetically order
		Comparator<MediaItem> compareByTitle = (MediaItem m1,MediaItem m2) -> m1.getTitle().compareTo( m2.getTitle() );
		Collections.sort(mediaArray, compareByTitle);
	}
	
	//getter and setter
	public TreeMap<String, HashSet<MediaItem>> getGenreMap() {
		return genreMap;
	}

	public void setGenreMap(TreeMap<String, HashSet<MediaItem>> genreMap) {
		this.genreMap = genreMap;
	}

}

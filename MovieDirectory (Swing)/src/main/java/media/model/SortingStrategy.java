package media.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public interface SortingStrategy {
	
	//sort method to be implemented by implementing classes
	public TreeMap<String, HashSet<MediaItem>> sort(ArrayList <MediaItem> mediaArray);

}

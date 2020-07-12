package media.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

public class MediaContainer {
	
	//array list for each imported json object
	private ArrayList<Films> films = new ArrayList<Films>();
	private ArrayList<TVSeries> tvseries = new ArrayList<TVSeries>();
	private ArrayList<Genres> genres = new ArrayList<Genres>();
	private ArrayList<People> people = new ArrayList<People>();
	private ArrayList<Profiles> Profiles = new ArrayList<Profiles>();
	
	//arraylist that will hold all media items
	private ArrayList<MediaItem> mediaArray = new ArrayList<MediaItem>();

	//getter for mediaItems array
	public ArrayList<MediaItem> getMediaArray() {
		return mediaArray;
	}
	//default constructor
	public MediaContainer() {
	
	}
	//method adds all films and tv series to the list and will alphabetize it
	public void setMediaArray() {
		mediaArray.addAll(films);
		mediaArray.addAll(tvseries);;
		alphabetizeList();
	}
	
	public void alphabetizeList() {
		//sort the list in alphabetical order
		Comparator<MediaItem> compareByTitle = (MediaItem m1,MediaItem m2) -> m1.getTitle().compareTo( m2.getTitle() );
		Collections.sort(mediaArray, compareByTitle);
	}

	//setter for media list
	public void setMediaArray(ArrayList<MediaItem> mediaArray) {
		this.mediaArray = mediaArray;
	}
	
	//toString
	@Override
	public String toString() {
		return "MediaContainer [films=" + films + ", tvseries=" + tvseries + ", genres=" + genres + ", people=" + people
				+ ", Profiles=" + Profiles + "]";
	}

	//getters and setters
	public ArrayList<Films> getFilms() {
		return films;
	}

	public void setFilms(ArrayList<Films> films) {
		this.films = films;
	}

	public ArrayList<TVSeries> getTvseries() {
		return tvseries;
	}

	public void setTvseries(ArrayList<TVSeries> tvseries) {
		this.tvseries = tvseries;
	}

	public ArrayList<Genres> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genres> genres) {
		this.genres = genres;
	}

	public ArrayList<People> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<People> people) {
		this.people = people;
	}

	public ArrayList<Profiles> getProfiles() {
		return Profiles;
	}

	public void setProfiles(ArrayList<Profiles> profiles) {
		Profiles = profiles;
	}

	
	



}

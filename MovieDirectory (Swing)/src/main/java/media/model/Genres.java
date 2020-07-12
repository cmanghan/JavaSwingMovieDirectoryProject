package media.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "gid",scope = Genres.class)
public class Genres {
	
	//set avariables as private
	private int gid;
	private String genre;
	
	//default constructor
	public Genres() {
		
	}
	
	//toString to print the genre
	@Override
	public String toString() {
		return genre;
	}

	//parameterized constructor
	public Genres(int gid, String genre) {
		
		this.gid=gid;
		this.genre=genre;
		
	}
	
	//getters and setters
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}

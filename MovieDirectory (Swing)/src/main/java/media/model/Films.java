package media.model;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fid",scope=Films.class)
//film is a type of media item
public class Films extends MediaItem {

	//set attributes as private
	private int fid;
    private People director;

	//default constructor
	public Films() {
		
	}
	
	//parameterized constructor
	public Films(int fid, String title, String year, List <Genres> genre, People director, List <People> cast, String description) {
		
		super(title, year, genre, cast, description);
		this.fid = fid;
		this.director = director;

	}

	//getter and setters
	public int getFid() {
		return fid;
	}
	public People getDirector() {
		return director;
	}
	public void setDirector(People director) {
		this.director = director;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	
}

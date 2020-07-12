package media.model;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class TVSeries extends MediaItem {
	
	//set variables as private
	private int tid;
    private People creator;

	//default constructor
	public TVSeries() {
		
	}
	//parameterized constructor
	public TVSeries(int tid, String title, String year,List <Genres> genre, People creator, List <People> cast, String description) {
		
		super(title, year, genre, cast, description);
		this.tid = tid;
		this.creator=creator;

	}
	
	//getters and setters
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public People getCreator() {
		return creator;
	}
	public void setCreator(People creator) {
		this.creator = creator;
	}

	

}


package media.model;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaItem {
	
	//set variables as private
	private String title = null;
	private String year = null;
    private List <Genres> genre;
    private List<People> cast;
	private String description = null;
	
	//default constructor
	public MediaItem() {
		
	}
	
	//parameterized constructor
	public MediaItem(String title, String year, List <Genres> genre, List <People> cast, String description) {
		this.title=title;
		this.year=year;
		this.genre=genre;
		this.cast=cast;
		this.description=description;
	}

	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}



	public List<Genres> getGenre() {
		return genre;
	}

	public void setGenre(List<Genres> genre) {
		this.genre = genre;
	}

	public List<People> getCast() {
		return cast;
	}

	public void setCast(List<People> cast) {
		this.cast = cast;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int compareTo (MediaItem o) {
		return this.getTitle().compareTo(o.getTitle());
	}

	


}

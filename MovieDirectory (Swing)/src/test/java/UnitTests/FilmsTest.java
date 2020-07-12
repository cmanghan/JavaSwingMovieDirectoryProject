package UnitTests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import media.model.Films;
import media.model.Genres;
import media.model.People;

public class FilmsTest {

	private Films film1;
	
	@Test
	public void nullTest() {	
		//assert fiml is null
		assertNull(film1);
	}
	
	@Test
	public void notNullTest() {
		
		//create new genre list
		ArrayList <Genres> genreList = new ArrayList <Genres>();
		genreList.add(new Genres(1, "Action"));
		
		//create new person and cast list
		People willSmith = new People(1, "Will Smith");
		ArrayList <People> castList = new ArrayList <People>();
		castList.add(willSmith);
		
		//create new film
		film1 = new Films(1, "Test Title", "2020", genreList, willSmith,castList, "A test movie directed and acted by Will Smith");
	
		//asser film is no longer null
		assertNotNull(film1);
	}

}

package UnitTests;
import static org.junit.Assert.*;

import org.junit.Test;

import media.model.Genres;

public class GenresTest {

	@Test
	public void genresConstructorTest() {
		
		//create a new genre
		Genres testGenres = new Genres (1, "Test Genre");
		
		//assert the constructor set the id to 1
		assertEquals(1, (testGenres.getGid()));
		
		
	}

}

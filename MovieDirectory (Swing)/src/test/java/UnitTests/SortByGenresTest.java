package UnitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.model.MediaContainer;
import media.model.SortByGenres;
import media.model.SortingStrategy;

public class SortByGenresTest {

//new media container
static MediaContainer mc = new MediaContainer();
	
	@Test
	public void sortByGenresTester() {
		//read json data
		ObjectMapper map = new ObjectMapper();
	
		try {
			mc = map.readValue(new File("JSONMedia.json"), MediaContainer.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//instantiate strategy
		SortByGenres strategy = new SortByGenres();
		
		//set and sort strategy by genre
		mc.setMediaArray();
		strategy.sort(mc.getMediaArray());
		
		//assert that the first key is action
		assertEquals(strategy.getGenreMap().firstKey(), "Action");
		
	}
}

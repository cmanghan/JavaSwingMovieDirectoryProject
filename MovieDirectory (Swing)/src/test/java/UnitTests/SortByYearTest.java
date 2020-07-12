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
import media.model.SortByYear;

public class SortByYearTest {

//new media container
static MediaContainer mc = new MediaContainer();
	
	@Test
	public void sortByYearTester() {
		
		//read in json data
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
		SortByYear strategy = new SortByYear();
		
		//set and sort the array with the strategy
		mc.setMediaArray();
		strategy.sort(mc.getMediaArray());
		
		//asser that the earliest year contains 19 (meaning it was likely in the 20th century)
		assertTrue(strategy.getMediaMap().firstKey().contains("19"));
}
}
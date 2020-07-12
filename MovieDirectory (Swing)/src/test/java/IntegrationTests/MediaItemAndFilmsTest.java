package IntegrationTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.model.Films;
import media.model.MediaContainer;
import media.model.MediaItem;
import static org.junit.Assert.*;

public class MediaItemAndFilmsTest {

//new media container
static MediaContainer mc = new MediaContainer();
	
	@Test
	public void testMediaItemIngegration() {
		
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
		
		Films testFilm = mc.getFilms().get(0);
		
		//checks that MediaItem is the parent object of films
		assertTrue(testFilm instanceof MediaItem);
		
	}

}

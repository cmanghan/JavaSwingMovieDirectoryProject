package UnitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.application.Application;
import media.controller.MediaController;
import media.model.MediaContainer;
import media.model.MediaItem;
import media.model.Profiles;
import media.view.ProfileView;


public class MediaContainerTest {
	
	//new media container
	static MediaContainer mc = new MediaContainer();
	
	@Test
	public void mediaContainerTest() {
		
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

		//assert the array lists in Media Container class are not null
		assertNotNull(mc.getFilms());
		assertNotNull(mc.getGenres());
		assertNotNull(mc.getPeople());
		assertNotNull(mc.getTvseries());
		
		
		}
	

}

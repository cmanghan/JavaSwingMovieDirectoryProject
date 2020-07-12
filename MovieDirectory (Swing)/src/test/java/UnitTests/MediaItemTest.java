package UnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.model.MediaContainer;

public class MediaItemTest {

	//create new media container
	static MediaContainer mc = new MediaContainer();
	
	@Test
	public void mediaItemTest() {
		
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

		//call setMediaArray Method
		mc.setMediaArray();
		//overwrite the title
		mc.getMediaArray().get(0).setTitle("TEST");
		
		//test the setter is working in Media Items
		assertEquals(mc.getMediaArray().get(0).getTitle(), "TEST");
}
}
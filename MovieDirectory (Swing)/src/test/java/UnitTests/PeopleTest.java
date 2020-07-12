package UnitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.model.MediaContainer;
import media.model.People;

public class PeopleTest {

	//new media container
	static MediaContainer mc = new MediaContainer();
	
	@Test
	public void peopleTest() {
		
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
		//new People
		People testPerson = new People(100, "Jennifer Lopez");
		//reset the name - may happen if an actor changes their name. Setter means you don't have to change JSON data
		testPerson.setName("Jennifer Lopez Rodriguez");
		
		//assert that the name has changed in the People object
		assertEquals(testPerson.getName(), "Jennifer Lopez Rodriguez");
	}
}

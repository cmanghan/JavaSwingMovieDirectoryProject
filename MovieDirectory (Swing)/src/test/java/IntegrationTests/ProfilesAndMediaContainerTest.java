package IntegrationTests;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.model.MediaContainer;
import media.model.Profiles;

public class ProfilesAndMediaContainerTest {
	
	//new media container
	static MediaContainer mc = new MediaContainer();

	
	@Test
	public void profilesListTest() {
		
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
		
		//assert check profiles method returns true
		assertTrue(checkProfiles());
		
		}
		
	public boolean checkProfiles() {
		//check all profiles and if one contains the name Pikachu return true
		for (Profiles p : mc.getProfiles()) {
			if (p.getName().contains("Pikachu")){
				return true;
			}
	}
		return false;

}
}

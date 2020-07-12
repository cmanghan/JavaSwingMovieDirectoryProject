package IntegrationTests;
import static org.junit.Assert.*;

import org.junit.Test;

	import static org.junit.Assert.assertTrue;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import com.fasterxml.jackson.core.JsonParseException;
	import com.fasterxml.jackson.databind.JsonMappingException;
	import com.fasterxml.jackson.databind.ObjectMapper;

	import media.model.Genres;
	import media.model.MediaContainer;
	import media.model.MediaFactory;
	import media.model.MediaItem;
	import media.model.People;

	public class MediaFactoryAndFilmsTest {
		
		//new media container instance
		static MediaContainer mc = new MediaContainer();
		
		
		@Test	
		public void testMediaFactoryIntegration() {
			
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
			//new media factory instance
			MediaFactory mf = new MediaFactory(mc);
			//assert the film was added
			assertTrue (checkIfFilmAdded(mf));
			
			}

			
			public boolean checkIfFilmAdded(MediaFactory mf) {

				//create new genre
				Genres testGenres = new Genres(3, "tester");
				ArrayList <Genres> test = new ArrayList <Genres>();
				test.add(testGenres);
				
				//create new person
				People testPerson = new People (400, "Jane");
				ArrayList <People> testCast = new ArrayList<People>();
				testCast.add(testPerson);
				
				//call method in media factory
				mf.createFilm(300, "TestFilm", "This is a test", "2020", test, testPerson, testCast);

				//loop each item in media array
				for (MediaItem m : mc.getMediaArray()) {
					//return true if a title equals test film
					if (m.getTitle() == "TestFilm") {
						return true;
					}
				}
			
				return false;
				
			}
	}



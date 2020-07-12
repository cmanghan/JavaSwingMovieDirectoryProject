package UnitTests;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.model.*;
public class TVSeriesTest {

	//new media container
	static MediaContainer mc = new MediaContainer();
	
	@Test
	public void tvSeriesTest() {
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
	
	
	//new genre list
	ArrayList <Genres> genreList = new ArrayList <Genres>();
	genreList.add(new Genres(1, "Action"));
	
	//new people
	People olsen = new People(1, "Ashley Olsen");
	ArrayList <People> castList = new ArrayList <People>();
	castList.add(olsen);
	
	//creating two with the same name to test
	TVSeries series1 = new TVSeries(300, "Full House", "1990", genreList, olsen, castList, "Big family living in a house");	
	TVSeries series2 = new TVSeries(400, "Full House", "2020", genreList, olsen, castList, "Reboot of the original show");
	
	//test statement asserts these are different shows despite having the same name
	assertNotSame(series1, series2);
	
	}
}

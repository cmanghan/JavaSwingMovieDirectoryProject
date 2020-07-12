package media.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class  MediaFactory {
	
	private MediaContainer mc;
	
	//parameterized constructor
	public MediaFactory(MediaContainer catalogue) {
		
		this.mc = catalogue;
	}
	

	public void createFilm (int fid, String title, String description, String year, List <Genres> genreArray, People inputtedPerson, List <People> castList) {
		//creates a new film
		Films newFilm = new Films (fid, title, year, genreArray, inputtedPerson, castList, description);
		//adds created film to media array with all media items
		mc.getMediaArray().add(newFilm);
		//adds film to film array with all films
		mc.getFilms().add(newFilm);
		

		
	}
	
	public void createTVSeries(int tid, String title, String description, String year, List <Genres> genreArray, People inputtedPerson, List <People> castList) {
		//creates a new tv series
		TVSeries newseries = new TVSeries(tid,title, year, genreArray, inputtedPerson, castList, description);
		//adds new series to media array with all media items
		mc.getMediaArray().add(newseries);
		//adds new series to tvseries array with all tvseries
		mc.getTvseries().add(newseries);

	}

}

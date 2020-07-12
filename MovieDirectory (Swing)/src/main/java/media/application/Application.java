package media.application;
/*
 * Application class contains the main method
 */
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import media.controller.MediaController;
import media.model.*;
import media.view.ItemDetailsView;
import media.view.ProfileView;

public class Application {

	
	
	public static void main(String[] args) {
		
		//call the method to start the program
		programStart();
		
	}
		
	public static void programStart() {
		
		//creating a new instance of the MediaContainer class called catalogue
		MediaContainer catalogue = new MediaContainer();
	
		//used for deserialization functionality
		ObjectMapper mapper = new ObjectMapper();

			//surround in a try - catch to handle any erros should they arise
			try {
				//converts JSON to Java
				catalogue = mapper.readValue(new File("JSONMedia.json"), MediaContainer.class); 
				//call the setMediaArray method to add all imported data to the necessary lists
				catalogue.setMediaArray();

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

			
	//create a new profile view instance		
	ProfileView pv= new ProfileView();
	//create a new MediaController and pass to it the instance of the catalogue and the profileview
	MediaController mc = new MediaController(catalogue, pv);
	//call the start method & pass through the first profile as the default
	mc.start(catalogue.getProfiles().get(0));
	
	}
}
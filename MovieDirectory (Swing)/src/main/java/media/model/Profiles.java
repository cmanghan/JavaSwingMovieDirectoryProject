package media.model;

public class Profiles {
	
	//set variables as private
	private String name;
	private int preferredGenre;
	
	//default constructor
	public Profiles() {
		
	}
	
	//parameterized constructor 
	public Profiles (String name, int preferredGenre) {
		
		this.name=name;
		this.preferredGenre=preferredGenre;
		
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPreferredGenre() {
		return preferredGenre;
	}
	public void setPreferredGenre(int preferredGenre) {
		this.preferredGenre = preferredGenre;
	}

}

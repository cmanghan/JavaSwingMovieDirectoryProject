package media.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pid",scope = People.class)
public class People {
	
	//set variables as private
	private int pid;
	private String name;
	
	//default constructor
	public People() {
		
	}
	
	//parameterized constructor
	public People(int pid, String name) {
		
		this.pid = pid;
		this.name = name;
	}
	
	//toString to return name
	@Override
	public String toString() {
		return name;
	}

	//getters and setters
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}

package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import media.model.Profiles;

public class ProfilesTest {

	@Test
	public void profilesTest() {
		//create a new profile
		Profiles tester = new Profiles("Jane", 1);
		
		//assert the constructor worked
		assertTrue (tester.getName() == "Jane");
	}

}

package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import media.model.MediaContainer;
import media.model.MediaFactory;

public class MediaFactoryTest {

	@Test
	public void test() {
		//new media container
		MediaContainer mc = new MediaContainer();
		
		//new media factory
		MediaFactory mf = new MediaFactory (mc);
		
		//asserts the constructor is successfully accepting the parameters
		assertNotNull(mf);
	}

}

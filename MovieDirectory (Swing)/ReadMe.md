1) Reasoning:


I designed this system keeping in mind ease of user interaction, code re-usability & organization, and the open-closed principle.

This program implements the Model - View - Controller pattern. This pattern separates the program into the model, which contains
the underlying data and business logic. 

Model:
In this program the model contains the following classes: Media Items, TVSeries, Films, Genres, People, Profiles, MediaContainer, 
MediaFactory, SortByGenres, and SortByYear.It also contains the following interface: SortingStrategy.

I placed these in the the model because they are independent of the user interface and how the user interacts with the program. Instead, 
these classes define the logic and create the fundamental components of the program. These classes allow for the inputed JSON data and any 
future inputed data to be converted to Java objects.

MediaItem is the parent class of Films and TVSeries. I chose this organization as Films and TVSeries share many features such
as title, year, description etc. Thus, an inheritance structure allowed me to limit code duplication and to add both items to Lists.
For example, an arrayList such as ArrayList <MediaItems> exampleList = new ArrayList <MediaItems>(); can hold objects of both
type Films and TVSeries, as they are both types of MediaItems. In addition, this inheritance structure allows for future extensions
for further media items such as infomercials, podcasts, etc. that share the same basic features.

MediaFactory generates new MediaItems using the Factory Pattern. I chose to use the factory pattern, as it is a useful creational
pattern that can create objects of many types within a single class. Further, it contains the creation behaviour of the objects within the 
model. 

The SortingStrategy interface implements the Strategy design pattern. I chose to use the strategy design pattern in order to provide
numerous ways to sort media items. There are two concrete strategies currently available: SortByYear and SortByGenre. Sort by year
lists the media items from earliest to most recent. SortByGenre lists the media items alphabetically by genre. In cases where a media
item has multiple genres, only the first is considered. Further concrete strategies could be added in the future such as sort by
director or sort by cast. The Strategy pattern is implemented within the model layer, as it involves the manipulation of data.

Controller:
The controller acts as a liaison, as it deals with user requests and gets data from the model. I chose to have a single controller 
in order to reduce duplicating code. As many components within the view interact with one another, having a single controller allows
me to handle all interactions in the same place. 

View:
The view consists of code which interacts with the user. I created a separate view class for each screen the user sees. They
are as follows: AddItemView, GenreView, ItemDetailsView, ProfileView, SelectUserView, and YearView. Each view was separated
into its own class to keep the code easily readable. 

The controller and the view interact to allow for the following to occur:

	1. Default screen is displayed. In this screen, produced by the controller and the ProfileView classes, the user can view the 
	movie recommendations for a default user. The default user was chosen as the first Profile loaded. In this screen 5 movies are 
	displayed. The movies displayed are movies in the profile's preferred genre. If there are not 5 movies in the profile's 
	preferred genre, random movies are generated. For example, if the profile's preferred genre is Animation, but there are only
	two animated movies in the dataset, three random movies will be generated so that the user is always presented with 5 movies. 
	
	On this profile screen, the user is presented with the media item's title, year, and genres. The screen also shows the name 
	of the profile currently being displayed and the following buttons: Switch Profile, Add New, List by Year, and List by Genre.
	
	2. User can chose to switch profile by selecting the 'Switch Profile' button. From the ProfileView screen a new, SelectUserView is displayed. 
	This new screen shows 4 buttons. Each button displays the name of the profile. This program was designed with the assumption there 
	can only be 4 users. This assumption is in line with other popular media platforms such as Netflix and Hulu, which limit the number of users.
	
	When a user selects a new profile, the ProfileView is updated to display media items in the new profile's preferred genre. 
	
	3. User can chose to add a new item by selecting the 'Add New' button. From the ProfileView, a new screen is displayed. This 
	Add new screen allows the user to type in information regarding the new media. Once entered, the user hits save to add the media.
	Once save is hit, the controller, using an action listener, closes the screen and saves the information entered. 
	
	Within the controller the information entered is saved. For entered information which represents objects in the model, existing objects are 
	checked to see if there is already an object with that name existing. For example, if a user enters 'Tim Burton' as a director, the 
	program searchs through all people existing thus far to see if 'Tim Burton' already exists. If, so, the new object is matched to the old. 
	If not, a new object is created. This happens for People entered in the cast field and Genres entered in the genre field as well.
	All fields are saved temporarily in the controller.
	
	Next, the saved information is sent from the controller to the Media Factory class to create a new object. The new object is then added to the 
	relevant collections holding all media. The ProfileView is also refreshed to include the new media, if the Genres entered match the profile's
	preferred genre.
	
	4. User can chose to list all media by year by selecting the 'List By Year' button on the ProfileView. A new 'List By Year' view is generated.
	In this view, all media is displayed, grouped by year. To organize this list, the controller relies on the SortingStrategy interface in the model.
	When sort by year is called in the controller, the sort by year strategy is called in the model. The SortByYear class in the model uses
	a TreeMap in order to keep the order. The key of the TreeMap is the year. The value of the TreeMap is a HashSet of MediaItems. A HashSet is used
	here as TreeMaps do not allow duplicates. However it is reasonable, and likely, that multiple media items will have been released in the same year.
	Thus, this structure allows the TreeMap to keep both items associated with the one year. The controller than loops through the TreeMap and sets
	JLabels with the Year and then the media information. 
	
	5. User can chose to list all media by genre by selecting the 'List By Genre' button on the Profile view. A new 'List By Genre' view is generated.
	In this view, all media is displayed, grouped by genre. Similar to above, the Strategy method is used here. Here, the controller calls the
	SortByGenre class in the model. As with SortByYear, the SortByGenre class uses a TreeMap. 
	
	6. User can view more information about an individual media item. A user can select this option from the ProfileView, the List By Year view, 
	or the List By Genre view. The user selects a media item by clicking on it's title. The title is shown as blue and underlined. When pressed,
	the controller uses a mouselistener to open the itemDetails view. The item details view shows the title, description, year, genre, director or 
	creator (depending on the media type), and the cast. The view also has a back button which uses an action listener to close the screen when clicked.

	
	
2) Test Scenarios 
	
This program has a number of tests in order to ensure its functionality. They are as follows:
		
		Films test: This test first creates a film object. The first test is an assertNull test to ensure the object is null when it is first created.
		As no attributes have been added this test should pass. This test is important as it ensures attributes are not added excepted when done so explicitly. 
		Next the film is instantiated and attributes are added via the constructor. The next test tests if the film object is NotNull. This is important as
		it shows the attributes are being added through the constructor. This should pass. 
		
		Genres test: This test is designed to test the constructor of the Genres class. A genre object is created and if 1 and name "Test Genre" are passed
		through the constructor. The test examines if the id of the object is then equal to 1. This ensures the constructor is setting the attributes to the
		correct variables. 
		
		MediaContainer test: This test ensures the array lists in the media container class are not empty once the json data is read in. This is import as
		it ensures json data is being read in. 
		
		MediaFactory test: This test ensures an object of the MediaContainer is being passed to the MediaFactory through the constructor. The test uses an 
		assertNotNull statement to ensure this is done. This test is important as the MediaFactory performance relies on the MediaContainer passed through.
		
		MediaItem test: This test is designed to test the setters in the MediaItem class. This test first reads in the json data, and then sets the title of a 
		particular item. An assertEquals statement is then used to ensure the title was properly set. 
		
		People test: This test first creates a People object passing through an id and a name. The setter is then used to overwrite the name. Finally, an
		assertEquals statement is used to ensure the name was properly changed. Such a test is important, as actors, directors, etc. often change
		their name due to marriage or other circumstances. Using the setter avoids having to change the json data.
		
		Profiles test: This test is designed to test the constructor and the getter in the Profiles class. Here, a profile is created and a name and id are assigned through
		the constructor. Finally, an assertTrue statement is used to ensure the name fetched using the getter is the same as entered.
		
		SortByGenres test: This test is designed to test that genres are correctly placed in alphabetical order. This is done using an assertEquals statement
		to ensure the first Genre is action. This is important to make sure the view is correct. 
		
		SortByYears test: This test is designed to test that years are correctly placed in order. This is done using an assertTrue statement. Here, the statement
		tests if the first key in the map contains "19". Thus, this shows that the year must contain "19" indicating it is likely in the 20th century. 
		
		TVSeries test: This test illustrates that there can exist two TVSeries with the same name, but that are different objects. This is important as different
		shows may have the same name, but be completely different. This is tested by creating two TVSeries with the same name and using an assertNotSame to show 
		they are not the same object.
		
		MediaFactoryAndFilms test: This class tests the combined functionality of the MediaFactory and Films classes. This tests that the methods createFilm method
		in the MediaFactory class is successfully able to create an object of type Films. The method is used, and if successful the assertTrue statement will pass.
		
		MediaItemAndFilms test: This class tests the inheritance between MediaItems and Films. Here, a film object is created. Next, an asserTrue statement is used
		to test if the Film is an instance of MediaItem. As Films is the child class, this will pass.
		
		ProfilesAndMediaContainerTest: This class tests to ensure a profile is contained in the Array in the Media Items class. This is important to ensure the item
		was imported with the json data. The test loops through all profiles in the array and, using an assertTrue statement, ensures the profile has been imported and 
		correctly added to the array.
		
		
3) User Guide
	
Hello User! Thank you for choosing the CT548 Video Catalogue Program. Here's a guide to get you started. 

When you first open the program you will see the default user profile. On this page you can view 5 media items (films and TV Series) in this users preferred genre. 
Note, if there are not 5 items in the profile's preferred genre, you'll see a few random movies here as well. This is to ensure you always have movies to chose from!

 There many things you can do from this home page:
 
 	1. View an items details : 
 		When a title is blue and underline that means you can click it to view further information regarding that item.
 	
 	2. Switch the user profile:
 		Click the 'Switch Profile' button to toggle between users. When a new user is selected the home profile view will reload with 5 movies in the new profile's preferred genre. 
 	
 	3. Add a new media item:
 		Click the 'Add New Button' to add new items. Simply enter the item details in the spaces provided and the new media item will be saved to the database. 
 		
 	4. List all media items by year:
 		Click the 'List By Year' button to view all media items in the database ordered by year. 
 	
 	5. List all media items by genre:
 		Click the 'List By Genre' button to view all media items in the database ordered by genre.
 		
 Remember, any time you see a title in blue and underlined you can click it to view more information about that media item.
 To exit the program simply click the 'X' button in the top toolbar.
 
 
 
 
 4) Digital - Physical Extension
 
 The media creation subsystem can be easily extended in the future to create movies and series that are physical separate from digital ones. To do so, the programmer could make the Films class abstract and make it the parent class of two new classes: PhysicalFilms and DigitalFilms. These child classes could have additional attributes such as digitalDownloadCode or physicalReleaseDate.
 
 Similarly, the programmer would make the TVSeries abstract and create two child classes: PhysicalFilms and Digital Films. As with above, these child classes could have additional attributes. Yet, they would still share the same parent attributes. 
 
 
 5) Further Extension
 
 This system can be further extended to include infomericals. Infomericals are another type of watchable media that cannot be 
categorized as either a film or a TVShow. While informercials are broadcast on television, they are a type of commercial and 
are therefore distinct from TVSeries.

The system could be extended to include informercials by creating an infomericals class that also extends MediaItem. In addition
to the variables in the mediaItem class, the infomericals class may have additional characteristics such as iid, presenter, sponsor, etc. 

The infomericals would then be displayed alongside films and tvseries in views such as list by year or list by genre (note, 
example infomerical genres include kitchen products, clothing, outdoor items, etc.). As with all media items, a user could 
click on the infomerical for more information. 
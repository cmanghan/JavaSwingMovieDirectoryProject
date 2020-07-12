Reasoning:


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

	
	

# Vine

![Vine icon](https://github.com/sumandascoder/Vine/blob/develop/res/drawable-hdpi/ic_launcher.png)

## Overview

**Vine**, is a social Profiling Tool for watching videos.

### Developer

#### Suman Sucharit Das (my@email.com)

### Approached

#####Applied Three- Pronged Approach:
1. **As a Designer and Product Owner:**  
The UI needs to be lucid and user friendly leading to nice User Experience. Following are the guidelines taken into consideration:  
 	-Simple Workflow model that let the user navigate quite scholastically across screens 
	-Simplicity is the key, the naming of widgets are to be intuitive
 	-Small Animations to keep user engaged 

2. **As a Developer and Architect:**  
Basic functionality is based on the MVC design pattern, where we have to have a call to Vine API, obtain and process the result and display it on the UI.  I have three main sub folders in source directory, one is the Model(the datahandler section), View(the UI section) and the Controller (the webservices section).  
Started off with having a skeleton designed that has some UI with basic functionality such as a button on Application Entry screen,clicking on which launches the API call to run in background and publish the result when successfully completed to the UI screen fragments. If there are errors in the result please alert the user appropriately with Alert Notifications.  
Once the result sets are populated and we have the fragments ready where List Fragment contains all the thumbnail images which are links to specific videos that gets to be played on the second fragment on the UI that is the Detail Fragment. This is the basic functionality desired from the Project which I came up with in first slot.  
Once the dancing skeleton was ready, moved to polishing the work with using better patterns and logic like View Holder Pattern, Communicators,CustomListView Adapters, etc.    
Ultimately taking care of the errors and bugs like Non Responsive links provided, no internet connection, Illegal Data, Workflow failures are handled leading to completion of the task.  

3. **As a Tester**  
Understanding the user's mindset and random input such as ASCII, strings, invalid userid as text input. Validating the functionality if caters to business needs.  
Identify cases of No Wifi, valid entry, invalid entry, no entry in all possible combinations. Widgets and colors chosen are sober. 
Documentation is accurate for team-mates is also ensured. 

### Libraries & Resources Considered
1. Android Developer Website
2. Examples of Patterns to be used in the UI design
3. Http Result Sets
4. Free Image sources (https://www.iconfinder.com/search/?q=v)
5. Mou for writing Markdown
Started off with GSON and ObjectMapper as Parser but switched to own built JSON parser.




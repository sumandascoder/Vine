# Vine

![Vine icon](https://github.com/sumandascoder/Vine/blob/develop/res/drawable-hdpi/ic_launcher.png)

## Overview

**Vine**, is a social Profiling Tool for watching videos.

### Developer

#### Suman Sucharit Das (my@email.com)

### Approached

#####Applied Three- Pronged Approach:
1. **As a Designer and Product Owner:**  
The UI needs to lucid and user friendly to have a nice User Experience. Following are the guidelines followed:  
 	-Simple Workflow model that let the user navigate quite scholastically  
	-Simplicity is the key, the naming of widgets are to be intuitive
 	-Small Animations to keep user engaged 

2. **As a Developer:**  
Basic functionality is based on MVC format to have a Vine API call, obtain and process the result and thereafter display it on the UI.  
So, simplest way is to have a skeleton designed that has some UI with basic functionality such as a button on Application Entry screen, which launches the API call to run in background and publish the result when successfully completed to the UI screen the fragments. If there are errors in the result please alert the user appropriately with Alert Notifications.  
Once the result sets are populated and we have the fragments ready where List Fragment contains all the thumbnail images which are links to specific videos that gets to be played on the second fragment on the UI that is the Detail Fragment. This is the basic functionality desired from the Project  
Taking care of the errors and bugs like Non Responsive links provided, no internet connection, Illegal Data, Workflow failures are handled  

3. **As a Tester**  
Understanding the user's mindset and playful options by providing illegal options like ASCII, strings, invalid userid as text input. Validate the functionality if behaving as per business needs.  
Identify cases of No Wifi, valid entry, invalid entry, no entry in all possible combinations. Widgets and colors chosen are sober. 
Documentation is accurate for team-mates is also ensured. 

### Libraries & Resources Considered
1. Android Developer Website
2. Examples of Patterns to be used in the UI design
3. Http Result Sets
4. Free Image sources (https://www.iconfinder.com/search/?q=v)
5. Mou for writing Markdown
Started off with GSON and ObjectMapper as Parser but switched to own built JSON parser.


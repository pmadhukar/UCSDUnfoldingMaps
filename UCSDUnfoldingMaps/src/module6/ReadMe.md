Extensions:  
  
1. Display a pop up menu (off the map) if a city is clicked:  
a. If city has any nearby quake (city falls within threat circle of any quake), then following info shown in pop up:  
 city name, city country, count of nearby quakes, avg. magnitude of nearby quakes, count of recent quakes (past day or past hour).  
b. If city doesn't have any nearby quake, then city name and city country are displayed along with the message "No Nearby Quakes".  
  
2. Used three different map providers, and change the providers dynamically, on the basis of key presses.  
key press "1" -> change the map to GoogleMapProvider (the default map provider for the course)  
key press "2" -> change the map to Microsoft's AerialProvider(the map shown in the screenshot)  
key press "3" -> change the map to GoogleTerrainProvider  
key press "r" or "R" -> Reloads the currently selected map.   
Reloading map is useful if due to connectivity issues, map couldn't load properly and some tiles are left blank, which happened few times with me for Microsoft's AerialProvider map. So reloading will make sure that map is loaded again (With state of the markers same as it was before reloading).  
  
3. Show latitude and longitude (as coordinates) of the location at the current cursor position.  
Also the text color of coords change on the basis of maps selected.  
If map is GoogleMapProvider/GoogleTerrainProvider then text color of latitude and longitude is black otherwise the color is white.  
  
Also an instruction label is shown below the Earthquake key, which details the results of pressing different keys as mentioned in step 2.  

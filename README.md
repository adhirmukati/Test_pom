# Westwing_POM
Page object model devloped for westwing also inculded docker implementation 



For execution on docker/chrome

make sure docker is installed 
run following command 
**docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:latest
docker ps**

Change config.properties file to
browserName = dockerchrome

For execution on chrome / windows 
First update config.properties file 
**browserName = chrome**

For execution on firefox/windows
Change config.properties file to
**browserName = firefox**


To run From command prompt please use following steps
open command prompt
Navigate to folder where pom.xml is 

execute using this command 
**mvn test -Dcucumber.options=”src/test/resources/WW_Search.feature” **


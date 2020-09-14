# MyToys_RestAPI
Steps to execute the API:


1. Install Java8 and set JAVA_HOME environment variable
    1. https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
    2. For MAC goto terminal and do following steps:
		vi ~/.bash_profile
		Insert : export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home (Choose path from your system)
2. Install Maven Latest Version from https://maven.apache.org/download.cgi
3. Set Maven Home in environment variables :
        1. vi ~/.bash_profile
        2. export M2_HOME=/Users/temp/apache-maven-3.6.3 (use your system path)
4. Install Tomcat8
		1. http://tomcat.apache.org/download-80.cgi
		2. Add the tomcat path to the CATALINA_HOME system variable.
		export CATALINA_HOME=/Users/temp/apache-TOMCAT-8.5.57 (use your system path)
		3. Open /conf/tomcat_users.xml and add the user role , username and password
		4. Start tomcat and verify installation.
5. Install M2E – useful Maven plugin for Eclipse / or similar for your IDE

	1. In Eclipse go to Help ⇒ Install new Software ⇒ Add and use the location: http://download.eclipse.org/technology/m2e/releases	
￼
	2. Restart Eclipse.

6. Download the API from my GIT location
￼https://github.com/ritika9787/MyToys_RestAPI

7. Update Maven Project : Right click the project and select Maven ⇒ Update Project.
8. Run Maven Build : Right Click the project and select Run As : Maven Build and add to the goal : clean install
9. War file will be created in target folder : 
		consumerData-0.0.1-SNAPSHOT.war
10. Configure tomcat server in Eclipse IDE 
	https://beginnersbook.com/2017/06/how-to-configure-apache-tomcat-server-in-eclipse-ide/

	You can do similar for any other IDE you are using.

    11. Run the Project on Server

Deployment in Eclipse:
1. Right click your project and select Run As ⇒ Run on Server
2. Eclipse will open the internal web browser, but we have to change the URL to “http://localhost:8080/consumerData/product”

Deployment in Tomcat directly:
1. Copy the “consumerData-0.0.1-SNAPSHOT.war” file into your %CATALINA_HOME%/webapps folder.
2. Go to the terminal and enter: %CATALINA_HOME%\bin\startup.bat
3. Open Web Browser and run “http://localhost:8080/consumerData/product”

You will see the JSON Response.

Hitting the API using CURL:
Once Server is up and running goto terminal and type 
curl -v http://localhost:8080/consumerData/product

You will see the JSON response.


11. Executing as JAVA Application
There is App.java file in project that can be run as Java Application to see result in console.

12. Executing unit test case
ProductCSVToObjectTest file in src/test/java : com.myToys.restAPI.consumerData.utils package can be right clicked and run as JUNIT test.



        



		
		


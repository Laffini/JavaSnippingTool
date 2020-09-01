# JavaSnippingTool
 
![Java CI with Maven](https://github.com/Laffini/JavaSnippingTool/workflows/Java%20CI%20with%20Maven/badge.svg)

The JavaSnippingTool is an extendable screenshot grabbing application. The application uses Adapters to ‘plug-in’ features and actions to be performed when a screenshot is taken.
To customise the application comment-out/remote Adapters from the adapters.xml file. This is currently located within the JAR when compiled so requires unzipping the JAR file to make the changes.

## How to use the application
1.	Build the project using Maven (mvn install).
1.	Execute the jar file by either (replace [VERSION] with the version in pom.xml):
    -	Navigating to the directory of the JAR in a CMD terminal and entering:  
**java -jar JavaSnippingTool-VERSION-pkg.jar**
    -	Create a .bat file (e.g JavaSnippingTool.bat) and entering:
**java -jar C:\Users\YOUR_USERNAME\Documents\JavaSnippingTool-VERSION-pkg.jar**
The path used is an example, enter the location of the JAR file on your PC. To run the .bat file double click on it.
3.	It may not be obvious that the application is running as it takes a screenshot of your current desktop, however if you click and drag your mouse you will see a blue box appear (as seen in the image below). This will be the area captured. 

![test](https://github.com/Laffini/JavaSnippingTool/blob/master/Images/demo.png)

# TestProject2021

<h1>Buggy Car Rating Automation Testing </h1>

This is a java selenium automation project using TestNG framework to automate the features of Buggy cars rating app. 

<h2>Pre-Requisites:</h2>
<p>The following software and tools are required to run this project.</p>
<ul>
<li>Programming Language: Java (1.8)</li>
<li>Build Management : Maven </li>
<li>Plug-In: TestNG framework (7.4.0)</li>
<li>Development tool: Eclipse IDE </li>
</ul>

<h2>Automation Test Scenarios</h2> 
<p>	User Registration (DDT method)</p>
<ul>
	<li>Testing of user registration with valid data and invalid data</li>
	<li>Data is passed through csv file and also through data provider annotations in code.</li>
	</ul>
<p>User Profile (DDT method)</p>
	<ul><li>Testing of user profile updates with valid and invalid data</li></ul>
	
<p>User Login</p>
	<ul><li>Testing of user login with valid login credentials</li></ul>
<p>User Logout</p>
	<ul><li>Testing of successful logout from the application</li></ul>
<p>Overall Rating Tally with Popular Model and Popular Make </p>
	<ul><li>Testing the validation of Overall Rating / Rank in the Overall Rating page and its display within the Popular Model page</li></ul>

<h2>Framework explained:</h2>

For the test case design within my TestNG framework, I have used the Page Object Model with Page Factory. 
<p>
Reason for using this in my test case design is to create specific object repositories for the Web UI elements which will help avoid duplication 
<br/>and assist with easy maintenance of the tests. 

<h2>Project Folder Structure:</h2>
<p>com.buggy.tests : All tests are maintained in this folder
<p>com.buggy.pages : All web elements and methods for the tests are maintained in this folder. The page names correspond to the respective tests.
<p>com.buggy.helper :  This folder has following files
	Web driver initialisation class based on the browser name passed.
	Helper class to read contents from CSV file.
<p>com.buggy.framework : This folder has base test class to initialise chrome web driver.
<p>com.buggy.models : This folder has User model, which is used by Profile and Register page classes.
<p>Src/test/resources:  This folder has CSV file to store test data.

<h2>Test Execution:</h2>

<p> Command Line Execution:</p>
	Open command prompt and browse to the project folder and run the following command
<p>	<code>mvn clean test</code>

<p> Running from inside project:<p>
Once the project is open in eclipse with all pre requisite software loaded and compiled file, right click on BuggyTestSuite.xml and select RunAs-> TestNG Suite to run all test suites.
















Feature: login into account 
	Existing user should be able to login to account using correct creadentials

Scenario: Login to account using correct creadentials 
	Given user connect to expertest website 
	And user survol the Espace abonné button 
	And user click on the Mon compte button 
	And user enters a valid email adress 
	And user enters a valid password 
	When user click on the Identification button 
	Then user should be taken to the successful login page 
	

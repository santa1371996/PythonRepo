Feature: Home Page links Redirects Successfully

#Background:
#	Given login application URL
#	Then Navigate to mydetails page

@SanityTest
Scenario: Logged user can navigate to my details page
	Given I navigate to Inside UCL app
	When I login to application
	And I click on Mydetails Tile
	Then I should see Mydetails page
#	When I click on MyTimeOff Tile
	Then I should see MyTimeOff page

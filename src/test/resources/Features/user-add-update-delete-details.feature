Feature: My Details
  In order to update my details
	As a logged user
	should be able to add , edit and cancel new details

Background:
	Given login application URL
	Then Navigate to mydetails page

@End2EndTest
Scenario: User can add basic details

	Given I click on basic details
	When I click on Edit details
	Then Title Firstname Lastname should not get edited
	And DOB NI number Nationality should not get edited
	When No details entered then review changes is disabled
	Then I should enter optional basic details
	Then review changes button is Enabled
	Then I click on Cancel then continue editing
	Then I click on review changes
	And I click on Save changes

@End2EndTest
Scenario: User can add contact details

	Given I click on Contact details
	When I click on Edit details
	Then No details entered then review changes is disabled
	When I should enter mandatory <address1> and <address2>
	Then I enter optional contact details
	Then Click on Add alternative and add <address3>
	And Delete alternative address
	Then review changes button is Enabled
	Then I click on Cancel then continue editing
	Then I click on review changes
	And I click on Save changes

	Examples:
	| address1 | address2 | address3 |
	| Baner | Balewadi | Aundh |


@End2EndTest
Scenario: User can add emergency contact details

	Given  I am navigating to Emergency Contact details
	Then  I should see Emergency contact details
	When  I click Add emergency contact
	Then  I enter mandatory fields
		| Fields                 | Values              |
		| Relationship           | Sister              |
		| Last Name              | Kenny               |
		| Address1               | abc , pune          |
		| Address2               | Pineway, madhurai   |
	Then  I enter optional fields
		| Fields                 | Values              |
		| Title            		 | Mr              	   |
		| First Name             | Peter               |
		| Email               	 | aaa@gmail.com       |
		| Mobile Number          | 7894368   		   |
	And  I click on review changes
	#Then  I click on Cancel
	#And  I click on review changes
	Then  I click on Save changes

@End2EndTest
Scenario: User can edit emergency contact details

	Given  I am navigating to Emergency Contact details
	When  I click Edit emergency details
	Then  I should Edit Mandatory fields
	Then  I should Edit optional fields
	Then  I click on review changes
	Then  I click on Save changes
	Then  I click on review changes and verify changes
	Then  I click on Save changes

@End2EndTest
Scenario: User can edit Equality,Diversity and Inclusions details

	Given  I am navigating to EDI
	When I click Edit EDI
	Then I edit EDI fields
	And I click on review changes
	Then I click on Save changes

@End2EndTest
Scenario: User can add education and qualification details

	Given I click on Education and qualification
	When I click on Add Qualification
	Then I should complete mandatory and optional details
		| Fields                 | Values              |
		| Title            		 |BDD cucumber workshop|
		| Awarding             	 | First class         |
	And I should add the subject
	Then I should delete the subject and verify subject deleted
	And I click on review changes
	Then I click on Save changes


@End2EndTest
Scenario: Use can add disability details

	Given I click on Disability
	When I click on Add disability record
	And I select <disabiltyType> as disability
	Then Verify Reason field is disabled or enabled according to <disabiltyType>
	Then Select reason if disabilityType is yes
	Then Select reason if disabilityType is yes
	Then Add StartDate and EndDate for disability
	Then I click on Cancel

	Examples:
		| disabiltyType |
		| No |
		| Yes |

@End2EndTest
Scenario: User can edit disability details

	Given I click on Disability
	When I click on Edit disability record
	And I select <disabiltyType> as disability
	Then Add StartDate and EndDate for disability
	Then I click on Cancel

	Examples:
		| disabiltyType |
		| No            |
		| Yes           |

@End2EndTest
Scenario: User can view employment history details

	Given I click on Employment history
	When I click on View employment details
	Then Verify employment details fields

@End2EndTest
Scenario: User can edit work location details

	Given I click on Work locations
	When I click on Edit location details
	And I should Edit location details
	And I click on review changes
	Then I click on Save changes


@End2EndTest
Scenario: User can add bank details

	Given Starting TestCase "Bank details functionality"
	Given I click on Bank details
	When I click on Edit Bank details
	And I should Edit Bank details
	#And  I click on review changes
	#Then  I click on Save changes
	Then  I click on Cancel

@End2EndTest
Scenario: User can add update skills details

	Given I click on skills
	When I should Add skills
	And I should delete skills
	Then I click on Save changes

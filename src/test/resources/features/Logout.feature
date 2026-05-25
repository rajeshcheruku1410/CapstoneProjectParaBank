Feature: Logout Functionality

Scenario: Verify logout functionality
Given User launches ParaBank application
When user logs into parabank for logout
And user clicks logout link
Then user should logout successfully


Scenario: Verify session termination after logout
Given User launches ParaBank application
When user logs into parabank for logout
And user clicks logout link
Then user session should terminate successfully
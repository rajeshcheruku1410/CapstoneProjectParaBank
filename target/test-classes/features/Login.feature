Feature: Login Functionality

Scenario: Login with valid username and password
Given User launches ParaBank application
When User enters valid username and password
And User clicks login button
Then User should navigate to account overview page


Scenario: Login with invalid username
Given User launches ParaBank application
When User enters invalid username and valid password
And User clicks login button
Then User should see invalid login error message


Scenario: Login with invalid password
Given User launches ParaBank application
When User enters valid username and invalid password
And User clicks login button
Then User should see invalid login error message


Scenario: Login with blank credentials
Given User launches ParaBank application
When User enters blank username and password
And User clicks login button
Then User should see invalid login error message


Scenario: Verify all UI elements on login page
Given User launches ParaBank application
Then User should verify username textbox
And User should verify password textbox
And User should verify login button


Scenario: Verify error message for invalid login
Given User launches ParaBank application
When User enters invalid username and password
And User clicks login button
Then User should see invalid login error message
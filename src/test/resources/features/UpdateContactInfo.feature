Feature: Update Contact Information Functionality

Scenario: Navigate to update contact information page
Given User launches ParaBank application
When user logs into parabank for update contact info
And user clicks on update contact info link
Then user should navigate to update contact info page



Scenario: Update contact details with valid data
Given User launches ParaBank application
When user logs into parabank for update contact info
And user clicks on update contact info link
And user enters valid contact details
And user clicks update profile button
Then contact details should update successfully


Scenario: Update contact details with invalid data
Given User launches ParaBank application
When user logs into parabank for update contact info
And user clicks on update contact info link
And user enters invalid contact details
And user clicks update profile button
Then user should see invalid update behavior


Scenario: Verify updated contact information
Given User launches ParaBank application
When user logs into parabank for update contact info
And user clicks on update contact info link
And user enters valid contact details
And user clicks update profile button
Then user should see updated contact information message
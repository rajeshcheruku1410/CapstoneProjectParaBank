Feature: Transfer Funds Functionality

Scenario: Navigate to transfer funds page
Given User launches ParaBank application
When user logs into parabank for transfer funds
And user clicks on transfer funds link
Then user should navigate to transfer funds page


Scenario: Transfer funds between accounts with valid data
Given User launches ParaBank application
When user logs into parabank for transfer funds
And user clicks on transfer funds link
And user enters valid transfer amount
And user clicks transfer funds button
Then fund transfer should be successful



Scenario: Transfer funds with invalid amount
Given User launches ParaBank application
When user logs into parabank for transfer funds
And user clicks on transfer funds link
And user enters invalid transfer amount
And user clicks transfer funds button
Then user should see invalid transfer behavior



Scenario: Verify success message after fund transfer
Given User launches ParaBank application
When user logs into parabank for transfer funds
And user clicks on transfer funds link
And user enters valid transfer amount
And user clicks transfer funds button
Then user should see transfer success message
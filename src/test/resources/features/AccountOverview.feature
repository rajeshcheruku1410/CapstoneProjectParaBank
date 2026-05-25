Feature: Account Overview Functionality

Scenario: Verify account overview page after login

Given User launches ParaBank application
When user logs into ParaBank application
And user clicks on accounts overview
Then user should navigate to accounts overview page


Scenario: Verify account details and balances are displayed

Given User launches ParaBank application
When user logs into ParaBank application
And user clicks on accounts overview
Then user should see account details and balances
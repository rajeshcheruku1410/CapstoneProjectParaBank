Feature: Bill Pay Functionality


Scenario: Navigate to bill pay page
Given User launches ParaBank application
When user logs into parabank for bill payment
And user clicks on bill pay link
Then user should navigate to bill pay page


Scenario: Pay bill using valid details
Given User launches ParaBank application
When user logs into parabank for bill payment
And user clicks on bill pay link
And user enters valid bill payment details
And user clicks send payment button
Then bill payment should be successful


Scenario: Pay bill using invalid details
Given User launches ParaBank application
When user logs into parabank for bill payment
And user clicks on bill pay link
And user enters invalid bill payment details
And user clicks send payment button
Then user should see invalid bill payment behavior


Scenario: Verify bill payment confirmation message
Given User launches ParaBank application
When user logs into parabank for bill payment
And user clicks on bill pay link
And user enters valid bill payment details
And user clicks send payment button
Then user should see bill payment confirmation message
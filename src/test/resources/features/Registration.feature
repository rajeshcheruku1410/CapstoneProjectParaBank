Feature: Registration Functionality

Scenario: Navigate to user registration page
Given User launches ParaBank application
When user clicks on register link


Scenario: Register new user with valid details
Given User launches ParaBank application
When user clicks on register link
And user enters firstname
And user enters lastname
And user enters address
And user enters city
And user enters state
And user enters zipcode
And user enters phone number
And user enters ssn
And user enters username
And user enters password
And user enters confirm password
And user clicks register button
Then user should register successfully


Scenario: Register user with missing mandatory fields
Given User launches ParaBank application
When user clicks on register link
And user clicks register button without entering mandatory fields
Then user should see mandatory field error


Scenario: Verify successful registration message
Given User launches ParaBank application
When user clicks on register link
And user enters firstname
And user enters lastname
And user enters address
And user enters city
And user enters state
And user enters zipcode
And user enters phone number
And user enters ssn
And user enters username
And user enters password
And user enters confirm password
And user clicks register button
Then user should register successfully
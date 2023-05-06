#Author
#Date
#Description
@SmokeScenario
Feature: feature to test add journal functionality

  @SmokeTestNabilah
  Scenario Outline: view journal 
    Given user is log in
		When user click login button
		Then navigate to home page
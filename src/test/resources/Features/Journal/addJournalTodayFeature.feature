#Author
#Date
#Description
@SmokeScenario
Feature: feature to test add journal functionality
    
  @SmokeTestNabilah
	 Scenario Outline: add journal is successful
	  Given user is have log in
	  And user clicks on add journal
	  When user input journal "<question>" and "<answer>"
	  When user clicks on submit button
	  Then user is navigated to home page

    Examples: 
      | question         |  | answer       |
      | How are u today? |  | I feel sucks |
      | <blank>          |  | I feel sucks |
      | How are u today? |  | <blank>      |
      | <blank>          |  | <blank>      |

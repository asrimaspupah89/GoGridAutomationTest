#Author
#Date
#Description
@SmokeScenario
Feature: feature to test deleteAll funcionality

  @SmokeTest
  Scenario: check delete journal is successful with valid credentials
    Given user is logged in
    When user clicks on delete icon
    And click on ok button
    Then user is navigated to the homepage
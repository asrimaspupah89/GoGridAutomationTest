#Author
#Date
#Description
@SmokeScenario
Feature: feature to test export journal funcionality

  @SmokeTest
  Scenario: check export journal is successful with valid credentials
    Given user is logged in
    When user clicks on session icon
    And click on export page
    Then click on generate to PDF
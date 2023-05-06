#Author : M Nabil Haritshah Away
#Date   : 01-05-2023
#Description
@SmokeScenario
Feature: feature to test login functionality

  @SmokeTest
  Scenario: Check login is successful with valid credentials
    Given browsers is open
    And users is on login page
    When users enters kuncenaman and Lima12345
    And click on login button
    Then user is navigated to the home pages
    And click on profile picture
    And click on setting button
    When user enter firstname and lastname
    And click on save button



  @SmokeTest
  Scenario Outline: Check login is successful with valid credentials
    Given browsers is open
    And users is on login page
    When users enters kuncenaman and Lima12345
    And click on login button
    Then user is navigated to the home pages
    And click on profile picture
    And click on setting button
    When user enter "<firstname>" and "<lastname>"
    And click on save button



    Examples:
      | firstname   |  | lastname |
      | away       |  | away     |
      | <blank>    |  | <blank>  |
      | away       |  | <blank>  |
      | <blank>    |  | tes123   |


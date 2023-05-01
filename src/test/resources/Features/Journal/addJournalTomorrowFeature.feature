#Author
#Date
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
    And click on date tomorrow
    And click add grid journal
    When user enter question and answer
    And click on submit button
    Then users is navigated to the home pages
    And click on date tomorrow2

  @SmokeTest
  Scenario Outline: Check login is successful with valid credentials
    Given browsers is open
    And users is on login page
    When users enters kuncenaman and Lima12345
    And click on login button
    Then user is navigated to the home pages
    And click on date tomorrow
    And click add grid journal
    When user enter "<question>" and "<answer>"
    And click on submit button
    Then users is navigated to the home pages
    And click on date tomorrow2


    Examples:
      | question   |  | answer |
      | away       |  | away     |
      | <blank>    |  | <blank>  |
      | away       |  | <blank>  |
      | <blank>    |  | tes123   |


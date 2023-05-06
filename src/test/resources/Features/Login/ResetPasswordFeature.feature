#Author : Fanny Putria Agustina
#Date	: 05/05/2023
#Description : Testing GoGrids add event with participant feature
@SmokeScenario
Feature: Reset Password

  @SmokeTestFanny
  Scenario Outline: Reset Password
    Given open browser
    And user click Reset Password
    And user input username "<username>"
    When user click on submit button
    Then page show message created notification

    Examples: 
      | username    |
      | fannyputria |
      | fannyagustina  |
      | fannyputtriiaa |

#Author : Reihan Reinaldi Suryaman
#Date	: 22/04/2023
#Description : Testing GoGrids view event feature

@SmokeScenario
Feature: View event list
  Scenario: Check view event when there is no event
    Given browser is open
    And user is on home page
    When user click on timeline menu
    Then user should not be able to see any event

  Scenario: Check view event when there is one event
    Given browser is open
    And user is on home page
    And there is already one event entered
    When user click on timeline menu
    Then user should be able to see 1 event

  Scenario: Check view event when there is more than one event
    Given browser is open
    And user is on home page
    And there is already two events entered
    When user click on timeline menu
    Then user should be able to see 2 event

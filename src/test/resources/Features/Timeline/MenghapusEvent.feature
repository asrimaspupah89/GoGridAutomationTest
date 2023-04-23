#Author : Reihan Reinaldi Suryaman
#Date	: 22/04/2023
#Description : Testing GoGrids delete event feature

@SmokeScenario
Feature: Delete Event
  Scenario: Check delete event
    Given browser is open
    And user is on home page
    And there is already one event entered
    When user click on timeline menu
    And user click on trash icon
    Then event is deleted
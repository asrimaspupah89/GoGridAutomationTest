#Author : Rafli Lutfiansyah Mauluddin
#Date	: 09/04/2023
#Description : Testing GoGrids add event feature
@SmokeScenario
Feature: add event in calendar page

  @SmokeTest
  Scenario Outline: add event without participant in later date
    Given browser is open
    And user is on calendar page
    When user click on <n> days later
    And user enters event <title>
    And user click submit button
    Then page show event created notification
    And event show in box
    Examples: 
      | title   |  | n  |
      | "Test1" |  | 1  |
      | "Test2" |  | 2  |
      | "Test3" |  | 5 |
  
  @SmokeTest
  Scenario: add event without participant and title in later date
  	Given browser is open
    And user is on calendar page
    When user click on 1 days later
    And user click submit button
    Then show event name required message
  
  @SmokeTest
  Scenario Outline: add event with participant in later date
  	Given browser is open
    And user is on calendar page
    When user click on 1 days later
    And user enters event <title>
    And user add <n> participants
    And user click submit button
    Then page show event created notification
    And event show in box
    Examples:
    	| title   |  | n |
      | "Test4" |  | 1 |
      | "Test5" |  | 2 |
      | "Test6" |  | 3 |
  
  @SmokeTest
  Scenario: add event with participant but without title in later date
  	Given browser is open
    And user is on calendar page
    When user click on 1 days later
    And user add 1 participants
    And user click submit button
    Then show event name required message
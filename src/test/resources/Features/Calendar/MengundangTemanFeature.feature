#Author : Fanny Putria Agustina
#Date	: 05/05/2023
#Description : Testing GoGrids add event with participant feature
@SmokeScenario
Feature: add event with participant in calendar page

  @SmokeTestFanny
  Scenario Outline: add event with participant in later date
    Given browser open
    And user on calendar page
    When user click 7 days later
    And user enter event "<title>"
    And user add <n> participant
    And user click button
    Then page show created notification
    And show in box

    Examples: 
      | title                   |  | n       |
      | coba test case          |  |       1 |
      #| pengumpulan praktek PPL |  |       3  |
      #| makan bersama           |  | <blank> |
  
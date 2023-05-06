#Author : Zahwa Putri Hamida
#Date	: 05/05/2023
#Description : Testing GoGrids Add Journal Yesterday
Feature: feature to test Add Journal Yesterday functionality

  @SmokeTestZahwa
  Scenario Outline: check add journal yesterday is successful
    Given user is have log in
    And user clicks on date yesterday
    When user clicks add journal yesterday
    And user input "<question>" and "<answer>"
    When user clicks on submit button
    Then user is navigated to homepage

    Examples: 
      |      question      |     |         answer             |
      | Lagu yang aku suka |     |  Photograph - Ed Sheeran   |
      | Lagu yang aku suka |     |          <blank>           |
      |      <blank>       |     |  Photograph - Ed Sheeran   |
      |      <blank>       |     |          <blank>           |
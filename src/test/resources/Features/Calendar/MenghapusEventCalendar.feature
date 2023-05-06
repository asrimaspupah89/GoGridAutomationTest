#Author : Zahwa Putri Hamida
#Date	: 26/04/2023
#Description : Testing GoGrids Delete Event Calendar
@SmokeScenario
Feature: feature to test Delete Event Calendar functionality

  @SmokeTestZahwa
  Scenario Outline: check delete event calendar is successful
    Given browser open
    And user on calendar page
    When user clicks event Calendar "<event>"
    And user clicks Delete
    Then page show event created notifications

    Examples: 
      | event |
      | ultah |
      | grill |
      | foto  |

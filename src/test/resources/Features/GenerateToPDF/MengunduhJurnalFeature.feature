#Author : Rafli Lutfiansyah Mauluddin
#Date	: 16/04/2023
#Description : Testing GoGrids add event feature
@SmokeScenario
Feature: Download journal in pdf type

  @SmokeTest
  Scenario: Download journal in pdf type
    Given browser is open
    And user is on export page
    When user clicks on generate pdf button
    Then page show pdf generated notification

#Author : Diana Fauziah
#Date	: 19/04/2023
#Description : Testing GoGrids Registration Features
@SmokeScenario
Feature: registration features

  @SmokeTestDiana
  Scenario Outline: successfully add new user with registration
  Given browser open
  And user on login page
  And user Click button register now
  And user enters "<firstname>", "<lastname>", "<email>", "<username>", "<password>", "<confirmPassword>"
  When user click on submit button
  Then user navigated to login page
  
  Examples:
  | firstname |  | lastname |  | email                     |  | username  |  | password  |  | confirmPassword |
  | Reni      |  | febriani |  | febrianireni312@gmail.com |  | Renii2802 |  | Renii2802 |  | Renii2802       |
  @SmokeTestDiana
  Scenario Outline: unsucces add new user with registration
    Given browser open
    And user on login page
    And user Click button register now
    And user enters "<firstname>", "<lastname>", "<email>", "<username>", "<password>", "<confirmPassword>"
    When user click on submit button
    Then user on register page

    Examples: 
      | firstname |  | lastname |  | email                     |  | username  |  | password  |  | confirmPassword |
      | permana   |  | irawanto |  | <blank>                   |  | Permana13 |  | Permana13 |  | Permana13       |
      | <blank>   |  | irawanto |  | mrifaldipermana@gmail.com |  | Permana13 |  | Permana13 |  | Permana13       |
      | permana   |  | <blank>  |  | mrifaldipermana@gmail.com |  | Permana13 |  | Permana13 |  | Permana13       |
      | permana   |  | irawanto |  | mrifaldipermana@gmail.com |  | <blank>   |  | Permana13 |  | Permana13       |
      | permana   |  | irawanto |  | mrifaldipermana@gmail.com |  | Permana13 |  | <blank>   |  | Permana13       |
      | permana   |  | irawanto |  | mrifaldipermana@gmail.com |  | Permana13 |  | Permana13 |  | <blank>         |
      | <blank>   |  | <blank>  |  | <blank>                   |  | <blank>   |  | <blank>   |  | <blank>         |

#Author : Syahda Afia Dhiya Ulhaq Tajudin
#Date	: 01/05/2023
#Description : Testing GoGrids update event feature
@SmokeScenario
Feature: update event in calendar page

	@SmokeTestSyahda
	Scenario Outline: Check update event is successful
		Given Browser is open
		And User is on calendar page
		When User click event "<eventName>" on calendar
		And User update event "<title>"
		And User add <participant>
		And User click update button
		Then Page show event updated notification
		
		Examples: 
      |  eventName  |  |   title  |  | participant |
      | Graduation  |  | _Updated |  |      0      |
      | Birthday	  |  |          |  |      1      |
      | Anniversary |  | _Updated |  |      2      |
  
#Author : Syahda Afia Dhiya Ulhaq Tajudin
#Date	: 01/05/2023
#Description : Testing GoGrids update journal feature
@SmokeScenario
Feature: update journal on dashboard

	@SmokeTestSyahda2
	Scenario Outline: Check update journal is successful
		Given Browser is open
		And User is on dashboard
		When User click journal "<journalName>" on dashboard
		And User update journal "<question>"
		And User update "<answer>"
		And User click simpan button
		Then Page show journal updated notification
		
		Examples: 
      | journalName |  | question |  |   answer  | 
      |    Mood     |  | Updated_ |  |           | 
      |   Weather   |  |          |  | _Updated  |
      |    Goals    |  | Updated_ |  | _Updated  |
  
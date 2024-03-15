@leads
Feature: lead functionality
  Scenario: create multiple leads
    Given user should be on login page
    When User enter valid user ID and Valid Password
    And Click on login button
    And Create multiple lead with firstname as "<fname>" and last name as "<Lname>" and company name as "<Company>"
    |fname|Lname|Company|
    |Tushar| jadhav| Tjadhav|
    |Yogesh|Janrao |Yjanrao |
    |Sandesh| Khajekar| Skhajekar |

    And Logout and close the browser
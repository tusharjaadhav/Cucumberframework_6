 @Iphone
Feature: Login page validation
  Background:
      Given user should be on login page

    Scenario: Valid_login_TC001
    When User enter valid user ID and Valid Password
    And  Click on login button
    Then  User should be navigate to home page
    And  Logout link should appear on home page

      @tushar
        Scenario: invalid_login_TC002
            When user enter invalid credentials
            Then User can see error message

            Scenario: verify logo on login page
              And user can validate logo on login page

              @negetive
              Scenario Outline: multiple_invalid_loginTc003
                When user enter invalid user id as "<username>" and invalid password as "<password>"
                And  Click on login button
                Then  User can see error message
                Examples:
               |Tcname |username| |password|
               |Tc01 |admin1  | |admin1  |
                |Tc02|admin2  | |admin2  |
                |Tc03|admin3  | |admin3  |
                |Tc04|Rahul   |  |Gandhi |
@Regression
Feature: Login functionality
  User Story :
  As a user, I should be able to log in so that I can land on homepage.
  We have 5 types of users but will test only 2 user (PosManager, SalesManager)


  Scenario: Positive login scenario (Users can log in with valid credentials)
    Given user is on the login page
    When user enters valid username "salesmanager10@info.com"
    And user enters valid password "salesmanager"
    And user clicks the login button
    Then user should be on the homepage


  Scenario Outline: Positive login scenario (Users can log in with valid credentials)
    Given user is on the login page
    When user enters valid username "<validUsername>"
    And user enters valid password "<validPassword>"
    And user clicks the login button
    Then user should be on the homepage

    Examples: Valid username and valid password
      |      validUsername              |   validPassword    |
      | salesmanager10@info.com         |   salesmanager     |
      | salesmanager15@info.com         |   salesmanager     |
      | salesmanager105@info.com        |   salesmanager     |
      | posmanager10@info.com           |   posmanager       |
      | posmanager15@info.com           |   posmanager       |
      | posmanager155@info.com          |   posmanager       |


  Scenario: Negative login scenario ("Wrong login/password" message should be displayed for valid username-invalid password)
    Given user is on the login page
    When user enters valid username "salesmanager6@info.com"
    And user enters invalid password "manager"
    And user clicks the login button
    Then user should see Wrong login/password message


  Scenario Outline: Negative login scenario ("Wrong login/password" message should be displayed for valid username-invalid password)
    Given user is on the login page
    When user enters valid username "<validUsername>"
    And user enters invalid password "<invalidPassword>"
    And user clicks the login button
    Then user should see Wrong login/password message

    Examples: Valid username and invalid password
      |     validUsername                     | invalidPassword        |
      |  salesmanager105@info.com             |   manager              |
      |  salesmanager15@info.com              |   manager              |
      |  salesmanager25@info.com              |   manager              |
      |  posmanager5@info.com                 |   manager              |
      |  posmanager105@info.com               |   manager              |
      |  posmanager45@info.com                |   manager              |


  Scenario: Negative login scenario ("Wrong login/password" message should be displayed for invalid username-valid password)
    Given user is on the login page
    When user enters invalid username "salesmanager4@info.com"
    And user enters valid password "salesmanager"
    And user clicks the login button
    Then user should see Wrong login/password message


  Scenario Outline: Negative login scenario ("Wrong login/password" message should be displayed for invalid username-valid password)
    Given user is on the login page
    When user enters invalid username "<invalidUsername>"
    And user enters valid password "<validPassword>"
    And user clicks the login button
    Then user should see Wrong login/password message

    Examples: Invalid username and valid password
      |    invalidUsername                    |     validPassword         |
      |   salesmanager4@info.com              |     salesmanager          |
      |   salesmanager3@info.com              |     salesmanager          |
      |   salesmanager2@info.com              |     salesmanager          |
      |   posmanager1@info.com                |     posmanager          |
      |   posmanager2@info.com                |     posmanager          |
      |   posmanager3@info.com                |     posmanager          |


    Scenario: "Please fill out this field" message should be displayed if the password or username is empty
      Given user is on the login page
      When username input box is empty
      And user enters password "salesmanager" in the password input box
      And user clicks the login button
      Then user should see Please fill out this field message
      When user is on the login page
      And user enters username "salesmanager5@info.com" in username input box
      And leaves password input box is empty
      Then user clicks login button
      Then user should see Please fill out this field message for empty password


      Scenario: User should see the password in bullet signs by default while typing (like ****)
        Given user is on the login page
        And user types password "salesmanager" into the password input box
        Then user should see bullet signs by default


        Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
          Given user is on the login page
          And user enters username "salesmanager55@info.com" and password "salesmanager"
          Then user press Enter from keyboard
          And user should be landed on the homepage


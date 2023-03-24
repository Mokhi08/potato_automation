@wip
Feature: Log out functionality
  User Story:
  As a user, I should be able to log out.

  Scenario: User can log out and ends up in login page
    Given user is on the login page
    When user enters valid username "salesmanager10@info.com"
    And user enters valid password "salesmanager"
    And user clicks the login button
    And user should be on the homepage
    And user should click on the account name
    And user should click the log out button
    Then user should be returned to login page

    Scenario: User cannot go to the home page again by clicking the step back button
    after successfully logged out
      Given user is on the login page
      When user enters valid username "salesmanager10@info.com"
      And user enters valid password "salesmanager"
      And user clicks the login button
      And user should be on the homepage
      And user should click on the account name
      And user should click the log out button
      And user should be returned to login page
      And user clicks the step back button
      Then user should not go to homepage again


      Scenario: User must be logged out if the user closes the open tab
      (all tabs if there are multiple open tabs)
        Given user is on the login page
        When user enters valid username "salesmanager10@info.com"
        And user enters valid password "salesmanager"
        And user clicks the login button
        And user should be on the homepage
        And user closes all the open tabs
        And user opens a new tab and goes to the login page
        Then user should not see the account name on top right corner



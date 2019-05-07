Feature: LoginFeature
  This deals with logging in

  Scenario: Log in with correct username

    Given I navigate to the login page
    And I enter the following login details:
      | username | password |
      | cukey    | passwoid |
    And I click the login button
    Then I should land on the newest page

  Scenario: Log in with correct username part 2

    Given I navigate to the login page
    And I enter the following login details:
      | username | password |
      | cukey    | passwoid |
    And I click the login button
    Then I should land on the newest page by other measure

  Scenario: Log in with correct username to fail

    Given I navigate to the login page
    And I enter the following login details:
      | username | password |
      | cukey    | passwoid |
    And I click the login button
    Then I should land on the newest page wrongly


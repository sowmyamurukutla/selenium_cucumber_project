@flipKart @Login
Feature: Login to flipkart and verify title

  @successLogin
  Scenario: Verify successful login to flipKart
    Given I login to flipKart application with user details
    Then I verify user name is displayed as "Sowmya"

  @invalidUserNameLogin
  Scenario: Verify error message with invalid user name on login to flipKart
    Given I login to flipKart application with invalid user details
      | userName     | password  |
      | 958101904990 | Sowmya@12 |
    Then I verify login error message is displayed as "Please enter valid Email ID/Mobile number"

  @invalidPasswordLogin
  Scenario: Verify error message with invalid password on login to flipKart
    Given I login to flipKart application with invalid user details
      | userName   | password  |
      | 9581019049 | Sowmya@02 |
    Then I verify login error message is displayed as "Your username or password is incorrect"

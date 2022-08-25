@flipKart @Login
Feature: Login to flipkart and verify title

  # this is revali code before sowmya code is merged
  @successLogin
  Scenario: Verify successful login to flipKart
    Given I login to flipKart application with user details
    Then I verify user name is displayed as "Sowmya"

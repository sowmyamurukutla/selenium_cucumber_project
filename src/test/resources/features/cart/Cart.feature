@flipKart @Login
Feature: Login to flipkart and verify title

# Sowmya developed this code and successfullly merged to master
  @successLogin
  Scenario: Verify successful login to flipKart
    Given I login to flipKart application with user details
    Then I verify user name is displayed as "Sowmya"

  @successLogin
  Scenario: Verify successful login to flipKart
    Given I login to flipKart application with user details
    Then I verify user name is displayed as "Sowmya"

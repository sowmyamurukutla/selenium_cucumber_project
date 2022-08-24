@flipKart @title
Feature: Verify Title of flipkart

  @titleAfterLogin
  Scenario: Verify title after successful login to flipKart
    Given I login to flipKart application with user details
    Then I verify the title of flipKart application is "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"

  @titleBeforeLogin
  Scenario: Verify title before login to flipKart
    Given I open the flipKart application
    Then I verify the title of flipKart application is "Online opping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"

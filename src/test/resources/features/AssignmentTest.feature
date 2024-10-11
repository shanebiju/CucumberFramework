Feature: verify assignment test cases for saucedemo
  Background:
    Given user open website
    Then verify user is on login page
    When user login username "standard_user" and password "secret_sauce"
    Then verify user is on home page

  Scenario:
    When user selects Name (Z to A)
    Then verify products are sorted by Z to A

  Scenario:
    When user selects Price (high to low)
    Then verify products are sorted in descending order of price

  Scenario:
    When user adds all items into cart
    Then verify cart icon displays total count of items on cart
    When user click on cart icon
    Then verify user is on cart page
    And verify items on cart page is same as item you added in cart

  Scenario:
    When user adds all items into cart
    Then verify cart icon displays total count of items on cart
    When user click on cart icon
    Then verify user is on cart page
    Then verify items on cart page is same as item you added in cart
    When user click on checkout button
    Then verify user is on checkout page
    When user fill all checkout details
    And click on Continue button
    Then verify user is on review page
    Then verify all items on cart is present in review page
    And verify total price displayed on review page is correct

  Scenario:
    When user adds all items into cart
    Then verify cart icon displays total count of items on cart
    When user click on cart icon
    Then verify user is on cart page
    Then verify items on cart page is same as item you added in cart
    When user click on checkout button
    Then verify user is on checkout page
    When user fill all checkout details
    And click on Continue button
    Then verify user is on review page
    Then verify all items on cart is present in review page
    And verify total price displayed on review page is correct
    When user click on Finish button
    Then verify user is on order confirmation page
    When user clicks back home button
    Then verify user is on home page
    And verify remove button is not displayed

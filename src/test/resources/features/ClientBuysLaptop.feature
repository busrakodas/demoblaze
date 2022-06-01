Feature: Buying laptop

  @Buying_laptop
Scenario: Buying laptop
    When user navigates to the home page
    And user clicks on Laptops button
    And user clicks on Sony vaio i5
    Then user clicks on Add to cart button
    Then user need to accept pop up confirmation
    Then user clicks on Laptops button
    And user clicks on Dell i7 8gb
    And user clicks on Add to cart button
    Then user need to accept pop up confirmation
    And user navigates to cart page
    And user delete Dell i7 8gb
    And user clicks on place order button
    Then user fill in all web form fields
    And user clicks on purchase button
    Then user captures purchase id and amount
    Then user asserts purchase amount equals expected
    Then user clicks on ok button
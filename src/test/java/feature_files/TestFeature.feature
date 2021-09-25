Feature: Test Feature

  Scenario: Buy Product

    Given I navigate to Gigatron
    And I accept cookies
    When I search for a product "Laptop"
    And I filter products by spec title "Kategorije" and filter "Laptop računari"
    And I click on product index "0"
    And I add product to cart
    Then I verify that item is added to the cart

  Scenario: Contact

    Given I navigate to Gigatron
    And I accept cookies
    And I navigate to contact page
    And I fill in contact form details


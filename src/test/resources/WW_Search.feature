#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Test Search and Wishlist feature

  @tag1
  Scenario: Verify WestwingNow search and wishlist functionality working
    Given I am on the WestwingNow home page "https://www.westwingnow.de"
    When I search for "möbel"
    Then I should see product listing page with a list of products
    When I click on wishlist icon of the first found product
    Then I should see the login/registration overlay
    When I switch to login form of the overlay
    And I log in with " your_test_account_data (see the note below)"  credentials
    Then the product should be added to the wishlist (wishlist icon on the product is filled in and wishlist counter in the website header shows 1,  screenshot )
  #  And I go to the wishlist page "https://www.westwingnow.de/customer/wishlist/index/"
    And I delete the product from my wishlist

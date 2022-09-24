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
Feature: OnlineShopping
  

  @tag1
  Scenario: Shopping
    Given Open the browser and enter the url
    When Register on the website and Click Signin on the landing page
    And Create Account by entering email address 
    And Enter details on the Your Personal Information
    And Validate on the landing screen - correct name and surname is displayed
    And Logout and login again
    And Add a product to the cart
    And Proceed to the checkout page and continue till payments
    Then Validate on the payments page if the product details are correct
    
  


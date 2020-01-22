
Feature: Search the google page
  This feature is used to search google page with keywords


  Scenario: Search with given search string
    Given I navigate to google page
    When I enter the search string as "Test Automation"
    And I click search button
    Then I should see search list
    
  Scenario: Search with given multiple search strings
    Given I navigate to google page
    When I enter the following search strings
    |SearchStrings|
    |Test Automation|
    |Selenium|
    |Cucumber|
    And I click search button
    Then I should see search list 
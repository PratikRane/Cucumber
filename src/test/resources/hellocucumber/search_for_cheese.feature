@smoke
Feature: Title on Google search results page
  This feature is to make sure that the title of the search results page
  has the title reflecting the item searched

  Scenario: Finding some cheese online
    Given I am on google search page
    When I search for "Cheese"
    Then the page title should start with "Cheese"

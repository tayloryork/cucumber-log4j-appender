Feature: Calculator Feature
  Background: Make a new calculator
    Given I have a new calculator

  Scenario: The Calculator can add
    When I add 2 and 2
    Then I should have 4

  Scenario: The calculator throws a cannot divide by zero exception
    When I divide 2 by 0
    Then I should get an exception

@tag
Feature: Grid filter row server side data
  I want to use this template for my feature file
  
  Background:
  Given I landed in Demo Aspnet Awesome Page

  @tag2
  Scenario Outline: Retrieve Purchase Order
    Given I navigated to menu <menuName>
    When I search for name <firstName>
    Then I should print out all the columns

    Examples: 
      | menuName      			  | firstName  |
      | FilterRow server data | Miguel     |

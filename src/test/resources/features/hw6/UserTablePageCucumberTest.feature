Feature: User Table Page Test

  Scenario: User Table Interface Test
    Given I'm on the Home Page
    And I login as user 'Piter Chailovskii'
    When I click on 'Service' button in Header
    And I click on User Table button in Service dropdown
    Then 'User Table' page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page
    And User table contains following values: 1, Roman, Wolverine
    And User table contains following values: 2, Sergey Ivan, Spider Man
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to (.+)' text in log section'
    When I click on dropdown in column Type for user Roman
    Then droplist contains values Admin
    Then droplist contains values User
    Then droplist contains values Manager






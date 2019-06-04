Feature: Service Page Test

  Scenario: Service Page Interface Test
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




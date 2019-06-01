Feature: Service Page Test

  Scenario: Service Page Interface Test
    Given I'm on the Home Page
    When I login as user epam with password 1234
    Then Name for loggined user is displayed
    When I click Service menu item
    When I click Different Elements menu item
    Then Four checkboxes are displayed
    Then Four radiobuttons are displayed
    Then One dropdown list is displayed
    Then Two buttons are displayed
    Then Left section is displayed
    Then Right section is displayed
    When I click Water checkbox
    When I click Wind checkbox
    Then Logs for checked checkboxes are displayed in log section
    When I click radiobutton Selen
    Then Log for select radiobutton is displayed in log section
    When I click Yellow color from dropdown menu
    Then Yellow color is selected in dropdown list
    Then Log for dropdown list is displayed in log section
    When I unclick Water checkbox
    When I unclick Wind checkbox
    Then Logs for unclicked checkboxes are displayed



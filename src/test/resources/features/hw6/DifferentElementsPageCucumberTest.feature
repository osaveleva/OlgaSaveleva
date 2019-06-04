Feature: Different Elements Page Test

  Scenario: Different Elements Interface Test
    Given I'm on the Home Page
    And I login as user 'Piter Chailovskii'
    When I click on 'Service' button in Header
    When I click Different Elements submenu item
    Then Four checkboxes are displayed
    Then Four radiobuttons are displayed
    Then One dropdown list is displayed
    Then Two buttons are displayed
    Then Left section is displayed
    Then Right section is displayed
    When I click Water checkbox
    When I click Wind checkbox
    Then Log for Water element with true status is displayed in log section
    Then Log for Wind element with true status is displayed in log section
    When I click radiobutton Selen
    Then Log for Selen radiobutton is displayed in log section
    When I click Yellow color from dropdown menu
    Then Yellow color is selected in dropdown list
    Then Log for Yellow color in dropdown list is displayed in log section
    When I unclick Water checkbox
    When I unclick Wind checkbox
    Then Log for Water element with false status is displayed in log section
    Then Log for Wind element with false status is displayed in log section




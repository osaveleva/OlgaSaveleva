Feature: Different Elements Page Test

  Scenario: Different Elements Interface Test
    Given I'm on the Home Page
    # TODO This step should be parametrised by User
    And Login as "PETER_CHAILOVSKII"
    # TODO Parameter required
    When I click on "SERVICE" button in Header
    When I click on "DIFFERENT_ELEMENTS" button in submenu
  # !TODO
    Then Four checkboxes are displayed
    Then Four radiobuttons are displayed
    Then One dropdown list is displayed
    Then Two buttons are displayed
    Then Left section is displayed
    Then Right section is displayed
  # TODO Should be List<Enum>
    When I select nature elements below:
      | WATER |
      | WIND  |
  # !TODO
    Then Log for Water element with true status is displayed in log section
    Then Log for Wind element with true status is displayed in log section
    When I click radiobutton Selen
    Then Log for Selen radiobutton is displayed in log section
    When I click Yellow color from dropdown menu
    Then Yellow color is selected in dropdown list
    Then Log for Yellow color in dropdown list is displayed in log section
    When I unclick nature elements below:
      | WATER |
      | WIND  |
    Then Log for Water element with false status is displayed in log section
    Then Log for Wind element with false status is displayed in log section




Feature: User Table Page Test

  Scenario: Different Elements Interface Test
    Given I'm on the Home Page
    # TODO This step should be parametrised by User
    #Still actual question how to pass Enum as argument
    And Login as "PETER CHAILOVSKII"
    # TODO Parameter required
    When I click on "SERVICE" button in Header
    When I click on "USER_TABLE" button in submenu
    # TODO Should be parametrised
    Then 'User Table' page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |

  #  # TODO Should be parametrised
    When I select Vip checkbox for Sergey Ivan
    Then 1 log row has 'Vip: condition changed to true text in log section'
  #  When I click on dropdown in column Type for user Roman
  #  Then droplist contains values Admin
  #  Then droplist contains values User
  #  Then droplist contains values Manager






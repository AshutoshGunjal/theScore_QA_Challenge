Feature: Team Selection
  Scenario Outline: Verify league selection process
    Given User is at home screen
    When User goes to league selection page
    And League selection page gets opened
    Then User should be able to select the "<leagues>"
    When User goes to team selection page
    Then Team selection page gets opened
    When User clicks on alerts settings page
    And Alert settings page gates opened
    Then User continues from alert settings page
    Examples:
      |  leagues        |
      | NHL,NFL,MLB,NBA |

  Scenario Outline: Verify team selection process
    Given User is at home screen
    When User goes to league selection page
    And League selection page gets opened
    Then User should be able to select the "<leagues>"
    When User goes to team selection page
    Then Team selection page gets opened
    When User selects the tab "<league>"
    And User should be able to select teams "<teams>" for "<league>"
    Then User should be able to see the selected league "<league>" and teams "<teams>"
    And  User continues from alert settings page
    And User should be on notifications page
    Then Selects the choice for notifications
    Then User must land on a dashboard page
    And User should be able to see the selected teams "<teams>"
    Examples:
      | league | teams          |
      | NHL    | BOS,BUF        |
      | NFL    | BUF,MIA        |
      | NHL    | MTL,OTT        |
      | MLB    | BAL,BOS,NYY,TOR|

  Scenario: Verify back navigation functionality
    Given User is at home screen
    When User goes to league selection page
    And User goes to team selection page
    When User navigates back to league selection
    And League selection page gets opened
    When User navigates back to home screen
    Then User is at home screen
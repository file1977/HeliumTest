Feature: Login and logout

  Scenario: Open the home page
    Given home page is open

  Scenario Outline: Login with email and password
    When Login with email "<email>" and password "<password>"
    Then Current page is user home page
    When User logout
    Then Current page is guest home page

    Examples:
      | email           | password |
      | test008@abc.com | 123123   |
      | test012@abc.com | 123123   |
      | test009@abc.com | 123qwe   |

  Scenario: Quit
    Then Close the browser

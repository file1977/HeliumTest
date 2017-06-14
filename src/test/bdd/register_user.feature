Feature: Register new users

  Scenario: Open the home page and navigate to register page
    Given home page is open
    And Click signup button

#
# Validate fields in register page
#
  Scenario Outline: Register fields check
    When Set email as "<email>", password as "<password>" and confirmed password as "<confirmedPassword>"
    Then Email box status is: <emailStatus>
    Then Password box status is: <passwordStatus>
    Then Confirmed password box status is: <confirmPwdStatus>
    Then Register button is <regButtonStatus>

    Examples:
      | email           | password    | confirmedPassword | emailStatus  | passwordStatus | confirmPwdStatus  | regButtonStatus |
      | test002@abc.com | 123123      | 123123            | valid        | valid          | valid             | enabled         |
      | test002         |             | 12                | pattern_err  | required_err   | length_err        | disabled        |
      |                 | ab          |                   | required_err | length_err     | required_err      | disabled        |
      | test002@abc.com | 123qwe      | 123123            | valid        | valid          | valid             | disabled        |


  Scenario: Open the home page
    Given home page is open

#
# Register new users
#    We need to update the email every time to ensure not registered.
#    In real case, we can generate a new email automatically or call API to delete the registered user.
#
  Scenario Outline: Register new users
    Given Click signup button
    When Create a new user with email "<email>" and password "<password>"
    Then Current page is new user home page
    When User logout
    Then Current page is guest home page

    Examples:
      | email           | password |
      | test028@abc.com | 123123   |
      | test035@abc.com | 123123   |
      | test036@abc.com | !@#$%^qw |

  Scenario: Quit
    Then Close the browser

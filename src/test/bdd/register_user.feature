Feature: Register new users

  Scenario: Login with phone number and password
    Given home page is open
    And Click signup button

#  Scenario Outline: Register fields check
#    When Set email as "<email>", password as "<password>" and confirmed password as "<confirmedPassword>"
#    Then Email box status is: <emailStatus>
#    Then Password box status is: <passwordStatus>
#    Then Confirmed password box status is: <confirmPwdStatus>
#    Then Register button is <regButtonStatus>
#
#    Examples:
#      | email           | password    | confirmedPassword | emailStatus  | passwordStatus | confirmPwdStatus  | regButtonStatus |
#      | test002@abc.com | 123123      | 123123            | valid        | valid          | valid             | enabled         |
#      | test002         |             | 12                | pattern_err  | required_err   | length_err        | disabled        |
#      |                 | ab          |                   | required_err | length_err     | required_err      | disabled        |
#      | test002@abc.com | 123qwe      | 123123            | valid        | valid          | valid             | disabled        |
#

  Scenario Outline: Register new users
    Given home page is open
    And Click signup button
    When Create a new user with email "<email>" and password "<password>"
    Then Current page is new user home page
    When User logout
    Then Current page is guest home page

    Examples:
      | email           | password |
      | test008@abc.com | 123123   |
      | test009@abc.com | 123qwe   |

#  Scenario: Quit
#    Then Close the browser

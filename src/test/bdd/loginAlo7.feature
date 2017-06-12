Feature: Login to Alo7

  Scenario: Login with phone number and password
    Given login page is open
    When Login with phone number "13817900456" and password "123123"
    Then Teacher name "文大头" displays on status bar
    Then Close the browser

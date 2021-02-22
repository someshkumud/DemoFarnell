Feature: QA Task Feature
#  This feature deals with the assigned QA Task on the Farnell application

  Scenario Outline: Perform Scenario - <ScenarioID> : <ScenarioDescription>
    Given Launch browser and navigate to Farnell
    And Navigate to registration page
    And Set "username" as "<username>"
    And Set "password" as "<password>"
    And Set "fullName" as "<fullName>"
    And Set "email" as "<email>"
    And Set "rememberMe" as "<rememberMe>"
    When Register user
    Then Login name displayed as ""
    Examples:
      | ScenarioID | ScenarioDescription                      | username   | password      | fullName     | email         | rememberMe |
      | SC01       | Register user with Remember Me Option    | testuser11 | Password@1234 | TestUser One | test@user.one | On         |
      | SC02       | Register user without Remember Me Option | testuser12 | Password@1234 | TestUser Two | test@user.one | Off        |





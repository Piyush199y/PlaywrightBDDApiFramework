Feature: Naukri profile update

  @naukri
  Scenario: Update the Naukri profile
    Given User lands on home page after login to "NaukariUrl"
    When User update the profile
    And Upload a new resume
    Then The profile should get updated
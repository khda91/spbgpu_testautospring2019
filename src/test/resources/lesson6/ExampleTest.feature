Feature: Test Feature

  Scenario: Create tag
    Given I open Mantis Login page
    And I login as 'administrator' with password 'root'
    And I navigate to 'Manage' page
    And I click to 'Manage Tags' tab
#    When I enter name 'Test tag' for tag
#    And I add tag description 'Desc'
#    And I click 'Create Tag' button
#    Then Created tag should be displayed on the Manage Tag page

  Scenario: AT
    Given I open Mantis Login page
    And I login as 'api_user' with password 'api'
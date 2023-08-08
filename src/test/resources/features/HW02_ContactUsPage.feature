Feature: Contact Us Page

  Scenario: Open Contact Us Page
    When Click on Contact Us button in header
    Then Verify Contact Us page is displayed

  Scenario: Verify error message at Mandatory fields
    When Click Send Message button
    Then Verify error message at mandatory fields

#  Scenario Outline: Verify error message at Email field
#    Given User enters valid data into FirstName and LastName
#    And User enters invalid <email> into Email field
#    And User enters valid data into Subjects field
#    Then Verify error message at Email field
#
#    Examples:
#      | email         |
#      | testing       |
#      | testing@gmail |
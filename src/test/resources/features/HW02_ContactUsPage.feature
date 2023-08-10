Feature: Contact Us Page

  Scenario: Open Contact Us Page
    When Click on Contact Us button in header
    Then Verify Contact Us page is displayed

  Scenario: Verify error message at Mandatory fields
    When Click Send Message button
    Then Verify error message at mandatory fields

  Scenario Outline: User fill data into contact form
    Given User fill the form from given sheetName "<SheetName>" and rowNumber <RowNumber>

    Examples:
      | SheetName | RowNumber |
      | contactUs | 0         |
      | contactUs | 1         |
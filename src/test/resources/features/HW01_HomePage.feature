Feature: Home Page

  Scenario: User navigation to Home Page
    When Click on HayWorkGlobal logo
    Then Home page is loaded success


  Scenario: User clicks on Request A Demo
    When Click on Request A Demo button
    Then Verify Contact Us page is displayed


  Scenario: User clicks on Get Started Now
    Given User is navigate back to Home Page
    When Click on Get Started Now button
    Then Verify Contact Us page is displayed

  Scenario: Verify footer is displayed correct
    Given User is navigate back to Home Page
    When Scroll to footer of page
    Then Verify HayWorkGlobal logo is displayed
    And LinkedIn icon is displayed
    And Facebook icon is displayed
    And Twitter icon is displayed
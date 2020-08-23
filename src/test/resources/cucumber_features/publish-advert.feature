Feature: publish advert
  Scenario:
    Given user navigates to kolesa home page
    When open signInPage
    And sign in
    And customize advert
    And return on home page
    And open account page
    And open draft page
    And publish advert from customization
    And open account page
    Then advert is posted
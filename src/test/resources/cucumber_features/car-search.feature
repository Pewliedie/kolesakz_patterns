Feature: car search

  Background:
    Given user navigates to kolesa home page
    When open auto section

  Scenario Outline: user searches for a car by random parameters
    When configure random search "<location>","<priceFrom>","<priceTo>","<mark>","<model>"
    And click show results
    And open random found result
    Then random parameters matches with result "<location>","<priceFrom>","<priceTo>","<mark>","<model>"
    Examples:
      | location  | priceFrom | priceTo    | mark          | model |
      | Алматы    | 5 000 000 | 8 000 000  | toyota        | camry |
      | Караганда | 2 000 000 | 10 000 000 | mercedes-benz | e-280 |

  Scenario: user searches for a car with photo parameter
    When configure search with photo
    And click show results
    And open found result
    Then photo is displayed


  Scenario: user searches for a car using advanced search parameters
    When configure search with advanced parameters
    And click show results
    And open found result
    Then advanced parameters matches with result


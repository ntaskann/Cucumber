@scenario_outline_1
Feature: arama_feature_2

  Background: googlea_git
    Given kullanici google gider

  Scenario Outline: arama_testi
    When kullanici "<product>" için arama yapar
    Then sonuclarda "<product>" oldugunu dogrular
    Then close the application

    Examples: data
      | product |
      | iphone  |
      | tesla   |
      | tv      |
      | flower  |
      | cat     |
      | dog     |


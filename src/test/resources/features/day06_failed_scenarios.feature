@failed_scenario
Feature: hooks_test

  Background: googlea_git
    Given kullanici google gider

  Scenario: TC01_google_iphone_arama
    When kullanici "iphone" için arama yapar
    Then sonuclarda "samsung" oldugunu dogrular
    Then close the application


  Scenario: TC02_google_tesla_arama
    When kullanici "tesla" için arama yapar
    Then sonuclarda "mazda" oldugunu dogrular
    Then close the application
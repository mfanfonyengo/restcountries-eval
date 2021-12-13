Feature: Testing restcountries REST API code endpoint
  Users should be able to submit valid GET requests by country code to the API and receive information like capital city and etc

  Scenario: Data Upload to a web service
    When users upload data on a project
    Then the server should handle it and return a success status

  Scenario: Data retrieval from a web service
    When users want to get information on the 'Cucumber' project
    Then the requested data is returned
Feature: Testing restcountries REST API name endpoint
  Users should be able to submit valid GET requests by name to the API and receive information like capital city and etc

  Scenario Outline: Data Upload to a web service
    Given User sets the base API request "<URL>"
    When users sends a GET request to "<path>"
    Then the server should handle it and return a response status <code>
    Examples:
    |URL                              |path            |code    |
    |https://restcountries.com/v3.1   |/name/peru      |200     |
    |https://restcountries.com/v3.1   |/name/peru      |200     |
    |https://restcountries.com/v3.1   |/name/peru      |200     |

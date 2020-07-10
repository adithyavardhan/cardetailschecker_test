Feature: Car details validation tests

  Scenario: Verify car details

    Given a file exists with name "car_input.txt"
    When the data is read from the file and saved as input data
    And a file exists with name "car_output.txt"
    When the data is read from the file and saved as expected data
    And open the "https://cartaxcheck.co.uk/" site
    And fill the car numbers and read the data
    Then the compare the car details with output data

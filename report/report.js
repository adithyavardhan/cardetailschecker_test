$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("regression/cardetailstests.feature");
formatter.feature({
  "line": 1,
  "name": "Car details validation tests",
  "description": "",
  "id": "car-details-validation-tests",
  "keyword": "Feature"
});
formatter.before({
  "duration": 14595051965,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Verify car details",
  "description": "",
  "id": "car-details-validation-tests;verify-car-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a file exists with name \"car_input.txt\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the data is read from the file and saved as input data",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a file exists with name \"car_output.txt\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the data is read from the file and saved as expected data",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "open the \"https://cartaxcheck.co.uk/\" site",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "fill the car numbers and read the data",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the compare the car details with output data",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "car_input.txt",
      "offset": 25
    }
  ],
  "location": "MyStepdefs.inInputFileExistsWithName(String)"
});
formatter.result({
  "duration": 339504224,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.theDataIsReadFromTheFileAndSavedAsInputData()"
});
formatter.result({
  "duration": 17727997,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "car_output.txt",
      "offset": 25
    }
  ],
  "location": "MyStepdefs.inInputFileExistsWithName(String)"
});
formatter.result({
  "duration": 123259,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.theDataIsReadFromTheFileAndSavedAsExpectedData()"
});
formatter.result({
  "duration": 5574494,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://cartaxcheck.co.uk/",
      "offset": 10
    }
  ],
  "location": "MyStepdefs.openTheSite(String)"
});
formatter.result({
  "duration": 7702795323,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.fill_the_car_numbers_and_read_the_data()"
});
formatter.result({
  "duration": 5293872812,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.theCompareTheCarDetailsWithOutputData()"
});
formatter.result({
  "duration": 204358,
  "status": "passed"
});
formatter.after({
  "duration": 506546170,
  "status": "passed"
});
});
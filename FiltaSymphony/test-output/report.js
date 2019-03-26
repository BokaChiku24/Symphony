$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Framework/FiltaSymphony/src/test/resources/feature/LoginPage.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Symphony Login Page Check",
  "description": "",
  "id": "symphony-login-page-check",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4936458700,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Symphony Login Page Check",
  "description": "",
  "id": "symphony-login-page-check;symphony-login-page-check",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "user is on symphony page",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "check language drop down",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "check login page url",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.user_is_on_symphony_page()"
});
formatter.result({
  "duration": 13954826000,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinition.check_language_drop_down()"
});
formatter.result({
  "duration": 288575700,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinition.check_login_page_url()"
});
formatter.result({
  "duration": 37500,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.close_the_browser()"
});
formatter.result({
  "duration": 2110105300,
  "status": "passed"
});
formatter.after({
  "duration": 283100,
  "status": "passed"
});
formatter.write("Test string to output in reports.");
formatter.after({
  "duration": 26731000,
  "status": "passed"
});
});
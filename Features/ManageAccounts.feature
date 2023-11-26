
Feature: Manage accounts
  
Scenario: Admin deletes a cutstomer
    Given that admin logged in
    And he enters the email "baraahamdallah@gmail.com"
    Then the customer will be deleted

Scenario: Admin deletes installer
    Given that admin logged in
    And he enters the email "leema@gmail.com"
    Then the installer will be deleted
  
Scenario: Admin adds installer
    Given that admin logged in
    And he enters the email "installer@gmail.com"
    And the password "pass"
    And the name "name"
    And the phone "051783297"
    And the address "address"
    Then the installer will be added
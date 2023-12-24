
Feature: Manage accounts
  
Scenario: Admin deletes a cutstomer
    Given that admin logged in
    And he enters the email "baraahamdallah@gmail.com"
    Then the customer will be deleted
    
    Scenario: Admin tries to delete customer using wrong email
    Given that admin logged in
    And he enters the email "baraa@gmail.com"
    Then the customer will not be found and deleted

Scenario: Admin deletes installer
    Given that admin logged in
    And he enters the email "leema@gmail.com"
    Then the installer will be deleted
  
  Scenario: Admin tries to delete installer using wrong email 
    Given that admin logged in
    And he enters the email "le@gmail.com"
    Then the installer will not be found and deleted
  
Scenario: Admin adds installer
    Given that admin logged in
    And he enters the email "installer@gmail.com"
    And the password "pass"
    And the name "name"
    And the phone "051783297"
    And the address "address"
    Then the installer will be added
    
Scenario: Admin tries to add installer who is already added to the list
    Given that admin logged in
    And he enters the email "dana@gmail.com"
    And the password "5452"
    And the name "dana"
    And the phone "058567424"
    And the address "nablus"
    Then the installer will not be added   
    
 Scenario: Admin views the customer accounts
    Given that admin logged in and he wants to see customers information
    Then the customer information will be printed
    
Scenario: Admin views the installer accounts
    Given that admin logged in and he wants to see installers information
    Then the installer information will be printed
    
Scenario: Admin views the booked appointments
    Given that admin logged in and he wants to see the booked appointments
    Then the booked appointments will be printed    
        
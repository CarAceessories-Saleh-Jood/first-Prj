
Feature: Edit account Information
  
 
  Scenario: Customer edits his password
    Given the customer is logged in with email "baraahamdallah@gmail.com" and password "1234"
    And he enters a new password "8520"
    Then the password will be changed
    
    Scenario: Customer edits his name
    Given the customer is logged in with email "nabeel@gmail.com" and password "1234"
    And he enters a new name "newname"
    Then the name will be changed  
      
  Scenario: Customer edits his phone number
    Given the customer is logged in with email "aya@gmail.com" and password "1234"
    And he enters a new phone number "0574354798"
    Then the phone number  will be changed
   
    Scenario: Customer edits his address
    Given the customer is logged in with email "mohammadhamdallah@gmail.com" and password "1234"
    And he enters a new address "newaddress"
    Then the address  will be changed
   
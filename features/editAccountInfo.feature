
Feature: Edit account Information
  
 
  Scenario: Customer edits his password
    Given the customer is logged in with email "user2@gmail.com" and password "1234" and userType "3"
    And he enters a new password "8520"
    Then the password will be changed
    
  Scenario: Customer edits his phone number
    Given the customer is logged in with email "user3@gmail.com" and password "1234" and userType "3"
    And he enters a new phone number "0574354798"
    Then the phone number  will be changed
   
    Scenario: Customer edits his address
    Given the customer is logged in with email "user4@gmail.com" and password "1234" and userType "3"
    And he enters a new address "Nablus"
    Then the address  will be changed
   
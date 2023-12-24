Feature: Customer registration

Scenario: Successful sign up
    Given that the customer is not signed up
    And the email "new_customer@gmail.com"
    And the email matches the email format
    And the email is not registered before
    And the name is "newcustomer"
    And the password is "1234"
    And the phone number is "056785412"
    And the address is "Tulkarm"
    Then the customer will register successfully 
    
   Scenario: Users tries to sign up with email already used
    Given that the customer is not signed up
    And the email "surahamdallah@gmail.com"
    And the email matches the email format
    And the email is already registered
    And the name is "newcustomer"
    And the password is "1234"
    And the phone number is "056785412"
    And the address is "Tulkarm"
    Then the customer will not be registerd  
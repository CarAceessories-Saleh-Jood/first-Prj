Feature: user login

  Scenario: Successful log in
    Given that the user is not logged in
    And the email is "jood.hamdallah12@gmail.com"
    And the password is "1234"
    And his user choice is "1"
    Then the user login succeeds
    
   Scenario: Successful sign up
    Given that the user is not signed up
    And his user choice is "1"
    And the email is "new_user@gmail.com"
    And the email matches the email format
    And the password is "1234"
    And the phone number is "056785412"
    And the address is "Tulkarm"
    Then the user will register successfully 
    
    Scenario: Users tries to sign up with email already used
    Given that the user is not signed up
    And his user choice is "1"
    And the email is "jood.hamdallah12@gmail.com"
    And the email matches the email format
    And the password is "1234"
    And the phone number is "056785412"
    And the address is "Tulkarm"
    Then the user will not be registerd 
    
  
  Scenario: User entered a wrong email
    Given that the user is not logged in
    And the email is "not exist"
    And the password is "truePass"
    And his user choice is "1"
    Then the user will not login
    And show the message

Scenario: User entered a wrong password
    Given that the user is not logged in
    And the email is "jood.hamdallah12@gmail.com"
    And the password is "not true"
    And his user choice is "1"
    Then the user will not login
    And show the message
    
  Scenario: User logout successfully
  Given that the user is logged in with email "user1@gmail.com" and password "1234" and type "2"
  Then the user logout successfully

 
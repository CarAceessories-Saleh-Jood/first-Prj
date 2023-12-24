Feature: user login 

  Scenario: Admin logs in sucessfully
    Given that the user is not logged in
    And the email is "jood.hamdallah12@gmail.com"
    And the password is "1234"
    Then the admin login succeeds
    
  Scenario: Customer logs in sucessfully
    Given that the user is not logged in
    And the email is "surahamdallah@gmail.com"
    And the password is "1234"
    Then the customer login succeeds
    
    Scenario: Installer logs in sucessfully
    Given that the user is not logged in
    And the email is "leema@gmail.com"
    And the password is "1234"
    Then the installer login succeeds
       
  Scenario: User entered a wrong email
    Given that the user is not logged in
    And the email is "not exist"
    And the password is "truePass"
    Then the user will not login
    And show the message

 Scenario: User entered a wrong password
    Given that the user is not logged in
    And the email is "jood.hamdallah12@gmail.com"
    And the password is "not true"
    Then the user will not login
    And show the message
    
 
 
Feature: User logout

Scenario: Admin logout successfully
  Given that the admin is logged in with email "jood.hamdallah12@gmail.com" and password "1234"
  Then the admin logs out successfully
  
  
  Scenario: Customer logout successfully
  Given that the customer is logged in with email "nabeel@gmail.com" and password "1234"
  Then the customer logs out successfully
  
  Scenario: Installer logout successfully
  Given that the installer is logged in with email "leema@gmail.com" and password "1234"
  Then the installer logs out successfully
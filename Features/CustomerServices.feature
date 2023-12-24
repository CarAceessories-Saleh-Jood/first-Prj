Feature: Customer Services

 
  Scenario Outline: Successfull Purchase
    Given that customer is logged in with email "sawalha.saleh73@gmail.com"
    And he wants to buy a product with product name <name> and cost <cost>
    And the he chooses the quantity <quantity>
    Then the the product will be added to the cart
    And when he confirms to buy
    Then a confirmation email will be sent successfully
    
    Examples:   
 |name            |cost   | quantity |                                                                                                     
 | "Floor Mat "   | 299.9 | 5        |
 | "Speaker"      | 70.0  | 3        |
     
    

 Scenario Outline: Searching by name for existing products
    Given that customer is logged in with email "sawalha.saleh73@gmail.com"
    And he enters <word> to search for a product
    Then the products of this word will be found
    Examples:   
 |word      |                                                                                                    
 |"sp"      |
 |"flo"     |
 

Scenario Outline: Searching by name for non-existing products
 Given that customer is logged in with email "sawalha.saleh73@gmail.com"
 And he enters <word> to search for a product
 Then the products of this word will not be found
    Examples:   
 |word      |                                                                                                   
 |"oil"     |
 |"whe"     |
 
 Scenario: Searching by price for existing products
 Given that customer is logged in with email "sawalha.saleh73@gmail.com"
    And he enters 10.0 and 100.0 to search for a product
    Then the products of this price will be found  
   
 
 Scenario: Searching by price for non-existing products
 Given that customer is logged in with email "sawalha.saleh73@gmail.com"
  And he enters 10.0 and 50.0 to search for a product
  Then the products of this price will not be found 
   
  Scenario: View order history
    Given that customer is logged in with email "sawalha.saleh73@gmail.com" and he wants to see the order history
    Then his order history will be printed
    
    Scenario: Customer tries to see order history although he has not ordered before
    Given that customer is logged in with email "aya@gmail.com" and he wants to see the order history
    Then his order history will not found or printed
    
    Scenario: Request installation service
    Given that customer is logged in with email "sawalha.saleh73@gmail.com" and he wants to request an installation service
    And he enters the name "Saleh"
    And the phone number "0565589786"
    And the car brand "Mercedes" 
    And the car model "G-class"
    And the reason "installation of new brakes"
    And he chooses the appointment number 1 with the installer "s12028227@stu.najah.edu"
    Then installation request will be sent
    
    Scenario: View installation requests history
    Given that customer is logged in with email "sawalha.saleh73@gmail.com" and he wants to see the installation requests history
    Then his installation requests history will be printed
    
     Scenario: Customer tries to see installation requests history although ha has not booked any appointments
    Given that customer is logged in with email "aya@gmail.com" and he wants to see the installation requests history
    Then the installation request history will not be found or printed
 
 
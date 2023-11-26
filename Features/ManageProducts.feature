Feature: Product Management

 Scenario Outline: Add a new product with valid details
    Given that admin is logged in 
    And the product name is  <name>
    And product description is <description>
    And the product does not exsist before
    And product cost is <cost>
    And product cost is valid
    And product quantity is <quantity> 
    And category name is <category>
    Then the product is added to the list
    
 Examples:   
 |name            | cost  | quantity | category     | description      |
 | "Car Covers"   | 300.0 | 20       | "Exterior"   |"Protective accessories designed to shield vehicles from external elements such as dust, dirt, and weather conditions."|
 | "Amplifier"    | 70.0  | 10       | "Audio"      |"Electronic device crucial for car audio systems, intensifying the strength of audio signals to enhance sound quality" |
 | "Camera"       | 100.0 | 34       | "Electronics"| "rearview cameras for enhanced safety, dash cameras for recording journeys, and security cameras to monitor the vehicle's surroundings."   | 

Scenario: Edit product name
    Given that admin is logged in  
    And the product name is  "Head lights"
    And the new name is "Car"
    Then the product name is updated
    
Scenario: Edit product description
    Given that admin is logged in
    And the product name is  "Tail lights"
    And the new description is "Rear indicators, enhancing visibility in low-light conditions and signaling braking or turning actions to other road users for increased safety."
    Then the product description is updated
 
 Scenario: Edit product cost
    Given that admin is logged in
    And the product name is  "Tail lights"
    And the new cost is 100.0
    Then the product cost is updated
   
  Scenario: Edit product quantity
    Given that admin is logged in
    And the product name is  "Speaker"
    And the new quantity is 450
    Then the product quantity is updated
    
  Scenario: Edit product category
    Given that admin is logged in
    And the product name is  "Tail lights"
    And the new category is "Exterior"
    Then the product category is updated  
    
  Scenario: Delete a product 
    Given that admin is logged in
    And the product name is  "Battery"
    Then the product will be deleted
             
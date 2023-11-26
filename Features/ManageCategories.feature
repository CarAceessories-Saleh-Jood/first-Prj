Feature: Category Management

Scenario Outline: Admin adds a new Category with valid details
    Given that admin is logged in
    And admin enters category name  <name>  
    And category description  <description>
    Then the category is added to the list
    
 Examples:   
 |name            | description                                                                                                                | 
 | "Tires"        |    "High-performance tires  for vehicle mobility, designed in various sizes and treads to provide traction and support."   |
 | "Safety"       |  "  Measures and equipment ensuring protection and well-being, encompassing protocols, devices, and practices.    "        |
 | "Cleaning"     |   "Actions and products for the removal of dirt and impurities, maintaining hygiene and aesthetics in various contexts."   |
 
 Scenario Outline: Admin edits Category 
    Given that admin is logged in
    And admin enters category name  <name>  
    And the admins enters a new name <newname> 
    And a new description <newdescription>
    Then the category is edited
    
 Examples:   
 |name        |newname    | newdescription                                                                                       |                         
 | "Tires"    |"Wheels"   |    "Circular components supporting vehicle movement, available in diverse materials and styles."     |
 | "Safety"   |"Security" |   "Systems, measures, and protocols implemented to safeguard against potential threats or risks."   |

 Scenario Outline: Admin deletes a Category
    Given that admin is logged in
    And admin enters category name  <name> 
    Then the category and its products will be deleted from lists
    
 Examples:   
 |name            |                                                                                                         
 | "Body parts"   |      
 
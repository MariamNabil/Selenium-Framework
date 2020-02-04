Feature: Automate end to end test

  Scenario Outline: Customer make an order by purchasing an item from search 
    Given User in homepage 
    When User search for "<productname>"
    And choose to buy 2 items
    And check Cartpage and enter personal details and plce the order
    Then he can view the order aand download the invoice 
    

  
    Examples: 
      | productname | 
      | Apple MacBook Pro 13-inch |
      

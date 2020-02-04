Feature: User Registeration
  i want to check that the User can register in our E-Commerce website
  
Scenario Outline: User Registeration
Given the User in home page 
When i click on Register link
And  i entered the "<Firstname>" , "<Lastname>", "<Email>" , "<Password>" 
Then the Registeration page displayed successfully

Examples: 
  | Firstname | Lastname | Email | Password |
  | Maroooz | Nabil | marrarrro@gmail.com | 12345088 |
  | Maryoz | nagib | maryuugggiynagib@gmail.com | 12369855 |
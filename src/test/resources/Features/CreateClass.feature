@Class
Feature: Create a new student via API

        
    Scenario: Create a new class and validate the response
        When I create a new class and store its name
        And I get the class by id and the stored name
        Then I validate the information of the created class
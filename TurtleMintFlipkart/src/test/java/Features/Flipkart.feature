@Turtlemint_Flipkart
Feature: Flipkart Book search

Scenario Outline:Validate all the books present on the first page of Flipkart

Given User land on the Flipkart homepage
And Search for the <Books>
And Validate all the Books present on the first page of Flipkart

Examples:
   |Books|
   |Books|
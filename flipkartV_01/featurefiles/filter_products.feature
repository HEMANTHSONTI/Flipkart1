@tag
Feature: Ecommerce site product filtering
  I want to use this template to product filtering

  @tag1
  Scenario: Check specific products displayed
  Given I open browser with url "http://flipkart.com"
  When I enter text in search it should display items
  And I click on specific filters it should display products
  Then I should see text present in display products
  And I close the browser
  
  @tag2
  Scenario: Check specific product added to cart
  Given I open browser with url "http://flipkart.com"
  When I enter text in search it should display items
  And I click on specific filters it should display products
  And I click on add to cart it should add to cart
  And I close the browser
  
  @tag3
  Scenario: Click on Next button 
  Given I open browser with url "http://flipkart.com"
  When I enter text and apply filter it should display items
  And I click on next button
  And I close the browser
Feature: Add to Cart

Scenario: Place Order Successfully
Given User launch Chrome Browser
When User open the URL "https://rahulshettyacademy.com/seleniumPractise/#/"
And User add product "Pomegranate" into the cart
And User click on Cart icon
And User click on proceed to Checkout
And User apply promo Code
When User click on Place order button
And User select the shipping country
And User agree to the terms
Then User click on Proceed button
And User verify the order placed
#And User close the browser
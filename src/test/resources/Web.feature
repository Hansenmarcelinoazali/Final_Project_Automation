@WEB
Feature: WebAutomation

  @LoginValidUser
  Scenario: Login with two different valid accounts
    Given user is on login page
    And user clicks login button
    And user inserts valid username "hansenfinal"
    And user inserts valid password "Hm123456"
    And user click login
    Then user is directed to homepage and sees "Welcome hansenfinal"
    And user clicks logout
    Then user sees login button
    And user clicks login button
    And user inserts valid username "hansenfinal2"
    And user inserts valid password "Hm654321"
    And user click login
    Then user is directed to homepage and sees "Welcome hansenfinal2"

  @AddProducttoCart
  Scenario: Add product to cart
    Given user is on login page
    And user clicks login button
    And user inserts valid username "hansenfinal"
    And user inserts valid password "Hm123456"
    And user click login
    And user clicks product Samsung Galaxy S-six
    And user clicks button add to cart for samsung
    Then user gets popup alert "Product added." and closes popup
    And user click Cart
    Then user sees the "Samsung galaxy s6" in the cart menu
    And user click delete all

  @CalculateFinalPrice
  Scenario: Calculate final price
    Given user is on login page
    And user clicks login button
    And user inserts valid username "hansenfinal"
    And user inserts valid password "Hm123456"
    And user click login
    And user clicks product Samsung Galaxy S-six
#    # get price from S6 and save to variable
    And user clicks button add to cart for samsung
    Then user gets popup alert "Product added." and closes popup
    And user clicks Home button
    And user click menu laptop
    And user clicks Macbook Air
#    # get price from Lumia and save to variable
    And user clicks button add to cart for macbook
    Then user gets popup alert "Product added." and closes popup
    And user click Cart
    #check price in product info have same price with cart
#    And Samsung galaxy s-six and MacBook air have same price with product info
    And "Samsung galaxy s6" and "MacBook air" have same price with product info
    Then final price in cart have correct calculate
    And user click delete all


  @DeleteProductFromCart
  Scenario: Delete product from cart
    Given user is on login page
    And user clicks login button
    And user inserts valid username "hansenfinal"
    And user inserts valid password "Hm123456"
    And user click login
    And user clicks product Samsung Galaxy S-six
    And user clicks button add to cart for samsung
    Then user gets popup alert "Product added." and closes popup
    And user click Cart
    # get price to check element
    And user click delete all
    Then total price is not displayed


    @FieldValidation
    Scenario: Validation Place Holder
      Given user is on login page
      And user clicks login button
      And user inserts valid username "hansenfinal"
      And user inserts valid password "Hm123456"
      And user click login
      And user clicks product Samsung Galaxy S-six
      And user clicks button add to cart for samsung
      Then user gets popup alert "Product added." and closes popup
      And user click Cart
#      And user click Cart without chose product
      And user click place holder button
      Then popup appear
      And user input name "Hansen Marcelino Azali 123"
#      And user input country "Indonesia 123"
#      And user input city "Jakarta 123"
#      And user input credit card "nf2i934pun"
#      And user input month "98237589"
#      And user Input year "qwerty"



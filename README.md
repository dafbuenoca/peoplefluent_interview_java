Building / Execution: 

    mvn package 
      to build

    java -jar ./target/fruitstand-1.0-SNAPSHOT.jar
      to execute.

Overview:

    This application simulates a fruit stand.  Currently, the fruit stand sells a total of
    3 fruits with the following prices:

        Apple:   0.60 
        Orange:  0.25
        Bannana: 0.20

    Purchasing multiple fruits may results in a discount.  Currenly, the following
    discounts are applied (in order, so eg, the same Apple won't be applied to multiple
    discounts being taken): (price listed is the charged price)

        2 x Bannana      = 0.20 
        Bannana & Apple  = 0.20 
        2 x Apple        = 0.60
        3 x Orange       = 0.50

Sample Run of application: 

    Enter series of following to checkout items:
    Discounts:
          0.20 - [Bananna, Bananna]
          0.20 - [Apple, Bananna]
          0.60 - [Apple, Apple]
          0.50 - [Orange, Orange, Orange]

    Individual Items:
      A - Apple                 0.60
      O - Orange                0.25
      B - Bananna               0.20
      . - Done / Checkout and print total.
    All other characters are ignored so, 'Apple Orange, Apple.' is valid.

    (. to checkout) : > Apple, Apple, Bannana, Orange
    (. to checkout) : > .
    Shopping Cart: 
     Apple Apple Bananna Orange
    Price : 1.05

   Note the price is 1.05 due to Apple, Bannana (0.20) + Apple (0.60) + Orange (0.25)

Tasks:  (For consideration, code changes in a fork are nice but not required)

    1. What improvements would you make in the existing code and why?

    2. Add a new fruit, Grapefruit 'G' with a standard price of 0.50 and a discount of 
       Apple, Orange, Banana, Grapefruit to 1.25.  This discount should be the first
       discount applied. 
   
   
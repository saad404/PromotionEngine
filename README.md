# Promotion Engine


## Problem description

We need you to implement a simple promotion engine for a checkout process. Our Cart contains a list of single character SKU ids (A, B, C....) over which the promotion engine will need to run.

The promotion engine will need to calculate the total order value after applying the 2 promotion types

- buy 'n' items of a SKU for a fixed price (3 A's for 130)
- buy SKU 1 & SKU 2 for a fixed price ( C + D = 30 )

The promotion engine should be modular to allow for more promotion types to be added at a later date (e.g. a future promotion could be x% of a SKU unit price). For this coding exercise you can assume that the promotions will be mutually exclusive; in other words if one is applied the other promotions will not apply.

## Test Setup

Unit price for SKU IDs

A      50

B      30

C      20

D      15

Active Promotions

3 of A's for 130

2 of B's for 45

C & D for 30


### Scenario A

1 * A     50

1 * B     30

1 * C     20

Total     100

This scenario involves no active promotions, since there is only one instance of product A, one instance of product B,
and one instance of product C. Therefore, none of the promotions apply. 

It is simply a matter of filling the cart object with the aforementioned products and then calculate the 
final price of the entire cart.

### Scenario B

5 * A     130 + 2*50

5 * B     45 + 45 + 30

1 * C     20

Total     370

In this case, the active promotion applies to three instances of product A, two instances of product B twice, and one 
instance of product C, resulting in 370. This is done by iterating over the cart and applying the promotions to the respective
products whenever the quantity of them satisfies the condition.

### Scenario C

3 * A     130

5 * B     45 + 45 + 1 * 30

1 * C     -

1 * D     30

Total     280

Almost the same case as above, although the third promotion comes in play here. Since product C and D both appear, only 
one of them should count in the calculation of the final price, hence the total is 280.


## General information

The project was developed in IntelliJ IDEA using Java 8, the Spring Boot framework and Maven, following a TDD approach. 

In order to run the tests, make sure that you have Spring Boot and Maven installed on your system. Once that is done, go to root of the project in the terminal and execute the following command:

```
mvn clean test
```
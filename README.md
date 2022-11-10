# movie-theater
A simple movie theater demo

## Refactoring
* Defined Enums
* Defined Utils classes that implement business logics
* Refactored discount logics by the strategy pattern
* Customer extended Person class
* Used Bigdecimal to instead double for price, discount and computing logics.
* Added some new Unit tests for new features.
* Defined a VO for converting JSON string.
* Added code comment


## Features
* Customer can make a reservation for the movie
  * And, system can calculate the ticket fee for customer's reservation
* Theater have a following discount rules
  * 20% discount for the special movie
  * $3 discount for the movie showing 1st of the day
  * $2 discount for the movie showing 2nd of the day
  * Any movies showing starting between 11AM ~ 4pm, you'll get 25% discount
  * Any movies showing on 7th, you'll get 1$ discount
  * The discount amount applied only one if met multiple rules; biggest amount one
* System can print the movie schedule with simple text & json format


## Add jars
* commons-beanutils-1.9.4.jar
* commons-collections-3.2.2.jar
* commons-lang-2.6.jar
* commons-logging-1.2.jar
* ezmorph-1.0.6.jar
* json-lib-2.4-jdk15.jar



# Simorgh Food Ordering App

## Screenshots

#### Signup:
![](pictures/signup.png)

#### Login:
![](pictures/login.png)

#### Food List:
![](pictures/foods.png)

#### Food:
![](pictures/food.png)

#### Restaurant:
![](pictures/resturant.png)

#### Cart:
![](pictures/cart.png)

#### recipe:
![](pictures/recipt.png)

#### User Profile:
![](pictures/user.png)

## How to Run
Use java 8 and start from main.java!

## UML
##### App models class diagram:
![](pictures/models_diagram.png)
##### Navigation framework class diagram:
![](pictures/navigation_diagram.png)
##### User Authentication diagram:
![](pictures/users_diagram.png)

## Requirements Met

##### Exceptions:
- navigation Package
- storage.users.UserAPI

##### Inheritance:
- Food -> Product
- Restaurant -> Shop
- DynamicPage -> Page

##### Generics:
- Shop<T extends Product>

##### Interfaces:
- Main -> INavigation
- Restaurant -> RestaurantDeliveryPolicy
- Cart -> CartCallback

##### Overloading:
- Cart Class

##### Overriding:
- DynamicPage -> Page

##### Polymorphism:
- Navigation -> pages

##### Threads:
- UserAPI <-> AuthCallback

##### Regex:
- email format verification
- phone number format verification

##### Dependency Injection:
- Dynamic Pages -> Navigation

##### Dependency Diagrams:
- models
- navigation
- storage.users

##### outsider code:
- utils.PersianCalendar

##### Tracking codes:
- ali@simorgh.com: pg5veq, 1flpo42

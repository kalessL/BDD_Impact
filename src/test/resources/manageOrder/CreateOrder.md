# CreateOrder

### [Example1](- "basic1")

Given the client [Tom](- "#client") has no [order](- "#clientOrder");
When Tom orders a [pizza](- "#pizza") which is [XL](- "#size") and [THIN](- "#crust") 
Then Tom's [order](- "#clientOrder=createOrder()") is created,
And Tom's order contains a pizza which is [XL](- "?=getSize(#clientOrder)") and [THIN](- "?=getCrust(#clientOrder)"),
And Tom's order is displayed,
And Tom's order status is set to [New](- "?=orderStatus(#clientOrder)").

### [Example2](- "basic2")

When Tom wants to add the following pizza to his order:

| [Pizza][pizza] | [Pizza Size][size]  | [Pizza Crust][crust]| [Toppings][topping]| [Prices][price]|
| ---------      |------               | ---------------     | ---------------    |----  |
| Pizza1         | SMALL               | THIN                | MUSHROOMS          |6.5   |
| Pizza2         | MEDIUM              | CHEESE              | PEPPERONI          |9.5   |
| Pizza3         | LARGE               | CLASSIC             | SAUSAGE            |9.5   |
| Pizza4         | XL                  | GLUTEN_FREE         | GREEN_PEPPERS      |12.5  |
| Pizza5         | MEDIUM              | CHEESE              | CHEESE             |9.5   |

[size]: - "#pizzaSize"
[crust]: - "#pizzaCrust"
[topping]:  - "#pizzaTopping"
[pizza]: - "#pizza = createPizza(#pizzaSize, #pizzaCrust, #pizzaTopping)"
[price]: - "?=getPrice(#pizza)"

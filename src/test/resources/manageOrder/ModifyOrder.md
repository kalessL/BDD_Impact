# #ModifyOrder

**Given** the client [Tom](- "#client") has an [order](- "#clientOrder=createOrder()");
**When** the order is modify to suppress a [Drink](- "#drink") and [add](- "#result=addedFrom(#clientOrder)") a Pizza which is XL and THIN,
**Then** a [Drink](- "?=removedFrom(#clientOrder)") is removed from Tom's order,
**And** a Pizza [XL](- "?=#result.size") and [THIN](- "?=#result.crust") is added from Tom's order,
**And** Tom's order is displayed.
 


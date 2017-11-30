# StartPreparation

**Given** the client Tom has an [order](- "#order=createOrder()");
**When** user starts preparing the [order](- "#order=prepare(#order)"),
**Then** Tom's order is added in the preparation list
**And** Tom's order new status is '[InPreparation](- "?=getStatus(#order)")'


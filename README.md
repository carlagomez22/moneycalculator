Modificaciones realizadas:

Se ha implementado una funcionalidad de historial que muestra al usuario operaciones de cambio de divisas realizadas con anterioridad.

Para llevar a cabo esta funcionalidad se han añadido las siguientes clases:

- En el modelo se añadió la clase ExchangeOperation que representa una operación de cambio de moneda, con los campos ExchangeRate exchangeRate, Money result y LocalDateTime date que representa el día y la hora en la que se hizo la operación.
- Se añadió la interfaz Store, cuya implementación (OperationStore que se encuentra en el package Application) será la forma de guardar el historial, en este caso para hacer la prueba se hizo con un ArrayList pero esto podría variar.
- En view se agregó la interfaz OperationDisplay para poder ir mostrando el historial.

A parte en el Desktop se hicieron las modificaciones necesarias para que la UI mostrara tanto el área de texto con el historial como el botón que permite ir enseñándolo. 

# NotificationService

*Design structure for notification service.*

This service is using Reactor-bus for publishing the event on event Bus(We could use kafka Queues in place of this event-bus).

Project Flow

1.When ever an method is called from **ClientService**, *aop* is implemented to check for the                      execution of the methods.
2.**ClientEventPublisher** implements the advice and routes the message to the event Bus passing       the type of event handler.
3.**EventHandler** class listen to the bus and based of **NotificationType** calls the suitable                      **NotificationSevrice** and sends the event


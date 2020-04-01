package com.saxo.assignment.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saxo.assignment.exception.NotificationException;
import com.saxo.assignment.model.Notification;
import com.saxo.assignment.service.NotificationService;

import reactor.bus.Event;
import reactor.fn.Consumer;

/**
 * This class is responsible for consuming the event that was published on the event-bus by publishe
 *
 */
@Service
public class EventHandler implements Consumer<Event<Notification>> {
	
	
	private final Logger LOG = LoggerFactory.getLogger("EventHandler");
    private final List<NotificationService> notficationServices;

    @Autowired
    public EventHandler(List<NotificationService> notficationServices) {
        this.notficationServices = notficationServices;
    }

	/**
	 * @param notificationEvent
	 * This method is responsible for getting the right notification service and than use that service to send out the notification
	 */
    @Override
    public void accept(Event<Notification> notificationEvent) {
        Notification notification = notificationEvent.getData();
        NotificationService notificationService = notficationServices.stream().filter(o -> o.isSupported(notification.getNotificationType()))
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new); 
        try {
        	notificationService.sendNotification(notification);
        } catch (InterruptedException e) {
        	 LOG.error("Error occurred while sending notification :", notification.toString());
        	 throw new NotificationException("Error occurred while sending notification");
        }
    }
}

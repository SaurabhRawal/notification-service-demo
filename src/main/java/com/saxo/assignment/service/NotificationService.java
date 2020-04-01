package com.saxo.assignment.service;

import com.saxo.assignment.model.Notification;
import com.saxo.assignment.model.NotificationTypesEnum;

/**
 * Notification Service that is responsible for sending notification to the user
 *
 */
public interface NotificationService {
	
    /**
     * @param notification
     * @throws InterruptedException
     * Sends Notification to user based on different implementation
     */
    void sendNotification(Notification notification) throws InterruptedException;
    
    /**
     * @param notificationTypesEnum
     * @return
     * check if the Notification type is supported by the application
     */
    boolean isSupported(NotificationTypesEnum notificationTypesEnum);
}

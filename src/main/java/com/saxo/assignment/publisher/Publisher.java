package com.saxo.assignment.publisher;

import com.saxo.assignment.model.Notification;

/**
 * Publish the notification to the event bus which is later consumed by event handler
 *
 */
public interface Publisher {
	
	/**
	 * @param notification
	 * This method is responsible for publishing the event
	 */
	void publish(Notification notification);
}

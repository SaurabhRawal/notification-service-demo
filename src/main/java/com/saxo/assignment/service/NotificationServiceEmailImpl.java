package com.saxo.assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.saxo.assignment.model.Notification;
import com.saxo.assignment.model.NotificationTypesEnum;

@Service
public class NotificationServiceEmailImpl implements NotificationService {

    private final Logger LOG = LoggerFactory.getLogger("NotificationServiceEmailImpl");

    /* (non-Javadoc)
     * @see com.saxo.assignment.service.NotificationService#sendNotification(com.saxo.assignment.model.Notification)
     */
    @Override
    public void sendNotification(Notification notification) throws InterruptedException {
        LOG.info("Email with Notification Id {} reached!!!", notification.getNotificationId());
    }

	/* (non-Javadoc)
	 * @see com.saxo.assignment.service.NotificationService#isSupported(com.saxo.assignment.model.NotificationTypesEnum)
	 */
	@Override
	public boolean isSupported(NotificationTypesEnum notificationTypesEnum) {		
		return NotificationTypesEnum.EMAIL.equals(notificationTypesEnum);
	}

}

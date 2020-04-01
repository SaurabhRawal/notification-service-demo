package com.saxo.assignment.publisher;

import static reactor.bus.selector.Selectors.$;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saxo.assignment.handler.EventHandler;
import com.saxo.assignment.model.Notification;
import com.saxo.assignment.model.NotificationTypesEnum;

import reactor.bus.Event;
import reactor.bus.EventBus;

@Aspect
@Component
public class ClientEventPublisher implements Publisher {
	
	private final Logger LOG = LoggerFactory.getLogger("EventPublisher");
	private EventBus eventBus;
	private EventHandler eventHandler;
	private static final String EVENT_HANDLER = "eventHandler";
		
    @Autowired
	public ClientEventPublisher(EventBus eventBus, EventHandler eventHandler) {
		this.eventBus = eventBus;
		this.eventHandler = eventHandler;
	}
    
	@AfterReturning("com.saxo.assignment.aop.CommonJoinPointConfig.emailNotificationPointCut()")
    public void emailNotificationComposer(JoinPoint joinPoint) {
		Notification notification = Notification.builder().NotificationId(1)
				.notificationType(NotificationTypesEnum.EMAIL)
				.deliveryAddress("saurabh.rawal@nagarro.com")
				.message("Message For email Notification").build();
		publish(notification);
    }
	
	@AfterReturning("com.saxo.assignment.aop.CommonJoinPointConfig.pushMessageNotificationPointCut()")
    public void pushNotificationComposer() {
		Notification notification = Notification.builder().NotificationId(2)
				.notificationType(NotificationTypesEnum.PUSH_MESSAGE)
				.message("Message for push Notification").build();
		publish(notification);
    }
	
	@AfterReturning("com.saxo.assignment.aop.CommonJoinPointConfig.textNotificationPointCut()")
    public void TextNotificationComposer() {
		Notification notification = Notification.builder().NotificationId(3)
				.notificationType(NotificationTypesEnum.TEXT_MESSAGE)
				.deliveryAddress("1234567890")
				.message("Message for Text Notification").build();
		publish(notification);
    }
    
	/* (non-Javadoc)
	 * @see com.saxo.assignment.publisher.Publisher#publish(com.saxo.assignment.model.Notification)
	 */
	@Override
	public void publish(Notification notification){
		eventBus.on($(EVENT_HANDLER), eventHandler);
		LOG.info("Publishing event : {}", notification.toString());
		eventBus.notify(EVENT_HANDLER, Event.wrap(notification));
	}

}

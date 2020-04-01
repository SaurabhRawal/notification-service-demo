package com.saxo.assignment.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Notification {

	private int NotificationId;
    private String deliveryAddress;
    private String status;
    private String message;
    private NotificationTypesEnum notificationType;

}

package br.com.bfrjunior.magalums.controller.dto;

import java.time.LocalDateTime;

import br.com.bfrjunior.magalums.entity.Channel;
import br.com.bfrjunior.magalums.entity.Notification;
import br.com.bfrjunior.magalums.entity.Status;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                String destination,
                String message,
                Channel.Values channel) {

        public Notification toNotification() {
                return new Notification(
                                dateTime,
                                destination,
                                message,
                                channel.toChannel(),
                                Status.Values.PENDING.toStatus());

        }
}

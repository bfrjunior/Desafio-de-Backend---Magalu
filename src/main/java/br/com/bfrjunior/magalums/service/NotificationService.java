package br.com.bfrjunior.magalums.service;

import org.springframework.stereotype.Service;

import br.com.bfrjunior.magalums.controller.dto.ScheduleNotificationDto;
import br.com.bfrjunior.magalums.repository.NotificationRepository;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }
}

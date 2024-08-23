package br.com.bfrjunior.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bfrjunior.magalums.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}

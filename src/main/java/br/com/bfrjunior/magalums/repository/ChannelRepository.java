package br.com.bfrjunior.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bfrjunior.magalums.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

}

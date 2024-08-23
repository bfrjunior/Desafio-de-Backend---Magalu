package br.com.bfrjunior.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bfrjunior.magalums.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}

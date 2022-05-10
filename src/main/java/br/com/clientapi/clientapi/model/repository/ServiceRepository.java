package br.com.clientapi.clientapi.model.repository;

import br.com.clientapi.clientapi.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}

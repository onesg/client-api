package br.com.clientapi.clientapi.model.repository;

import br.com.clientapi.clientapi.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}

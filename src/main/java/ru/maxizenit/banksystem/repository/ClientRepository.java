package ru.maxizenit.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxizenit.banksystem.entity.Client;

/**
 * Репозиторий для клиентов.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

  Client findClientByTIN(String TIN);
}

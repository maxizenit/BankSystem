package ru.maxizenit.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxizenit.banksystem.entity.Transfer;

/**
 * Репозиторий для переводов.
 */
@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

}

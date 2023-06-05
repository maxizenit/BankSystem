package ru.maxizenit.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxizenit.banksystem.entity.Deposit;

/**
 * Репозиторий для вкладов.
 */
@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {

}

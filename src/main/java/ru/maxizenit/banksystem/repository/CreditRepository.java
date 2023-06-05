package ru.maxizenit.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxizenit.banksystem.entity.Credit;

/**
 * Репозиторий для кредитов.
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, Integer> {

}

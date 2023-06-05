package ru.maxizenit.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxizenit.banksystem.entity.Passport;

/**
 * Репозиторий для паспортов.
 */
@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer> {

}

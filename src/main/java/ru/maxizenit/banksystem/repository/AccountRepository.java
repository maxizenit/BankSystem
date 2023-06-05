package ru.maxizenit.banksystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxizenit.banksystem.entity.Account;
import ru.maxizenit.banksystem.entity.Client;

/**
 * Репозиторий для счетов.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

  /**
   * Возвращает счёт по его номеру.
   *
   * @param number номер счёта
   * @return счёт с данным номером
   */
  Account findAccountByNumber(String number);

  /**
   * Возвращает список счетов по клиенту.
   *
   * @param client клиент
   * @return все счета клиента
   */
  List<Account> findAccountsByClient(Client client);
}

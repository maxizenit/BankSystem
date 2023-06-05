package ru.maxizenit.banksystem.service;

import java.util.List;
import ru.maxizenit.banksystem.enm.AccountType;
import ru.maxizenit.banksystem.entity.Account;
import ru.maxizenit.banksystem.entity.Client;

/**
 * Сервис для счетов.
 */
public interface AccountService {

  /**
   * Возвращает счёт по его номеру.
   *
   * @param number номер
   * @return счёт с данным номером
   */
  Account getByNumber(String number);

  /**
   * Сохраняет счёт.
   *
   * @param account счёт
   * @return счёт
   */
  Account save(Account account);

  /**
   * Открывает счёт заданного типа.
   *
   * @param client      счёт
   * @param accountType тип счёта
   * @return счёт
   */
  Account open(Client client, AccountType accountType);

  /**
   * Возвращает список счетов по клиенту.
   *
   * @param client клиент
   * @return все счета клиента
   */
  List<Account> getByClient(Client client);
}

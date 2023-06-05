package ru.maxizenit.banksystem.service;

import java.math.BigDecimal;
import ru.maxizenit.banksystem.entity.Account;
import ru.maxizenit.banksystem.entity.Transfer;
import ru.maxizenit.banksystem.exception.CreateTransferException;

/**
 * Сервис для переводов.
 */
public interface TransferService {

  /**
   * Создаёт и сохраняет перевод.
   *
   * @param sender    счёт-отправитель
   * @param recipient счёт-получатель
   * @param amount    сумма
   * @return перевод
   * @throws CreateTransferException если условия перевода недопустимы
   */
  Transfer create(Account sender, Account recipient, BigDecimal amount)
      throws CreateTransferException;
}

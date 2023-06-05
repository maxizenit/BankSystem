package ru.maxizenit.banksystem.service;

import ru.maxizenit.banksystem.entity.Client;
import ru.maxizenit.banksystem.entity.Passport;
import ru.maxizenit.banksystem.exception.SavePassportException;

/**
 * Сервис для клиентов.
 */
public interface ClientService {

  /**
   * Возвращает клиента с заданным ИНН.
   *
   * @param TIN ИНН
   * @return клиент с заданным ИНН
   */
  Client getByTIN(String TIN);

  /**
   * Сохраняет клиента.
   *
   * @param client клиент
   * @return клиент
   */
  Client save(Client client);

  /**
   * Создаёт клиента.
   *
   * @param phoneNumber номер телефона
   * @param TIN         ИНН
   * @param passport    паспорт
   * @return клиент
   * @throws SavePassportException если условия сохранения недопустимы
   */
  Client create(String phoneNumber, String TIN, Passport passport) throws SavePassportException;
}

package ru.maxizenit.banksystem.service;

import ru.maxizenit.banksystem.entity.Passport;
import ru.maxizenit.banksystem.exception.SavePassportException;

/**
 * Сервис для паспортов.
 */
public interface PassportService {

  /**
   * Сохраняет паспорт.
   *
   * @param passport паспорт
   * @return паспорт
   * @throws SavePassportException если условия сохранения недопустимы
   */
  Passport save(Passport passport) throws SavePassportException;
}

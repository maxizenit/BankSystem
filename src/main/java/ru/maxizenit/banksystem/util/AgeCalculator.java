package ru.maxizenit.banksystem.util;

import java.util.Date;
import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * Калькулятор возраста.
 */
public class AgeCalculator {

  /**
   * Возвращает возраст в годах на текущий момент по дате рождения.
   *
   * @param birthdate дата рождения
   * @return возраст
   */
  public static int calculateAge(Date birthdate) {
    return Years.yearsBetween(new LocalDate(birthdate), new LocalDate()).getYears();
  }
}

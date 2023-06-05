package ru.maxizenit.banksystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Паспорт.
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Passport {

  /**
   * Идентификатор.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  /**
   * Номер.
   */
  private String number;

  /**
   * Дата рождения.
   */
  private Date birthdate;

  /**
   * Фамилия.
   */
  private String lastName;

  /**
   * Имя.
   */
  private String firstName;

  /**
   * Отчество.
   */
  private String middleName;
}

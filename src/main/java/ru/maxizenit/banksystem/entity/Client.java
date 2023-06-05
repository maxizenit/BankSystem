package ru.maxizenit.banksystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Клиент.
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

  /**
   * Идентификатор.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  /**
   * Номер телефона.
   */
  private String phoneNumber;

  /**
   * ИНН.
   */
  private String TIN;

  /**
   * Паспорт.
   */
  @OneToOne
  @JoinColumn(name = "passport_id")
  private Passport passport;
}

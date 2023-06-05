package ru.maxizenit.banksystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.maxizenit.banksystem.enm.AccountType;

/**
 * Счёт.
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {

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
   * Клиент, которому принадлежит счёт.
   */
  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  /**
   * Баланс.
   */
  private BigDecimal balance;

  /**
   * Тип.
   */
  @Enumerated
  private AccountType accountType;
}

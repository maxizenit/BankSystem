package ru.maxizenit.banksystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Кредит.
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Credit {

  /**
   * Идентификатор.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  /**
   * Счёт.
   */
  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  /**
   * Дата открытия.
   */
  private Date openingDate;

  /**
   * Срок в месяцах.
   */
  private Integer term;

  /**
   * Годовая ставка.
   */
  private BigDecimal annualRate;

  /**
   * Признак закрытия.
   */
  private Boolean isClosed;
}

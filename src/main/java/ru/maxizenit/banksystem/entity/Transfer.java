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
 * Перевод между счетами.
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transfer {

  /**
   * Идентификатор.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  /**
   * Дата.
   */
  private Date date;

  /**
   * Отправитель.
   */
  @ManyToOne
  @JoinColumn(name = "sender_id")
  private Account sender;

  /**
   * Получатель.
   */
  @ManyToOne
  @JoinColumn(name = "recipient_id")
  private Account recipient;

  /**
   * Сумма.
   */
  private BigDecimal amount;
}

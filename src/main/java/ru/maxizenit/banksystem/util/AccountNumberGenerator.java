package ru.maxizenit.banksystem.util;

import org.springframework.stereotype.Component;
import ru.maxizenit.banksystem.entity.Account;

/**
 * Генератор номера счёта.
 */
@Component
public class AccountNumberGenerator {

  private static final String PREFIX = "40817";

  private static final String CURRENCY = "810";

  private static final String BRANCH = "0000";

  private static final String BIC = "123456789";

  private static final int CONTROL_NUMBER_POSITION = 8;

  public synchronized String generateNumber(Account account, int accountsByClientCount) {
    StringBuilder accountNumberWithoutControlNumber =
        new StringBuilder(PREFIX).append(CURRENCY).append("0").append(BRANCH)
            .append(String.format("%07d", accountsByClientCount));
    
    return accountNumberWithoutControlNumber.replace(CONTROL_NUMBER_POSITION,
            CONTROL_NUMBER_POSITION, getControlNumber(accountNumberWithoutControlNumber.toString()))
        .toString();
  }

  private String getControlNumber(String accountNumberWithoutControlNumber) {
    int controlNumber = 0;

    return Integer.toString(controlNumber);
  }
}

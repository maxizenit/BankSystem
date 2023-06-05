package ru.maxizenit.banksystem.service.impl;

import java.math.BigDecimal;
import java.util.List;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.enm.AccountType;
import ru.maxizenit.banksystem.entity.Account;
import ru.maxizenit.banksystem.entity.Client;
import ru.maxizenit.banksystem.repository.AccountRepository;
import ru.maxizenit.banksystem.service.AccountService;
import ru.maxizenit.banksystem.util.AccountNumberGenerator;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  private final AccountNumberGenerator accountNumberGenerator;

  @Autowired
  public AccountServiceImpl(AccountRepository accountRepository,
      AccountNumberGenerator accountNumberGenerator) {
    this.accountRepository = accountRepository;
    this.accountNumberGenerator = accountNumberGenerator;
  }

  @Override
  public Account getByNumber(String number) {
    return accountRepository.findAccountByNumber(number);
  }

  @Override
  public Account save(@NonNull Account account) {
    return accountRepository.save(account);
  }

  @Override
  public synchronized Account open(@NonNull Client client, @NonNull AccountType accountType) {
    Account account = new Account();

    account.setClient(client);
    account.setAccountType(accountType);
    account.setBalance(BigDecimal.ZERO);
    account.setNumber(accountNumberGenerator.generateNumber(account, getByClient(client).size()));

    return save(account);
  }

  @Override
  public List<Account> getByClient(Client client) {
    return accountRepository.findAccountsByClient(client);
  }
}

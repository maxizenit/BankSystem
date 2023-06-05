package ru.maxizenit.banksystem.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.entity.Account;
import ru.maxizenit.banksystem.entity.Transfer;
import ru.maxizenit.banksystem.exception.CreateTransferException;
import ru.maxizenit.banksystem.repository.TransferRepository;
import ru.maxizenit.banksystem.service.AccountService;
import ru.maxizenit.banksystem.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

  private final TransferRepository transferRepository;

  private final AccountService accountService;

  @Autowired
  public TransferServiceImpl(TransferRepository transferRepository, AccountService accountService) {
    this.transferRepository = transferRepository;
    this.accountService = accountService;
  }

  @Override
  public synchronized Transfer create(@NonNull Account sender, @NonNull Account recipient,
      @NonNull BigDecimal amount)
      throws CreateTransferException {
    if (sender.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
      throw new CreateTransferException();
    }

    sender.setBalance(sender.getBalance().subtract(amount));
    recipient.setBalance(recipient.getBalance().add(amount));
    accountService.save(sender);
    accountService.save(recipient);

    Transfer transfer = new Transfer();
    transfer.setDate(new Date());
    transfer.setSender(sender);
    transfer.setRecipient(recipient);
    transfer.setAmount(amount);

    return transferRepository.save(transfer);
  }
}

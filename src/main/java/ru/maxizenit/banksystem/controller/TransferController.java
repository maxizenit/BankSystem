package ru.maxizenit.banksystem.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maxizenit.banksystem.exception.CreateTransferException;
import ru.maxizenit.banksystem.service.AccountService;
import ru.maxizenit.banksystem.service.TransferService;

/**
 * REST-контроллер для переводов.
 */
@RestController
@RequestMapping("/transfers")
public class TransferController {

  private final TransferService transferService;

  private final AccountService accountService;

  @Autowired
  public TransferController(TransferService transferService, AccountService accountService) {
    this.transferService = transferService;
    this.accountService = accountService;
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestParam("sender") String senderNumber,
      @RequestParam("recipient") String recipientNumber, @RequestParam("amount")
  BigDecimal amount) throws CreateTransferException {
    transferService.create(accountService.getByNumber(senderNumber),
        accountService.getByNumber(recipientNumber), amount);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

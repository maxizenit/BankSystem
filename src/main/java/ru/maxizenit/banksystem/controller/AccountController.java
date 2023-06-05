package ru.maxizenit.banksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maxizenit.banksystem.enm.AccountType;
import ru.maxizenit.banksystem.entity.Account;
import ru.maxizenit.banksystem.entity.Client;
import ru.maxizenit.banksystem.service.AccountService;
import ru.maxizenit.banksystem.service.ClientService;

/**
 * REST-контроллер для счетов.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

  private final AccountService accountService;

  private final ClientService clientService;

  @Autowired
  public AccountController(AccountService accountService, ClientService clientService) {
    this.accountService = accountService;
    this.clientService = clientService;
  }

  @PostMapping
  public ResponseEntity<String> create(
      @RequestParam("clientTIN") String clientTIN
  ) {
    Client client = clientService.getByTIN(clientTIN);
    Account account = accountService.open(client, AccountType.CURRENT);

    return new ResponseEntity<>(account.getNumber(), HttpStatus.OK);
  }
}

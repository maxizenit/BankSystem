package ru.maxizenit.banksystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maxizenit.banksystem.entity.Passport;
import ru.maxizenit.banksystem.exception.SavePassportException;
import ru.maxizenit.banksystem.service.ClientService;

/**
 * REST-контроллер для клиентов.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientService clientService;

  @Autowired
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping
  public ResponseEntity<?> create(
      @RequestParam("phoneNumber") String phoneNumber,
      @RequestParam("TIN") String TIN,
      @RequestParam("passportNumber") String passportNumber,
      @RequestParam("birthdate") String birthdate,
      @RequestParam("lastName") String lastName,
      @RequestParam("firstName") String firstName,
      @RequestParam("middleName") String middleName
  ) throws SavePassportException, ParseException {
    Passport passport = new Passport();
    passport.setNumber(passportNumber);
    passport.setBirthdate(new SimpleDateFormat("dd-MM-yyyy").parse(birthdate));
    passport.setLastName(lastName);
    passport.setFirstName(firstName);
    passport.setMiddleName(middleName);

    clientService.create(phoneNumber, TIN, passport);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}

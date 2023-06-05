package ru.maxizenit.banksystem.service.impl;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.entity.Client;
import ru.maxizenit.banksystem.entity.Passport;
import ru.maxizenit.banksystem.exception.SavePassportException;
import ru.maxizenit.banksystem.repository.ClientRepository;
import ru.maxizenit.banksystem.service.ClientService;
import ru.maxizenit.banksystem.service.PassportService;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  private final PassportService passportService;

  @Override
  public Client getByTIN(String TIN) {
    return clientRepository.findClientByTIN(TIN);
  }

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository, PassportService passportService) {
    this.clientRepository = clientRepository;
    this.passportService = passportService;
  }

  @Override
  public Client save(@NonNull Client client) {
    return clientRepository.save(client);
  }

  @Override
  public Client create(@NonNull String phoneNumber, @NonNull String TIN, @NonNull Passport passport)
      throws SavePassportException {
    passportService.save(passport);

    Client client = new Client();
    client.setPhoneNumber(phoneNumber);
    client.setTIN(TIN);
    client.setPassport(passport);

    return save(client);
  }
}

package ru.maxizenit.banksystem.service.impl;

import java.util.Date;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.entity.Passport;
import ru.maxizenit.banksystem.exception.SavePassportException;
import ru.maxizenit.banksystem.repository.PassportRepository;
import ru.maxizenit.banksystem.service.PassportService;
import ru.maxizenit.banksystem.util.AgeCalculator;

@Service
public class PassportServiceImpl implements PassportService {

  private static final int MIN_AGE_FOR_CLIENT = 18;

  private final PassportRepository passportRepository;

  @Autowired
  public PassportServiceImpl(PassportRepository passportRepository) {
    this.passportRepository = passportRepository;
  }

  @Override
  public Passport save(@NonNull Passport passport) throws SavePassportException {
    Date currentDate = new Date();

    //if (passport.getExpireDate().compareTo(currentDate) >= 0) {
    //  throw new SavePassportException();
    //}

    if (AgeCalculator.calculateAge(passport.getBirthdate()) < MIN_AGE_FOR_CLIENT) {
      throw new SavePassportException();
    }

    return passportRepository.save(passport);
  }
}

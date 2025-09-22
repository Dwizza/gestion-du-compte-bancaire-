package service;

import model.Account;
import repository.AccountRepository;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account createAccount(UUID ownerUserId);
    List<Account> findAll();
}

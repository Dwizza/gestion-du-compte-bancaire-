package service;

import model.Account;
import repository.AccountRepository;

import java.util.UUID;

public interface AccountService {

    Account createAccount(UUID ownerUserId);
}

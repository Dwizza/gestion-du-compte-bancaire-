package service;

import model.Account;

import java.util.UUID;

public interface AccountService {

    Account createAccount( UUID ownerUserId);
}

package service.impliment;

import model.Account;
import repository.AccountRepository;
import service.AccountService;

import java.util.UUID;

public class InMemoryAccountService implements AccountService
{
    private AccountRepository accountRepository;

    public Account createAccount(UUID ownerUserId){
        String accountId = UUID.randomUUID().toString();
        Account account = new Account(accountId, ownerUserId);
        return  accountRepository.save(account);
    }


}

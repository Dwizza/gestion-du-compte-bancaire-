package service.impliment;

import model.Account;
import repository.AccountRepository;
import service.AccountService;

import java.util.List;
import java.util.UUID;

public class InMemoryAccountService implements AccountService
{
    private static AccountRepository accountRepository;



    public InMemoryAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(UUID ownerUserId){
        String accountId = UUID.randomUUID().toString();
        Account account = new Account(accountId, ownerUserId);
        return  accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return List.of();
    }
}

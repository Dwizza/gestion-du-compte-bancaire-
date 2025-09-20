package repository.impliment;

import model.Account;
import repository.AccountRepository;

import java.util.HashMap;

public class InMemoryAccountRepository implements AccountRepository {

    private HashMap<String, Account> accounts = new HashMap<>();

    public Account save(Account account) {
        accounts.put(account.getAccountId(), account);
        return account;
    }
}

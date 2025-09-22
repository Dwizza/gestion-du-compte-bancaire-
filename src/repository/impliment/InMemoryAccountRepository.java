package repository.impliment;

import model.Account;
import repository.AccountRepository;

import java.util.HashMap;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {

    private HashMap<String, Account> accounts = new HashMap<>();

    @Override
    public Account save(Account account) {
        accounts.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public List<Account> findAll() {
        return List.of();
    }
}

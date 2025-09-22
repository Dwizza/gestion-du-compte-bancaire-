package repository;

import model.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);
    List<Account> findAll();
}

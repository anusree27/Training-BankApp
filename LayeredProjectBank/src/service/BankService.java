package service;

import dto.Account;
import exceptions.AccountException;

import java.util.Collection;

public interface BankService {
    Account addAccount(Account newAccount) throws AccountException;

    Collection<Account> getAllAccounts();

    Account getAccountById(Integer accountId) throws AccountException;
    //Update
    Double depositFundsById(Integer accountId, Double amount) throws AccountException;

    Double withdrawFundsById(Integer accountId, Double amount) throws AccountException;

    boolean updateAccountNameById(Integer accountId, String newName) throws AccountException;
    // fund transfer + handle exceptions
    //Delete
    Account deleteAccountById(Integer accountId) throws AccountException; // hard delete

}

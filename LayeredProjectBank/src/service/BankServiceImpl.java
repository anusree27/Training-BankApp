package service;

import dto.Account;
import exceptions.AccountException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankServiceImpl implements BankService{

    private Map<Integer, Account> accountMap = new HashMap<>();

    @Override
    public Account addAccount(Account newAccount) throws AccountException {
        if(newAccount == null) {
            throw new AccountException("Account cannot be null");
        }
        if (this.accountMap.containsKey(newAccount.getAccountNo())) {
            throw new AccountException("Account already exists");
        }
        this.accountMap.put(newAccount.getAccountNo(), newAccount);
        return this.accountMap.get(newAccount.getAccountNo());
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return this.accountMap.values();
    }

    @Override
    public Account getAccountById(Integer accountId) throws AccountException {
        if(!this.accountMap.containsKey(accountId)) {
            throw new AccountException("Account is not present");
        }
        if(accountId == null) {
            throw new AccountException("Account id cannot be null");
        }
        return this.accountMap.get(accountId);
    }

    @Override
    public Double depositFundsById(Integer accountId, Double amount) throws AccountException {
        if(accountId == null) {
            throw new AccountException("Account id cannot be null");
        }
        if(!this.accountMap.containsKey(accountId)) {
            throw new AccountException("Account is not present");
        }
        if(amount < 0) {
            throw new AccountException("Amount to deposit should be greater than 0");
        }
        if(amount == null) {
            throw new AccountException("Amount cannot be null");
        }
        Account acc = this.accountMap.get(accountId);
        acc.setBalance(acc.getBalance() + amount);
        return acc.getBalance();
    }

    @Override
    public Double withdrawFundsById(Integer accountId, Double amount) throws AccountException {
        if(accountId == null) {
            throw new AccountException("Account id cannot be null");
        }
        if(!this.accountMap.containsKey(accountId)) {
            throw new AccountException("Account is not present");
        }
        if(amount < 0) {
            throw new AccountException("Amount to deposit should be greater than 0");
        }
        if(amount == null) {
            throw new AccountException("Amount cannot be null");
        }
        Account acc = this.accountMap.get(accountId);
        acc.setBalance(acc.getBalance() - amount);
        return acc.getBalance();
    }

    @Override
    public boolean updateAccountNameById(Integer accountId, String newName) throws AccountException {
        if(accountId == null) {
            throw new AccountException("Account id cannot be null");
        }

        if(!this.accountMap.containsKey(accountId)) {
            throw new AccountException("Account is not present");
        }

        if(newName == null) {
            throw new AccountException("Name cannot be null");
        }
        Account acc = this.accountMap.get(accountId);
        acc.setUserName(newName);
        return true;
    }

    @Override
    public Account deleteAccountById(Integer accountId) throws AccountException {
        if(accountId == null) {
            throw new AccountException("Account id cannot be null");
        }
        if(!this.accountMap.containsKey(accountId)) {
            throw new AccountException("Account is not present");
        }
        return this.accountMap.remove(accountId);
    }


}

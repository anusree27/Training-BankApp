package controller;

import dto.Account;
import exceptions.AccountException;
import service.BankService;
import service.BankServiceImpl;

public class Client {
    public static void main(String[] args) throws AccountException {
        BankService bankService = new BankServiceImpl();
        bankService.addAccount( new Account(1, "Anu", 1200.0));
        bankService.addAccount( new Account(2, "Nithya", 500.0));
        bankService.addAccount( new Account(3, "Shamitha", 600.0));

        System.out.println(bankService.getAllAccounts());

        System.out.println(bankService.depositFundsById(1, 10.0));


        System.out.println(bankService.withdrawFundsById(1, 20.0));

        System.out.println(bankService.updateAccountNameById(1, "Anusree"));

        System.out.println(bankService.deleteAccountById(2));

        System.out.println(bankService.getAllAccounts());
    }
}

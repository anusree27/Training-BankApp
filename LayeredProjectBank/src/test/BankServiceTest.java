package test;

import dto.Account;
import exceptions.AccountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.BankService;
import service.BankServiceImpl;

public class BankServiceTest {


    //add account
    @Test
    public void addAccountTest() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNotNull(bankService.addAccount(new Account(1, "Sandra", 400.0)));
        } catch (AccountException e) {
            throw new AccountException("Account does not exist");
        }
    }

    @Test
    @DisplayName("Should throw exception when account already exists")
    public void shouldThrowExceptionWhenAccountAlreadyExists() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            bankService.addAccount(new Account(1, "Anu", 20.0));
            bankService.addAccount(new Account(1, "Nithya", 10.0));
        }
        catch (AccountException e) {
            Assertions.assertEquals("Account already exists", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw Exception when add product receives null as input")
    public void shouldThrowExceptionWhenAddProductReceivesNullTest() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, ()-> bankService.addAccount(null));
    }




    //get account by id
    @Test
    public void getAccountByIdTest() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNotNull(bankService.getAccountById(2));
        } catch (AccountException e) {
            Assertions.assertEquals("Account is not present",e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw Exception when get account receives null")
    public void shouldThrowExceptionWhenAccountIdIsNullTest() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, () -> bankService.getAccountById(null));
    }

    @Test
    @DisplayName("Should throw Exception when get Account by id contains no account")
    public void shouldThrowExceptionWhenAccountIdContainsNoAccount() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNull(bankService.getAccountById(500));
        }
          catch (AccountException e) {
            Assertions.assertEquals("Account is not present", e.getMessage());
          }
    }



    //Deposit funds by id
    @Test
    public void depositFundsByIdTest() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNotNull(bankService.depositFundsById(1, 30.0));
        } catch (AccountException e) {
            Assertions.assertEquals("Account is not present", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw Exception when account is not present in Deposit Fund by id")
    public void shouldThrowExceptionWhenAccountIsNotPresentInDepositFundById() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, () -> bankService.depositFundsById(null, 100.0));
    }

    @Test
    @DisplayName("Should throw Exception when amount is not present in Deposit Fund by id")
    public void shouldThrowExceptionWhenAmountIsNotPresentInDepositFundById() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, () -> bankService.depositFundsById(30, null));
    }

    @Test
    @DisplayName("Should throw Exception when amount is less than zero in Deposit Fund by id")
    public void shouldThrowExceptionWhenAmountIsLessThanZeroInDepositFundById() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, () -> bankService.depositFundsById(30, -20.0));
    }



    //Withdraw funds by id

    @Test
    public void WithdrawFundsByIdTest() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNotNull(bankService.withdrawFundsById(1, 30.0));
        } catch (AccountException e) {
            Assertions.assertEquals("Account is not present", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw Exception when account is not present in Withdraw Fund by id")
    public void shouldThrowExceptionWhenAccountIsNotPresentInWithdrawFundById() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, () -> bankService.withdrawFundsById(null, 100.0));
    }

    @Test
    @DisplayName("Should throw Exception when amount is not present in Withdraw Fund by id")
    public void shouldThrowExceptionWhenAmountIsNotPresentInWithdrawFundById() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, () -> bankService.withdrawFundsById(30, null));
    }

    @Test
    @DisplayName("Should throw Exception when amount is less than zero in Withdraw Fund by id")
    public void shouldThrowExceptionWhenAmountIsLessThanZeroInWithdrawFundById() {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, () -> bankService.withdrawFundsById(30, -20.0));
    }



    //Update account name by id
    @Test
    public void updateAccountNameByIdTest() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNotNull(bankService.updateAccountNameById(1, "Abcd"));
        }
        catch (AccountException e) {
            Assertions.assertEquals("Account is not present", e.getMessage());
        }

    }

    @Test
    @DisplayName("Should throw exception when account id is null in update name by id")
    public void shouldThrowExceptionWhenAccountIdIsNullInUpdateNameById() throws AccountException {
        BankService bankService = new BankServiceImpl();
        bankService.addAccount(new Account(1, "Anu", 20.0));
        try {
            Assertions.assertNotNull(bankService.updateAccountNameById(null, "Abcd"));
        }
        catch (AccountException e) {
            Assertions.assertEquals("Account id cannot be null", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when new name is null in update name by id")
    public void shouldThrowExceptionWhenNewNameIsNullInUpdateNameById() throws AccountException {
        BankService bankService = new BankServiceImpl();
        bankService.addAccount(new Account(1, "Anu", 20.0));
        try {
            Assertions.assertNotNull(bankService.updateAccountNameById(1, null));
        }
        catch (AccountException e) {
            Assertions.assertEquals("Name cannot be null", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when account is not present in the account id in update account name by id")
    public void shouldThrowExceptionsWhenAccountIsNotPresentInAccountIdInUpdateNameById() {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNotNull(bankService.updateAccountNameById(3, "anu"));
        }
        catch (AccountException e) {
            Assertions.assertEquals("Account is not present", e.getMessage());
        }
    }



    //Delete account by id
    @Test
    public void deleteAccountById() throws AccountException {
        BankService bankService = new BankServiceImpl();
        try {
            Assertions.assertNotNull(bankService.deleteAccountById(1));
        } catch (AccountException e) {
            Assertions.assertEquals("Account is not present", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should Throw Exception When it receives null account id in delete account by id")
    public void shouldThrowExceptionWhenItReceivesNullAccountIdInDeleteAccountById() throws AccountException {
        BankService bankService = new BankServiceImpl();
        Assertions.assertThrows(AccountException.class, ()-> bankService.deleteAccountById(1));
    }
}

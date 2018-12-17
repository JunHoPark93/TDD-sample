package test;

import main.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        Account account = new Account(100000);
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new Account(100000);
        assertEquals(100000, account.getBalance(), "make account with 100000");

        account = new Account(100);
        assertEquals(100, account.getBalance(), "make account with 100");
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new Account(10000);
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }

    @Test
    public void testDeposit() throws Exception {
        Account account = new Account(10000);
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }
}

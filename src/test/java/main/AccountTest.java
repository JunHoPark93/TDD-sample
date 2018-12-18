package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account account;

    @BeforeEach
    private void setUp() {
        account = new Account(10000);
    }

    @Test
    public void testAccount() throws Exception {
    }

    @Test
    public void testGetBalance() throws Exception {
        assertEquals(10000, account.getBalance(), "make account with 100000");

        account = new Account(100);
        assertEquals(100, account.getBalance(), "make account with 100");
    }

    @Test
    public void testWithdraw() throws Exception {
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }

    @Test
    public void testDeposit() throws Exception {
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }
}

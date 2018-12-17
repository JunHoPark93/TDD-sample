package test;

import main.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
}

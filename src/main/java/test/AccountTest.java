package test;

import main.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        Account account = new Account(100000);
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new Account(100000);

        if(account.getBalance() != 100000) {
            fail();
        }

        account = new Account(1000);
        if(account.getBalance() != 1000) {
            fail("getBalance() => " + account.getBalance());
        }

        account = new Account(0);
        if(account.getBalance() != 0) {
            fail();
        }
    }
}

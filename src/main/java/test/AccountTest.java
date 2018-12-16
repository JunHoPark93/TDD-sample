package test;

import main.Account;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        Account account = new Account();

        if(account == null) {
            throw new Exception("Failed to make account");
        }
    }
}

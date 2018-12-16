package test;

import main.Account;

public class AccountTest {

    public void testAccount() throws Exception {
        Account account = new Account();

        if(account == null) {
            throw new Exception("Failed to make account");
        }
    }

    public static void main(String[] args) {
        AccountTest accountTest = new AccountTest();
        try {
            accountTest.testAccount();
        } catch (Exception e) {
            System.out.println("Failed");
            return;
        }
        System.out.println("Success!!");
    }
}

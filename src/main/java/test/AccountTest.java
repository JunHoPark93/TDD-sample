package test;

public class AccountTest {

    public void testAccount() {
        Account account = new Account();

        if(account == null) {
            throw new Exception("Failed to make account");
        }
    }

    public static void main(String[] args) {
        AccountTest accountTest = new AccountTest();
        accountTest.testAccount();
    }
}

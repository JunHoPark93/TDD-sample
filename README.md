# TDD-sample
TDD 샘플을 만들어보자

## 1. 테스트를 먼저 작성하기

```java

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
```

맨 처음에 test를 작성했다. Account는 현재 존재하지 않는 클래스이므로 빨간불이 뜬다. 그냥 넘어가는 이유는 테스트코드 작성시 흐름을 잃지 않기 위해서 이다.

참고) Test는 실패를 통해 배움을 늘려가는 기법이다. 빨리 실패해야 성공에 가까워진다.

## 2. 클래스를 어떻게 설계할까
클래스를 설계할 때는 '속성' 보다 '동작'에 집중해야 한다. 그렇게 되면 불필요한 속성을 줄일 수 있기 때문이다. 예를들어, Account 클래스는 '잔고', '이름' 등이 있어야 한다. 라고 접근하기 보다는 인출이라는 기능, 입금이라는 기능을 할 수 있어야 한다. 라고 접근을한 후 속성을 정의하는 것이 올바른 객체지향적인 접근 방식이다. 




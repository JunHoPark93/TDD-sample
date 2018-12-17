# TDD-sample
TDD 샘플을 만들어보자

test의 의미를 생각해보기위해 test폴더가 아닌 임의대로 java폴더 안에 생성하였음.

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
예를들어, 밑의 내용을 보면,
```java
public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        Account account = new Account();
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new Account(100000);

        if(account.getBalance() != 100000) {
            fail();
        }
    }
}
```
JUnit을 사용하였다. 첫 번째 testAccount는 계좌가 성공적으로 만들어 졌는지 확인한다. 두 번째 test는 계좌의 잔고를 확인한다.
이 테스트를 먼저 작성한다면 여기서 계좌에 숫자가 들어가는 생성자가 필요하므로 빨간 불이 켜질 것이다.
미리 Account class 를 만들지 않고 여기서 초기 금액을 설정하는 테스트를 만들었더니 Account class의 구조에대해서 생각해보게 끔 만드는 효과가 있다!

## 3. assertEquals써야 test인가 ?

결국 JUnit이라는 프레임을 쓰기 때문에 assertEquals를 쓰게 된다. 하지만 그냥 위와 같이 if문을 쓴다고 test가 아닌것은 아니다. 우리는 TDD의 중점을 잘 정의된 메소드를 쓰는 것에 맞추면 안된다. 자동화된 테스트 케이스를 미리 만든다면 그것이 if문이어도 TDD라고 할 수 있다.
TDD의 목적은 목표정하기 -> 테스트 케이스 만들기 -> 로직작성 인 것이다. JUnit이 TDD의 목적은 아니다. 하지만 JUnit 써보자...ㅎ

참고) 실패하는 테스트를 동시에 여러개 만드는것은 권장하지 않는다.

## 4. TDD의 장점?

- 개발의 방향성을 잃지 않게 해준다.
현재 어디까지 와있는지를 알려준다. 개발 도중 자리를 비우게 될때 일부러 특정 부분의 테스트케이스를 실패하게 만들어 놓기도한다. 다시 돌아왔을 때 재시작 시점을 알기 위해서이다.

- 품질 높은 모듈을 갖게 해준다.
TDD를 거치면 품질이 검증된 소프트웨어를 갖게되는 것이다. 엄격한 테스트를 통과한 단위(Unit)들을 조립한다면 좋은 퀄리티를 가진 소프트웨어가 될 것이다. 실제로 TDD를 적용한 개발 팀이 결함률이 그렇지 않은 팀에 비해 10%까지 감소한다는 연구 결과도 있다.

- 자동화된 단위테스트 케이스를 갖게 된다.
현재까지 작성된 시스템에 대한 이상유무를 알 수 있다. 그리고 테스트가 필요한 시점에 얼마든지 손 쉽게 가능하다.

- 사용설명서 & 의사소통 수단
TDD로 작성된 테스트 케이스는 사용 설명서이자 다른 개발자와 소통하는 수단이 될 수 있다. 대부분 API참조 문서보다 상황에 맞는 예제를 더 좋아히기 때문이다.

- 설계 개선
테스트 케이스를 작성할 때 객체 지향적으로 설계할 수 있다. 

- 자주 성공한다.
TDD는 싸이클을 짧게 가져간다. 그러면 녹색 성공 표시를 자주보게 되고 성취감을 느낄 수 있다. 
```java
String str = "test and then";
System.out.println("Divide and " + str + "Conquer !");
```

## 5. Uncle Bob의 원칙
1. 실패하는 테스트를 작성하기 전에는 절대로 제품 코드를 작성하지 않는다.
2. 실패하는 테스트 코드를 한 번에 하나 이상 작성하지 않는다.
3. 현재 실패하고 있는 테스트를 통과하기에 충분한 정도를 넘어서는 제품 코드를 작성하지 않는다.

## 6. 좋은 코드란?
좋은 코드란 한줄 한줄 의미를 분석하는 느낌이 들면 좋지 않은 소스, 소설책 읽듯이 문맥을 갖고 쉽게 읽히면 좋은 소스이다.
프로그래밍 언어가 발전하는 이유는 컴퓨터와 잘 대화하기 위해서가 아니라 다른 사람들과 더 잘 대화하기 위해서 이다.

#### Reference
http://repo.yona.io
https://junit.org/junit5/docs/current/user-guide/
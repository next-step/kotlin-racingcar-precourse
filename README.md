# kotlin-racingcar-precourse

# 과제 진행 소감
```
코틀린으로 프로젝트를 진행하면서 기존 자바와 대비 많은 부분에서 편리함을 느낄 수 있었다.(null-safety, operator overloading, Range...)
테스트 코드를 작성하며 Model에서 Random을 테스트 하는 부분이나 의존성과 테스트용의성에 대해 생각해볼 수 있었다.

```

# 과제진행 요구사항
 - 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
 - 기능을 구현하기 전 ```README.md```에 구현할 기능 목록을 정리해 추가한다.
 - Git의 커밋 단위는 앞 단계에서 ```README.md```에 정리한 기능 목록 단위로 추가한다.
   - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
 - 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다. 

# 과제 제출전 체크리스트
 - 터미널에서 java -version 을 실행하여 Java 버전이 17인지 확인한다. 
 - Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다. 
 - 터미널에서 Mac 또는 Linux 사용자의 경우 ./gradlew clean test 명령을 실행하고, Windows 사용자의 경우 gradlew.bat clean test 또 는 ./gradlew.bat clean test 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.
```
BUILD SUCCESSFUL in 0s
```


# 기능 요구사항
초간단 자동차 경주 게임을 구현한다.
 - [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 - [x] 각 자동차에 이름을 부여할 수 있다. 
 - [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 - [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 - [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 - [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
 - [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
 - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다 시 받는다.
   - Exception 이 아닌 IllegalArgumentException , IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 실행 결과
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) 
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : - 
woni : 
jun : -

pobi : -- 
woni : - 
jun : --

pobi : --- 
woni : -- 
jun : ---

pobi : ---- 
woni : --- 
jun : ----

pobi : ----- 
woni : ---- 
jun : -----

최종 우승자 : pobi, jun
```

# 프로그램 요구 사항 1
- Kotlin 1.9.0에서 실행 가능해야 한다.
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- 프로그램 실행의 시작점은 Application 의 main() 이다.
- 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다. 
- 프로그램 종료 시 또는 exitProcess() 를 호출하지 않는다. 
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.

# 프로그램 요구 사항 2
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Kotlin Coding conventions](https://kotlinlang.org/docs/coding-conventions.html)를 원칙으로 한다. 
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
    - [AssertJ User Guide](https://assertj.github.io/doc)
    - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
    - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

# 프로그램 요구 사항 3
 - 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다. 
   - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다. 
 - 가능한 한 else 예약어를 쓰지 않는다. 
   - 때로는 else 예약어와 조건식을 사용하는 것이 더 깔끔해 보일 수 있다. 어떤 상황에 사용하는 것이 적절한지 스스로 생각해 본다. 
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다. 
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다. 
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다. 
  - 힌트: MVC 패턴 기반으로 구현한 후, View와 Controller를 제외한 Model에 대한 단위 테스트 추가에 집중한다.
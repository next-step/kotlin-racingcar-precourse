# kotlin-racingcar-precourse

## 요구사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4이상인 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표를 이용하여 구분한다.
8. 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
9. Exception이 아닌 명확한 유형을 처리한다.

## 요구사항 상세 분석
### 자동차

1. [x] 자동차는 이름을 가진다.
    1. [x] 이름은 최대 5자 이하 조건이 있다
2. [x] 자동차는 위치를 가진다.
    1. [x] 기본 위치는 0이다.
3. [x] 자동차는 전진 조건에 해당하면 전진할 수 있다.
    1. [x] 자동차는 무작위로 뽑은 값이 4이하인 경우 전진할 수 있다.

### 랜덤숫자뽑기 - 2개의 숫자 사이 랜덤 숫자 뽑기
1. 2개의 숫자를 입력받아 그 사이 랜덤 값을 반환한다.
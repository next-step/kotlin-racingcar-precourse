# kotlin-racingcar-precourse

## 기능
- 자동차 전진 실행 결과 출력 (혹은 멈춤)
  - random 0..9 중 4 이상일 경우 전진
- 자동차 이름 부여
  - 쉼표로 구분
  - 5자 이하
- 이동 횟수 입력
- 우승자 출력
  - 여러 명일 경우 쉼표로 구분
  - 게임 완료 후 공개
- Exception
  - 입력 잘못된 경우 : 자동차 이름, 이동 횟수
  - 명확한 유형으로 처리 : IllegalArgumentException, IllegalStateException

## 고려사항
- MVC 패턴 : 도메인 로직 분리
  - Model (도메인)
  - View (Console)
  - Controller (명세)
- Unit Test 작성
  - JUnit 5 / AssertJ
- Indent depth < 3
  - while - if - when (x)
  - 함수당 최대 15라인
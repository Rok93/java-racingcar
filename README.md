# 프리코스 2주차 미션 (자동차 경주)

## 미션 요구사항 (2020. 01. 18 업데이트)
![image](https://user-images.githubusercontent.com/47850258/72633045-f8321500-399a-11ea-9d22-f71f43f9ec1a.png)

![image](https://user-images.githubusercontent.com/47850258/72633119-20217880-399b-11ea-8665-03f42637eab8.png)

![image](https://user-images.githubusercontent.com/47850258/72633105-18fa6a80-399b-11ea-9321-e6d25d14884b.png)

##  . 필요한 기능
1. 차량의 이름을 입력받는다.<br>
2. 사용자로부터 몇 번의 이동을 할 것인지 입력받는.<br>
3. 게임을 정해진 횟수만큼 진행한다.
&nbsp;3-1. 한번 진행할 때마다, 현재 각 자동차의 위치를 인쇄한다.
4. 게임이 끝나면 우승한 차량의 이름을 출력한다. (동시에 우승하는 경우에는 오름차순으로 동시 출력한다.)<br>

## 1. 구현 과정
1.시작은 위 요구사항을 만족하는데 집중한다. 작은 프로그램이라 큰 리팩토링이 없이 구현에 집중한다.
2.하드코딩을 피하고 예외처리 방식에 집중한다.

## 2. 예외처리 
1. 자동차의 이름은 5자 이하이다.<br>
2. 자동차의 이름은 1자 이상이다.<br>
3. 자동차는 최소 2대이상이어야 한다.<br>
4. 자동차의 이름은 중복되면 안된다.<br>
5. 시도횟수는 최소 1회이상이어야 한다. <br>

## 3. 개선사항
1. MVC 패턴을 이해하고 적용하기.<br>
- Model, View, Controller 를 확실하게 분리하기
- 객체지향적으로 설계하기 

## 4. 문제점
> 1. ~~차량의 이름을 입력받는 부분에서(InputView 기능) Car name 예외 처리행위를 못함~~. <br>
> 2. ~~1번의 문제를 해결하니 생기는 문제점 (InputView가 한번에 2가지 기능을 가져 버림)~~
>

### 고민되는 부분 
~~~
InputView에서 차량의 이름을 입력받고, 그에 따른 예외처리들 (차량 이름(5글자이하, ), 중복되는 차량이름, 최소 차량 개수,
InputView에서는 입력을 받아오는 행위만 해야한다. (한 가지 기능만 가진다는 원칙)
(List<Car>로 바꾸는 행위는 확실하게 하면 안된다고 생각, List<String> 타입도 가능한지에 대한 의문)
But 그렇게 처리를 하면 입력받는 부분과 예외처리 하는 부분이 분리가 돼어서, 예외가 발생하면 그대로 프로그램이 종료되어버림
예외가 처리 된 부분을 다시 실행하지 않아도 된다면, 일단은 기능적으로 이상이 없다.

InputView 쪽에서 예외처리를 하는게 
~~~

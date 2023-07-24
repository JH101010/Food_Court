<div align="center">
	<h1>JSP프로젝트) 웹에서 사용하는 푸드코트 주문 및 관리 페이지</h1>
</div>

<div align="right">🛠️Tools🛠️</div>
<div align="right">
	<img src="https://img.shields.io/badge/MariaDB-6D4C41?style=flat&logo=MariaDB&logoColor=white" />
	<img src="https://img.shields.io/badge/IntelliJ-1976D2?style=flat&logo=IntelliJ IDEA&logoColor=white" />
</div>


<div align="right">✏️Platforms & Languages✏️</div>
<div align="right">
	<img src="https://img.shields.io/badge/Java-007396?style=flat"/>
	<img src="https://img.shields.io/badge/HTML5-F57C00?style=flat&logo=HTML5&logoColor=white" />
	<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" />
</div>

<div align="right">✈️Dependencies✈️</div>
<div align="right">
	<img src="https://img.shields.io/badge/MariaDB Driver-6D4C41?style=flatstyle=flat&logo=MariaDB&logoColor=white" />
	<img src="https://img.shields.io/badge/Thymeleaf-33691E?style=flat&logo=Thymeleaf&logoColor=white" />
	<img src="https://img.shields.io/badge/Lombok-F4511E?style=flat"/>
	<img src="https://img.shields.io/badge/Spring Data JPA-558B2F?style=flat"/>
	
</div>

<br /><br />
## 요구사항
* A마트의 푸드코트를 이용한다.
* 여기에는 한식, 중식, 일식, 양식 코너가 있다.
* 각 코너에는 기본적으로 파는 음식이 2개씩 있고 판매자에 따라 추가할 수 있다.

<br /><br />
## ERD
<img src="https://github.com/JH101010/Food_Court/assets/111873058/79f2f01f-bb9e-4244-8924-4263afb60232" width="70%" height="70%"/>

<br /><br />
## 테이블 명세서
<img width="949" alt="image" src="https://github.com/JH101010/Food_Court/assets/111873058/57d3a893-228f-4d59-b4ec-1a3033b65522">

<br /><br />
## 샘플 데이터
DataLoader 파일을 만들어 서버가 처음 시작될 시 실행되어 데이터베이스에 기본값들이 자동으로 입력된다.
<span>
	<div>기본데이터</div>
	<img src="https://github.com/JH101010/Food_Court/assets/111873058/43e988fa-c2be-4f98-96c7-658d2f51cd03" width="20%" height="20%">
</span>
<span>
	<div>1. 조회_SELECT * FROM food_corner WHERE corner_num = 1;</div>
	<img src="https://github.com/JH101010/Food_Court/assets/111873058/fe02b4c5-d9a3-4827-aae6-40bb975ad6a9" width="20%" height="20%">
</span>
<span>
	<div>2. 삽입_INSERT INTO food_corner VALUES(5, 'test1');</div>
	<img src="https://github.com/JH101010/Food_Court/assets/111873058/1326f737-9da3-4a36-b045-050dff6bf219" width="20%" height="20%">
</span>



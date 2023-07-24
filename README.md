<div align="center">
	<h1>JSP프로젝트)푸드코트 주문 및 관리 페이지</h1>
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
# 데이터베이스
<hr />
<h2>요구사항</h2>
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
<div>
	<div>기본데이터</div>
	<img src="https://github.com/JH101010/Food_Court/assets/111873058/43e988fa-c2be-4f98-96c7-658d2f51cd03" width="20%" height="20%">
</div>
<table>
	<tr>
		<td>
			1. 조회<br />
			SELECT * FROM food_corner WHERE corner_num = 1;
		</td>
		<td>
			2. 삽입<br />
			INSERT INTO food_corner VALUES(5, 'test1');
		</td>
  	</tr>
	<tr>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/fe02b4c5-d9a3-4827-aae6-40bb975ad6a9" width="50%" height="75%">
		</td>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/1326f737-9da3-4a36-b045-050dff6bf219" width="75%" height="75%">
		</td>
	</tr>
	<tr>
		<td>
			3. 수정<br />
			UPDATE food_corner SET corner_name='test1_re' where corner_num = 5;
		</td>
		<td>
			4. 삭제<br />
			DELETE FROM food_corner WHERE corner_num = 5;
		</td>
	</tr>
	<tr>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/bece600f-9e31-4c67-abf7-109902475991" width="50%" height="50%">
		</td>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/41bf5d2c-3c83-431a-804c-c8ebb056e46d" width="70%" height="70%">
		</td>
	</tr>
</table>

<br /><br />
# 실행화면
<hr />

### 1. 시작 시 메인 화면
<img src="https://github.com/JH101010/Food_Court/assets/111873058/808b748e-64d3-46bc-8a08-5f7aa4307e7d" width="80%" height="80%">
<br />
우측 상단의 ID와 PW는 관리자 전용으로
ID : admin , PW : 1234 입력 시 관리자모드로 변경

관리자 접속 시 기능은 뒤에서 설명

홈으로 또는 FOOD COURT 클릭 시 시작화면으로 이동

우측 상단의 이름은 고객 로그인 칸
고객으로 접속해야만 주문을 할 수 있다.
<br /><br />

### 2. 코너 선택 시
<table>
	<tr>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/a055ed30-878d-4fdd-8e35-6c52f680d109" width="100%" height="100%">
		</td>
		<td>
  			<img src="https://github.com/JH101010/Food_Court/assets/111873058/a8299a5f-25be-4565-8b46-0ee2763c85ae" width="100%" height="100%">
		</td>
	</tr>
	<tr>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/b9fb7f77-ccb0-48f3-a3e2-4f462b96c6ab" width="100%" height="100%">
		</td>
		<td>
  			<img src="https://github.com/JH101010/Food_Court/assets/111873058/20b7e659-0625-4171-b43a-5b03a200b19b" width="100%" height="100%">
		</td>
	</tr>
</table>







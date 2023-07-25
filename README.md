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
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/f58f419e-197d-4baf-a878-131a9d443be7" width="50%" height="75%">
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
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/2b6149ef-b218-4ed9-81d0-109743788c89" width="50%" height="75%">
		</td>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/25e55c78-12b7-488d-bf07-4cde93768a4e" width="70%" height="95%">
		</td>
  	</tr>
   </table>
<br /><br />

### 4. 장바구니
<img src="https://github.com/JH101010/Food_Court/assets/111873058/e0792c6f-1f08-4897-b4d4-f801f28ffe87" width="70%" height="70%">
<img src="https://github.com/JH101010/Food_Court/assets/111873058/22666760-0ac8-41a9-a01f-bae9e7ffcb18" width="70%" height="70%">





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
<img src="https://github.com/JH101010/Food_Court/assets/111873058/79f2f01f-bb9e-4244-8924-4263afb60232" width="60%" height="60%"/>

<br /><br />
## 테이블 명세서
<img src="https://github.com/JH101010/Food_Court/assets/111873058/57d3a893-228f-4d59-b4ec-1a3033b65522" width="70%" height="70%">

<br /><br />
## 샘플 데이터
DataLoader 파일을 만들어 서버가 처음 시작될 시 실행되어 데이터베이스에 기본값들이 자동으로 입력된다.
<div>
	기본코너
	<br />
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



# 실행화면
<hr />

### 1. 메인화면
<img src="https://github.com/JH101010/Food_Court/assets/111873058/3119ae5d-4858-4369-82ed-8df7a11eaa0c" width="70%" height="70%">
<br />
우측 상단의 ID와 PW는 관리자 전용 로그인 칸.
ID : admin , PW : 1234 입력 시 관리자모드로 로그인.

관리자 접속 시 기능은 뒤에서 설명

홈으로 또는 FOOD COURT 클릭 시 시작화면으로 이동

우측 상단의 이름은 고객 로그인 칸.
고객으로 접속해야만 주문을 할 수 있다.
<br /><br />

### 2. 코너 선택 시
각 코너 별로 실행 시 넣은 기본 메뉴들이 들어가있다.
<table>
	<tr>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/d022e8c1-9db5-44fd-8c32-1b5b8b4d1758" width="70%" height="70%">
		</td>
  		<td>
	  		<img src="https://github.com/JH101010/Food_Court/assets/111873058/e82fdf4a-2a07-43a4-a848-ebd286dcdd97" width="70%" height="70%">
  		</td>
	</tr>
	<tr>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/3dc31f96-18fb-4619-8264-7a9f8b3ef70d" width="70%" height="70%">
		</td>
  		<td>
	  		<img src="https://github.com/JH101010/Food_Court/assets/111873058/278d7d2b-70cd-4eba-bcd0-4fdbe2759993" width="70%" height="70%">
  		</td>
	</tr>
</table>
<br />
또한 고객으로 로그인을 하지않아 장바구니 추가에 추가할 방법이 없다.
<br /><br />

### 3. 로그인 및 장바구니에 담기
우측 상단에 고객으로 로그인 후 모습
<br />
<img src="https://github.com/JH101010/Food_Court/assets/111873058/c97c287e-5379-4e42-b36a-e67e09186556" width="70%" height="70%">
<br />
고객으로 로그인 시 우측에 장바구니 추가 버튼이 생긴다.
<br /><br />

### 4. 장바구니
파전, 고기라면, 탕수육을 장바구니에 추가 후, 고기라면을 장바구니에서 제외시킨 모습이다.
<img src="https://github.com/JH101010/Food_Court/assets/111873058/e0792c6f-1f08-4897-b4d4-f801f28ffe87" width="70%" height="70%">
<img src="https://github.com/JH101010/Food_Court/assets/111873058/22666760-0ac8-41a9-a01f-bae9e7ffcb18" width="70%" height="70%">
<br /><br />

### 5. 대기현황
현재 주문대기 중인 고객들의 현황을 나타내고 있다.
<img src="https://github.com/JH101010/Food_Court/assets/111873058/bf979e53-8b70-4b33-9cf8-34c1855527c9" width="70%" height="70%">
<br /><br />



# 관리자 계정
<hr />

### 1. 관리자 계정으로 접속 시
우측하단에 메뉴 추가 버튼이 생성된다.
<br />
<img src="https://github.com/JH101010/Food_Court/assets/111873058/fa7bb610-0c1c-46d7-9136-2d5317dbc7d4" width="70%" height="70%">
<br /><br />

### 2. 메뉴 추가
<img src="https://github.com/JH101010/Food_Court/assets/111873058/0d92eac8-e614-474a-80de-7c02e6332031" width="70%" height="70%">
<br /><br />

메뉴가 추가된 모습
<table>
	<tr>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/4a81b5cc-54c5-4872-bfb0-53e97d1e8aae" width="70%" height="70%">	
		</td>
		<td>
			<img src="https://github.com/JH101010/Food_Court/assets/111873058/d408d9e9-d77b-4080-bd7e-5ab24263fbf4" width="70%" height="70%">	
		</td>
	</tr>
</table>


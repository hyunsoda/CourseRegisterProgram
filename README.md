# 수강신청 프로그램 만들기 
Server, Java, Sql을 이용한 toy project입니다.

## SQLTable
1. STUDENT
   STUDENT_NO, STUDENT_ID, STUDENT_PW, STUDENT_NAME, MAJOR,STUDENT_DEL_FL
   - 학생 정보용 테이블
2. CLASS
    CLS_NO, CLS_NAME, MAJOR
   - 강의 정보용 테이블
3. REGISTER
   REG_NO, CLS_NO, CLS_NAME, STUDENT_NO, MAJOR
   - 학생들이 수강신청한 내역을 담아두는 테이블
   - 
## 페이지 설명
### 로그인 페이지
서버를 키면 나오는 가장 첫 화면이다.
아이디와 비밀번호를 치면 input값을 STUDENT 테이블에서 찾아 있으면 로그인, 없으면 메시지를 반환한다.
아이디와 비밀번호란 밑에는 회원가입과 아이디찾기를 할 수 있는 링크를 구현하였다.
![스크린샷(98)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/90e353dc-42f0-4fd4-939c-1db2fe72038a)


### 회원가입 페이지
로그인 페이지에서 회원가입 글자를 누르면 이동하는 페이지다.
아이디, 비밀번호, 이름, 전공을 입력받아 테이블에 추가하고 각각 유효성 검사를 통해 일치하지 않는 형식이면 빨간 input바탕과 innertext로 일치하지 않음을 나타내고 일치하게 작성하는 경우 사라진다.
또한 회원가입을 눌렀을 때 아이디 중복을 검사해 이미 존재하는 아이디이면 중복된 아이디라는 alert창과 함께 회원가입에 실패하고 돌아가게 된다.
회원가입에 성공할 경우 다시 로그인 창으로 돌아가 로그인을 수행할 수 있도록 한다.


![스크린샷(99)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/c7e18a95-9b12-422f-b0b9-aac1f3967b15)
![스크린샷(100)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/ce6eaa1f-5cdb-4bf2-8cce-6a3624cd89da)
![스크린샷(101)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/394a2ac6-7d8e-4dfd-a60c-17a3b123530d)

### 아이디 찾기
로그인페이지에서 아이디 찾기 글자를 누르면 이동하는 페이지다.
본인의 학번과 전공을 입력하면 본인의 아이디를 찾을 수 있다.
이때 전공은 정확한 이름이 아닌 간단한게 작성하여도 조회가 가능하다
EX) 컴퓨터공학과  -> 컴퓨터 로 작성하여도 조회가능
![스크린샷(103)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/3c7638b9-9ad2-4b79-a3dd-42e97eff5952)
![스크린샷(105)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/c53d31a6-d73a-484b-bf53-7050177588c7)

### 메인페이지
로그인 시 제일 먼저 보이는 페이지이다.
신청하기 버튼을 누르면 신청이 가능하고 이미 신청한 강의일 경우 중복신청을 할 수 없도록 하였다.
신청할 수 있는 과목은 본인의 과에 맞춰 다르게 나타난다.
만약 본인의 과에 개설되어있는 과목이 없는 경우 개설된 강의가 없다는 문구가 나타나며 학과 수정과 로그아웃만 가능하다.
![스크린샷(110)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/e6f71fb4-80ac-4a6b-83b9-d169b9545b74)
![스크린샷(108)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/db704c7d-586f-402f-9eb0-f770a59e5fe0)
![스크린샷(107)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/b33f9607-f933-4948-bed8-3f8eb619aeb3)
![스크린샷(109)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/8a20d97a-aa2a-473a-acba-6ced5ce301ad)

### 신청 내역 조회
메인페이지에서 신청 내역 조회를 누르면 나오는 페이지이다. 
본인이 메인페이지에서 신청했던 내역들을 조회할 수 있고 취소 또한 가능하다.
취소 시 확인 문구가 뜨고 확인을 누르면 내역에서 사라지며 나머지 내역들이 조회된다.
신청한 내역이 없을 경우 "신청한 강의가 없습니다" 문구가 보여지게 된다.

![스크린샷(114)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/2408884b-99a7-44f0-bc16-f28792a00a37)
![스크린샷(112)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/bc02e735-2dc5-45a2-a44a-a174ea5ea4bb)
![스크린샷(113)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/8210c172-e56d-4058-b811-098e44d20c77)

### 학생 정보 조회
메인페이지에서 학생 정보 조회를 누르면 나타나는 페이지이다.
본인의 학번, 이름, 전공이 나온다.
![스크린샷(115)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/8d06dbd6-3ae6-4074-bc73-98f7d729ee14)

### 학과 수정
메인페이지에서 학과 수정을 누르면 나타나는 페이지이다.
전과를 하였다는 가정하에 본인이 전과하는 과를 입력하면 학생의 과가 수정되고 이에 따라 <b>메인 화면에 나타나는 신청 가능한 과목 또한 수정된 과에 맞추어 나타나게 된다.</b>
만약 수정한 학과에 신청 가능한 강의가 없다면 메인페이지에서와 동일하게 "개설된 강의가 없습니다."라는 문구가 보여진다.
![스크린샷(116)](https://github.com/hyunsoda/CourseRegisterProgram/assets/145172657/370280d6-59e9-472a-81ea-1401b2141bf4)






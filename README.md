
# Google-keep-clone

 Spring + 메모 게시판 사이트  
   
 <br>
 
## 프로젝트 소개
 Google-keep사이트 기능을 참고하여 만든 메모 게시판 사이트입니다.

<br>

## ⚙ 개발환경

 💻 Frontend
---

- #### **HTML, CSS, JavaScript**


 🌐 Backend
---
- #### **Language: ```Java```**
- #### **Framework: ```Spring Boot```**
- #### **ORM**: ```JPA```
- #### **Database**: ```H2```

<br>

## 메인 화면

<div align="center">
  <img src="/image/google-keep-main.png" width="900" height="500">
</div>

<br>

## 📌 상세 기능

#### 노트 읽기

- DB 접근
- 모든 노트 정보 가져오기
- 해당 노트를 프론트엔드에 전달 및 출력

#### 노트 생성

- 입력된 노트 정보(제목, 본문, 배경색, 핀 여부) 백엔드 전달
- 전달된 노트 정보를 DB내 저장

#### 노트 삭제

- 삭제할 노트 ID값을 백엔드 전달
- DB접근 후 동일한 ID값을 가진 노트 삭

#### 노트 수정

- 프론트에서 백엔드로 변경사항(제목, 본문 배경색, 핀 여부)이 발생한 부분만 데이터 전송
- null값을 제외한 변경 데이터와 업데이트 날자를 DB에 

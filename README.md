# web-study

Java Web / Servlet / JSP 기반 웹 프로그래밍 학습 레포지토리입니다.  
기본 HTML 실습부터 Servlet + JDBC CRUD 프로젝트까지 단계별로 정리되어 있습니다.

### 기술 스택

- Java
- Servlet / JSP
- Apache Tomcat (Local Server)
- JDBC
- Oracle Database

---

## ⭐ Main Project

### 📂 servlet-jdbc-emaillist

Servlet + JDBC 기반 이메일 리스트 CRUD 학습 프로젝트

- **주요 기능**

  - 이메일 등록 / 조회 / 삭제 (CRUD)
  - Servlet + DAO + VO 구조
  - JSP 기반 View 분리
  - JDBC 커넥션 매니저(DBConnectionMgr) 사용
  - Tomcat 환경에서 Servlet을 배포하고 Oracle DB와 JDBC로 연동

- **구성 요약**
```text
  servlet-jdbc-emaillist
  ├─ src/main
  │ ├─ DBConnectionMgr.java
  │ ├─ EmaillistDao.java
  │ ├─ EmaillistServlet.java
  │ └─ EmaillistVo.java
  ├─ web
  │ ├─ index.html
  │ ├─ index.jsp
  │ └─ WEB-INF/web.xml
  └─ lib
```

- **학습 포인트**

  - Java Web 기본 MVC 구조 이해
  - Servlet 요청/응답 흐름
  - JDBC 기반 DB 연동
  - Git 커밋 단위 관리 실습

---

## 📦 Practice Projects

### 📂 board

- 게시판 형태의 기본 CRUD 구조 연습
- Servlet / JSP 기본 흐름 학습 목적

### 📂 web-album

- 정적 웹 페이지 구조 및 리소스 관리 실습
- HTML / CSS 기반 웹 구성 연습

### 📂 naver-join-form

- 네이버 회원가입 화면 클론
- HTML Form 구조 및 입력 요소 학습

---

## 🧠 Study Focus

- Java Web 기본 개념 정리
- Servlet & JSP 실습
- JDBC 연동 경험
- Git을 활용한 단계적 커밋 관리

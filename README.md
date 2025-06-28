# 🛏️ CozyHouse

Spring Boot로 제작한 가구 쇼핑몰 CRUD 웹사이트

## 📑 Table of Contents

1. [소개](#소개)
2. [기술 스택](#기술-스택)
3. [주요 기능](#주요-기능)
4. [ERD](#ERD)
5. [화면 캡처](#화면-캡처)
6. [개발 후기](#개발-후기)

## 📝 소개

CozyHouse는 가구를 판매하는 쇼핑몰 웹사이트입니다.  
Spring Boot와 Thymeleaf를 이용해 백엔드와 프론트엔드를 통합 개발하였고,  
CRUD 기능과 검색 기능을 통해 실제 상품 관리 및 조회가 가능합니다.

- **개발 기간:** 2025.04 ~ 2025.05
- **개발 인원:** 개인 프로젝트

## ⚙️ 기술 스택

- **Backend:** Spring Boot, Spring MVC, Spring Security, JPA, MySQL
- **Frontend:** Thymeleaf, HTML, CSS, JavaScript
- **Build Tool:** Gradle
- **IDE:** IntelliJ IDEA
- **VCS:** Git, GitHub

## ✨ 주요 기능

- 회원가입, 로그인/로그아웃 (Spring Security)
- 상품 등록, 조회, 수정, 삭제 (CRUD)
- 상품 리스트 페이지네이션
- 상품 검색 기능
- 상품 이미지 업로드 및 출력
- Thymeleaf를 활용한 서버사이드 렌더링

## 🗂 ERD

![ERD](images/erd.png)

## 🖼️ 화면 캡처

### 🔷 메인 페이지

![메인페이지](images/main.png)

### 🔷 상품 등록 페이지

![상품등록](images/add.png)

## 💡 개발 후기

- 처음으로 Spring Security를 적용하며 로그인/회원가입 기능을 구현했고, SecurityConfig의 흐름을 학습할 수 있었습니다.
- JPA를 활용해 CRUD 로직을 간결하게 작성할 수 있었고, 프론트엔드와 백엔드의 연동을 경험하며 웹 개발 전반의 흐름을 이해하게 되었습니다.

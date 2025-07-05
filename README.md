# 🛏️ CozyHouse

Spring Boot로 제작한 가구 쇼핑몰 CRUD 웹사이트

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

## ✨ 주요 기능 및 구현 방식

- **회원가입**
  - Spring Security + BCryptPasswordEncoder로 비밀번호 암호화 후 저장
- **로그인/로그아웃**
  - Spring Security의 세션 기반 인증 적용, SecurityConfig로 커스터마이징
- **상품 등록/수정/삭제 (CRUD), 댓글, 주문기능**
  - Spring Data JPA의 JpaRepository 사용
  - Authtentication 객체를 이용하여 로그인 여부 판별
- **상품 이미지 업로드**
  - 이미지 파일을 S3에 업로드 후, S3 주소를 DB에 저장
- **상품 리스트 페이지네이션**
  - Spring Data JPA의 Pageable 메서드 활용
- **상품 검색**
  - Repository에 SQL쿼리로 제목을 조회하는 메서드 정의하여 구현

## 🗂 ERD

<img src="images/ERD.png" alt="ERD" width="600" height="400"/>

## 🖼️ 화면 캡처

### 🔷 실행 영상

### 🔷 메인 페이지

![메인페이지](images/main.png)

### 🔷 상품 등록 페이지

![상품등록](images/add.png)

## 💡 개발 후기

- springboot를 이용해 만든 제 첫 번째 프로젝트입니다. 겉으로 보여지는 것들보다는 기능 구현에 집중하여 만들었습니다.
- Spring Security, JPA를 사용해 간결하고 효율적인 기능구현을 할 수 있었습니다.
- 또한 Controller, Service, Repository 계층을 만들며 웹 개발 전반의 흐름을 이해할 수 있었습니다.

 **아쉬운 점**

- 개발 화면을 캡처가 아닌 직접 배포해 보고 싶었지만 권한에 대한 설정을 하지 않아서 누구나 데이터베이스에 접근이 가능했습니다. 때문에 다음 프로젝트에서는 이러한 문제들을 해결해 직접 웹페이지를 배포해 보고 싶습니다.
- 프로젝트를 시작할 때 적절한 데이터베이스 구조를 세우지 않고 그때마다 생각나는 대로 만들었습니다. 그러다 보니 추후에 ERD를 작성하며 데이터 무결성에 위배되는 코드가 너무 많았고, 구조를 다시 바꾸느라 DB뿐만 아니라 다른 코드들도 대대적인 수정을 해야 했습니다. ERD를 먼저 작성하고 적절한 DB 구조를 미리 구상해 놓는 것이 얼마나 중요한 일인지 깨닫게 되었습니다.
- DTO에 대한 개념을 프로젝트가 어느 정도 완성되고 나서 알게 되었습니다. 때문에 이미 대부분의 메서드들이 리포지토리에 작성되어 있었고, 소수의 메서드들만 DTO에 옮길 수 있었습니다.

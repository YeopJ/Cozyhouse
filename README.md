# 🛋 CozyHouse - 가구 쇼핑몰 웹사이트

CozyHouse는 Spring Boot 기반의 서버 렌더링 웹 애플리케이션입니다.  
사용자는 다양한 가구 상품을 검색하고, 등록 및 관리할 수 있습니다.

---

## 📸 데모 이미지


---

## 📌 주요 기능
- 회원가입 / 로그인 / 마이페이지
- 가구 상품 등록 / 수정 / 삭제 (CRUD)
- 상품 검색 기능
- 에러 처리 페이지, 알림 페이지
- 정적 CSS 스타일링

---

## 🛠 사용 기술 스택

### Backend & View
- Java 11+
- Spring Boot
- Spring MVC (Thymeleaf 기반 템플릿 렌더링)
- Spring Data JPA
- MySQL / H2
- HTML5 / CSS3 / JavaScript (Vanilla JS)

---

## 📁 주요 디렉토리 구조

```plaintext
src/main/
├── java/...
├── resources/
│   ├── static/
│   │   ├── main.css
│   │   └── index.html
│   └── templates/
│       ├── list.html, login.html, write.html 등

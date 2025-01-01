# 이커머스 서비스 프로젝트 마일스톤

## 프로젝트 개요
- **주요 목표**
  - **[목표 1]**
    - 1-1 : 시나리오 선정 및 Milestone 작성
    - 1-2 : 요구사항에 따른 시퀀스 다이어그램, 플로우 차트 작성
  - **[목표 2]**
    - 2-1 : ERD 설계 작성
    - 2-2 : API 명세 및 Mock API 작성
    - 2-3 : 패키지 구조, 서버 구성도 작성

- **API Specs**
  - **[기본 기능]**
    - 상품 조회 API
    - 상위 상품 조회 API
  - **[주요 기능]**
      - 잔액 충전 / 조회 API
      - 주문 / 결제 API
      - 선착순 쿠폰 기능
---

## 마일스톤 구성

### 마일스톤 1: **프로젝트 계획 수립과 시나리오 설계**
- **목표**: 각 시나리오를 분석하고 구현 계획을 세웁니다.
- **작업 내용**:
  - 개발 환경 세팅
  - 마일스톤 작성
  - 시퀀스 다이어그램, 플로우 차트 작성.
  - API 명세 정의:
    - 엔드포인트, 요청 파라미터, 응답 데이터, 에러, 인증.
  - 도메인 분석을 바탕으로 ERD(Entity Relationship Diagram) 설계.
- **결과물**:
  - 마일스톤
  - 시퀀스 다이어그램과 플로우 차트.
  - API 명세 문서화.
  - ERD 설계 문서.

---

### 마일스톤 2: **API 개발 및 테스트**
- **목표**: 핵심 API를 구현하고 테스트합니다.
- **구현할 API**:
  1. **잔액 충전/조회 API**:
     - 사용자 잔액을 충전하고 현재 잔액을 조회.
  2. **상품 조회 API**:
     - 상품 정보(ID, 이름, 가격, 재고)를 조회.
  3. **선착순 쿠폰 발급 및 조회 API**:
     - 선착순 쿠폰 발급 및 유효 쿠폰 조회.
  4. **주문 및 결제 API**:
     - 사용자 잔액을 기반으로 주문 및 결제 처리.
  5. **인기 상품 조회 API**:
     - 최근 인기 상품 5개 조회.
- **작업 내용**:
  - 명세에 따라 API 개발.
  - 모든 기능에 대한 단위 테스트 작성.
  - 동시성 문제를 고려한 구현.
- **결과물**:
  - 완전한 기능을 갖춘 API.
  - Postman 등 도구를 활용한 Mock API.

---

### 마일스톤 3: **Mock API 및 통합 테스트**
- **목표**: API가 다른 시스템과 통합할 준비가 되었는지 확인합니다.
- **작업 내용**:
  - 더미 데이터를 활용한 Mock API 작성.
  - curl, Postman, HTTP 클라이언트를 사용한 통합 테스트.
  - 프론트엔드 및 다른 팀을 위한 API 사용법 문서화.
- **결과물**:
  - Mock API 서버 및 문서화.
  - 통합 테스트 결과.

---

## 타임테이블
| Milestone | Description | Hour |
| --- | --- | --- |
| **1** | **프로젝트 계획 수립과 시나리오 설계** | **8** |
| 1-1 | 마일스톤 작성 | 2 |
| 1-2 | 시퀀스 다이어그램과 플로우 차트 | 2 |
| 1-3 | API 명세 문서화 | 2 |
| 1-4 | ERD 설계 문서 | 2 |
| **2** | **API 개발 및 테스트** | **38** |
| 2-1 | 상품 조회 API | 4 |
| 2-2 | 잔액 충전/조회 API | 6 |
| 2-3 | 주문 및 결제 API | 4 |
| 2-4 | 인기 상품 조회 API | 5 |
| 2-5 | 선착순 쿠폰 발급/조회 API | 6 |
| 2-6 | 각 기능별 단위 테스트 작성 | 8 |
| **3** | **Mock API 및 통합 테스트** | **8** |
| 3-1 | Mock API 서버 및 문서화 | 3 |
| 3-2 | 통합 테스트 작성 | 5 |
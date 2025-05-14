
# 📘 Spring Boot Microservices Architecture

```
spring-microservices/
├── api-gateway/
├── auth-service/
├── config-server/
├── discovery-server/
├── customer-service/
├── notification-service/
├── common-lib/
└── docker-compose.yml
```

## 🔹 รายละเอียดของแต่ละโฟลเดอร์

| Module                 | Description |
|------------------------|-------------|
| **api-gateway/**       | Gateway สำหรับรับ request ทั้งหมดจาก client แล้ว route ไปยัง microservice ที่เหมาะสม โดยใช้ Spring Cloud Gateway หรือ Spring MVC + Zuul |
| **auth-service/**      | บริการจัดการการยืนยันตัวตน (Authentication) และการสร้าง JWT Token เพื่อใช้ในระบบทั้งหมด |
| **config-server/**     | Spring Cloud Config Server สำหรับเก็บและให้บริการไฟล์ config (.yml) ของทุก service แบบ centralized |
| **discovery-server/**  | Eureka Server ที่ใช้สำหรับทำ Service Discovery ให้แต่ละ service ค้นหากันและกันได้โดยไม่ต้อง fix IP |
| **customer-service/**      | Microservice สำหรับจัดการข้อมูลผู้ใช้ |
| **notification-service/** | บริการสำหรับส่งการแจ้งเตือน เช่น email, line notify หรือ push notification |
| **common-lib/**        | ไลบรารีรวมของกลาง เช่น DTO, Utils, Enums ที่ใช้ร่วมกันระหว่าง service ทั้งหมด |
| **docker-compose.yml** | ไฟล์ที่ใช้สำหรับ run ทุก service พร้อมกันใน local ด้วย Docker |

---

## 🧭 แผนผังสถาปัตยกรรม

```
Client (Frontend/Mobile)
        ↓
   [API Gateway]
        ↓
 ┌───────────────┬────────────┬────────────┐
 | Auth Service  | User Svc   | Order Svc  |
 | Product Svc   | Noti Svc   | ...        |
 └───────────────┴────────────┴────────────┘
        ↓
[Discovery Server (Eureka)]
        ↓
[Config Server (Git + Config)]
```

---

## 🛠 เทคโนโลยีที่ใช้

- **Spring Boot** – สำหรับสร้างแต่ละ Microservice
- **Spring Cloud Netflix (Eureka)** – Service Discovery
- **Spring Cloud Gateway** – API Gateway
- **Spring Cloud Config** – Configuration management
- **Spring Security + JWT** – สำหรับ Auth
- **Docker / Docker Compose** – สำหรับ containerization
- **Jenkins (CI/CD)** – สำหรับ automate build/test/deploy
- **Sql Server / PostgreSQL** – ใช้เป็นฐานข้อมูล
- **Redis / Kafka (optional)** – ใช้สำหรับ caching หรือ async messaging

---

## 📦 วิธีรันในเครื่อง (Dev)

```bash
docker-compose up --build
```

หรือจะใช้ Spring Boot CLI รันแต่ละ service:

```bash
cd discovery-server && ./mvnw spring-boot:run
cd config-server && ./mvnw spring-boot:run
cd api-gateway && ./mvnw spring-boot:run
cd user-service && ./mvnw spring-boot:run
...
```
